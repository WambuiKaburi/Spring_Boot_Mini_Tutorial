package com.interntesting.demo.Controllers;

import com.interntesting.demo.Models.User;
import com.interntesting.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is the Controller for this API annotated by @RestController

@RestController @RequestMapping("/users") //For all requests made to users
public class UserController {

    UserService userService; //Instantiating an object of the service

    @Autowired //Injection of bean. Can be done by field or constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST) //Define request method
    public void addUser(@RequestBody User u){ //Coming from UI, equal to Request.getParameter, gets everything and maps to create an object
        userService.addUser(u); //Call service to add user u
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT) //Define request value(which is a variable) and method
    public User updateUser(@RequestBody User u, @PathVariable Long id){ //@PathVariable indicates that Long id is obtained from the variable in the path
        u.setId(id); //Set id that will be found by the service and used to update this user
        return userService.updateUser(u, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
