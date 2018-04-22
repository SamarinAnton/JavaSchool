package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.UserDAO;
import ru.tsystems.javaschool.dto.UserDTO;
import ru.tsystems.javaschool.entity.User;
import ru.tsystems.javaschool.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public UserDTO getByLogin(String login) {
        User user = userDAO.getByLogin(login);
        return new UserDTO(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public UserDTO getById(int id) {
        User user = userDAO.getById(id);
        return new UserDTO(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(UserDTO userDTO) {
        User user = new User();

        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());

        userDAO.insert(user);
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserDTO userDTO) {

        User user = userDAO.getByLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());

        userDAO.update(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<UserDTO> getAll() {
        return userDAO.getAll().stream()
                .map(x -> {
                    UserDTO userDTO = new UserDTO(x);
                    userDTO.apply(x);
                    return userDTO;
                }).collect(Collectors.toList());
    }
}
