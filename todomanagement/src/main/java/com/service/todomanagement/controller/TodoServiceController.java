package com.service.todomanagement.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.todomanagement.model.Todo;
import com.service.todomanagement.model.Todos;
import com.service.todomanagement.repository.TodosRepository;

@RestController
@RequestMapping("/rest/db")
public class TodoServiceController {

	@Autowired
	private TodosRepository todosRepository;

	@GetMapping("/{username}")
	public List<String> getTodos(@PathVariable("username") final String username) {

		return getTodosByUserName(username);
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Todos todos) {

		todos.getTodos().stream().map(todo -> new Todo(todos.getUserName(), todo))
				.forEach(todo -> todosRepository.save(todo));

		return getTodosByUserName(todos.getUserName());
	}

	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username) {

		List<Todo> todos = todosRepository.findByUserName(username);
		todos.stream().filter(todo -> username.equals(todo.getUserName()))
				.forEach(todo -> todosRepository.delete(todo));
		return getTodosByUserName(username);
	}

	private List<String> getTodosByUserName(@PathVariable("username") String username) {
		return todosRepository.findByUserName(username).stream().map(Todo::getTodoItem).collect(Collectors.toList());
	}

}
