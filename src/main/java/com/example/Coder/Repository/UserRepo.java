package com.example.Coder.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Coder.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByemail(String email);

    User findByUsername(String username);


  

}
