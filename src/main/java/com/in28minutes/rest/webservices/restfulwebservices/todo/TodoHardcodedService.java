package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	@Autowired
	TodoJpaRepository repository;

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public List<Todo> findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public Optional<Todo> getTodo(long id) {
		return repository.findById(id);
	}

//	public Todo save(Todo todo) {
//		if (todo.getId() == -1 || todo.getId() == 0) {
//			todo.setId(++idCounter);
//			todos.add(todo);
//		} else {
//			deleteById(todo.getId());
//			todos.add(todo);
//		}
//		return todo;
//	}
//
//	public Todo deleteById(long id) {
//		Todo todo = findById(id);
//
//		if (todo == null)
//			return null;
//
//		if (todos.remove(todo)) {
//			return todo;
//		}
//
//		return null;
//	}
//
//	public Todo findById(long id) {
//		for (Todo todo : todos) {
//			if (todo.getId() == id) {
//				return todo;
//			}
//		}
//
//		return null;
//	}

}