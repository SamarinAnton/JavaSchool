package ru.tsystems.javaschool.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.dao.SubtaskDAO;
import ru.tsystems.javaschool.dto.SubtaskDTO;
import ru.tsystems.javaschool.entity.Subtask;
import ru.tsystems.javaschool.service.SubtaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubtaskServiceImpl implements SubtaskService{
    private SubtaskDAO subtaskDAO;

    @Autowired
    public SubtaskServiceImpl(SubtaskDAO subtaskDAO) {
        this.subtaskDAO = subtaskDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<SubtaskDTO> getAll() {
        return subtaskDAO.getAll().stream()
                .map(x -> {
                    SubtaskDTO subtaskDTO = new SubtaskDTO(x);
                    subtaskDTO.apply(x);
                    return subtaskDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public SubtaskDTO getById(int id) {
        Subtask subtask = subtaskDAO.getById(id);
        SubtaskDTO subtaskDTO = new SubtaskDTO(subtask);
        subtaskDTO.apply(subtask);
        return subtaskDTO;
    }
}
