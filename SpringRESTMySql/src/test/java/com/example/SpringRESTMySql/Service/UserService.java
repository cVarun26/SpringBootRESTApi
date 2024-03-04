package com.example.SpringRESTMySql.Service;

import com.example.SpringRESTMySql.DTO.UserDTO;
import com.example.SpringRESTMySql.Entity.User;

import java.util.List;

public interface UserService {


    static void updateUser(Integer id, User user) {
    }



    void addUser(User user);


    List<User> getUsers();

    User getUser(Integer id);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
