package com.example.SpringRESTMySql.Repo;

import com.example.SpringRESTMySql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
