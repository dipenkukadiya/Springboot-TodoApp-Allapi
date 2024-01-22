package com.example.Coder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Coder.Entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
