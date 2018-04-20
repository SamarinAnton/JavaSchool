package ru.tsystems.javaschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tsystems.javaschool.dto.CityDTO;
import ru.tsystems.javaschool.dto.UserDTO;
import ru.tsystems.javaschool.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getUser() {
        return userService.getById(1);
    }
}
