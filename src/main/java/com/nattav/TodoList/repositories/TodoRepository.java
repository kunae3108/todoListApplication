package com.nattav.TodoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nattav.TodoList.entities.InfTodoObj;

@Repository
public interface TodoRepository extends JpaRepository<InfTodoObj, Long>
{

}
