package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.dao.TodoJpaRepository;
import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;

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

	public Todo saveOrUpdateTodo(Todo todo) {
		return repository.save(todo);
	}

	public Todo deleteById(long id) {
		Todo todo = repository.getOne(id);

		if (todo == null) {
			return null;
		}

		repository.deleteById(id);

		return todo;
	}

}