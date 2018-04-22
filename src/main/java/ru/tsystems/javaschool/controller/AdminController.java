package ru.tsystems.javaschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tsystems.javaschool.dto.CityDTO;
import ru.tsystems.javaschool.dto.DriverDTO;
import ru.tsystems.javaschool.dto.UserDTO;
import ru.tsystems.javaschool.service.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private CityService cityService;
    private DriverService driverService;
    private VehicleService vehicleService;
    private OrderService orderService;
    private CargoService cargoService;

    @Autowired
    public void setService(UserService service, CityService cityService,
                           DriverService driverService, VehicleService vehicleService,
                           OrderService orderService, CargoService cargoService) {
        this.userService = service;
        this.cityService = cityService;
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.orderService = orderService;
        this.cargoService = cargoService;
    }

    //just for example
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public UserDTO getUser() {
//        return userService.getById(1);
//    }

    //home admin's page
    @RequestMapping(method = RequestMethod.GET)
    public String adminHome() {
        return "admin_home";
    }

    //pages linked with actions of cities
    @RequestMapping(value = "cities",method = RequestMethod.GET)
    public String adminCity(Model model) {
        model.addAttribute("cityDTO", new CityDTO());
        return "PageCity/cities";
    }

    @RequestMapping(value = "/cities/showAll",method = RequestMethod.GET)
    public String adminShowAllCities(Model model) {
        List<CityDTO> cities = cityService.getAll();
        model.addAttribute("cities", cities);
        return "PageCity/showAllCities";
    }

    @RequestMapping(value = "/cities/showById", method = RequestMethod.POST)
    public String adminShowCityById(@ModelAttribute("cityDTO") CityDTO cityDTO,
                                  BindingResult bindingResult, Model model) {
        model.addAttribute("cityDTO", cityService.getById(cityDTO.getId()));
        model.addAttribute("driverDTO", cityDTO.getDrivers());
        model.addAttribute("vehicleDTO", cityDTO.getVehicles());
        return "PageCity/city";
    }

    @RequestMapping(value = "/cities/showByName", method = RequestMethod.POST)
    public String adminShowCityByName(@ModelAttribute("cityDTO") CityDTO cityDTO,
                                  BindingResult bindingResult, Model model) {
        model.addAttribute("cityDTO", cityService.getByName(cityDTO.getName()));
        model.addAttribute("driverDTO", cityDTO.getDrivers());
        model.addAttribute("vehicleDTO", cityDTO.getVehicles());
        return "PageCity/city";
    }

    @RequestMapping(value = "/cities/add", method = RequestMethod.GET)
    public String adminAddNewCity(Model model) {
        model.addAttribute("cityDTO", new CityDTO());
        return "PageCity/addCity";
    }

    @RequestMapping(value = "/cities/add/city", method = RequestMethod.POST)
    public String adminNewCity(@ModelAttribute("cityDTO") CityDTO cityDTO,
                               BindingResult bindingResult, Model model) {
        int id = cityService.add(cityDTO);
        model.addAttribute("cityDTO", cityService.getById(id));
        model.addAttribute("driverDTO", cityDTO.getDrivers());
        model.addAttribute("vehicleDTO", cityDTO.getVehicles());
        return "PageCity/city";
    }


    //pages linked with actions of users
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public String adminUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "PageUser/users";
    }

    @RequestMapping(value = "/users/showAll",method = RequestMethod.GET)
    public String adminShowAllUsers(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "PageUser/showAllUsers";
    }

    @RequestMapping(value = "/users/showById", method = RequestMethod.POST)
    public String adminShowUserById(@ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult, Model model) {
        model.addAttribute("user", userService.getById(userDTO.getId()));
        return "PageUser/user";
    }

    @RequestMapping(value = "/users/showByLogin", method = RequestMethod.POST)
    public String adminShowUserByLogin(@ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult, Model model) {
        model.addAttribute("user", userService.getByLogin(userDTO.getLogin()));
        return "PageUser/user";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String adminAddNewUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "PageUser/addUser";
    }

    @RequestMapping(value = "/users/add/user", method = RequestMethod.POST)
    public String adminNewUser(@ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult, Model model) {
        int id = userService.add(userDTO);
        model.addAttribute("user", userService.getById(id));
        return "PageUser/user";
    }


    //pages linked with actions of cargoes
    @RequestMapping(value = "cargoes",method = RequestMethod.GET)
    public String adminCargo() {
        return "PageCargo/cargoes";
    }

    //pages linked with actions of orders
    @RequestMapping(value = "orders",method = RequestMethod.GET)
    public String adminOrder() {
        return "PageOrder/orders";
    }

    //pages linked with actions of drivers
    @RequestMapping(value = "drivers",method = RequestMethod.GET)
    public String adminDriver() {
        return "PageDriver/drivers";
    }

    @RequestMapping(value = "/drivers/showAll",method = RequestMethod.GET)
    public String adminShowAllDrivers(Model model) {
        List<DriverDTO> drivers = driverService.getAll();
        model.addAttribute("drivers",drivers);
        return "PageDriver/showAllDrivers";
    }

    @RequestMapping(value = "drivers/add", method = RequestMethod.GET)
    public String adminAddNewDriver(Model model) {
        model.addAttribute("driverDTO", new DriverDTO());
        return "PageDriver/addDriver";
    }

    @ResponseBody
    @RequestMapping(value = "drivers/add/driver", method = RequestMethod.POST)
    public DriverDTO adminNewDriver(@ModelAttribute("driverDTO") DriverDTO driverDTO,
                                    BindingResult bindingResult, Model model) {
        int id = driverService.add(driverDTO);
        return driverService.getById(id);
    }

    //pages linked with actions of vehicles
    @RequestMapping(value = "vehicles",method = RequestMethod.GET)
    public String adminVehicle() {
        return "PageVehicle/vehicles";
    }
}
