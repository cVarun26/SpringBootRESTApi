package com.example.SpringRESTMySql.Service.impl;

import com.example.SpringRESTMySql.DTO.UserDTO;
import com.example.SpringRESTMySql.Entity.User;
import com.example.SpringRESTMySql.Repo.UserRepo;
import com.example.SpringRESTMySql.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;



    public void updateUser(Integer id, User user) {
      userRepo.findById(id)
              .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));
    }

    @Override
    public void addUser(User user) {
    userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user=userRepo.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        User user=userRepo.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

        userRepo.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user=userRepo.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+id));

        user.setName(userDTO.getName());
        userRepo.save(user);
    }


}
