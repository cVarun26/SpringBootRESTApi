package com.example.SpringRESTMySql.Controllers;

import com.example.SpringRESTMySql.DTO.UserDTO;
import com.example.SpringRESTMySql.Entity.User;
import com.example.SpringRESTMySql.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
       userService.addUser(user);

       return "user added";
    }

    @GetMapping
    public List<User> getUsers() {
    return userService.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
        public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user){

        UserService.updateUser(id,user);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){

        userService.updateName(id,userDTO);
        return ResponseEntity.noContent().build();
    }

}
