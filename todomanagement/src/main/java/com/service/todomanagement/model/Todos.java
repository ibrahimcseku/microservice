package com.service.todomanagement.model;

import java.util.List;

public class Todos {
	private String userName;
	private List<String> todos;

	public Todos() {
	}

	public Todos(String userName, List<String> todos) {
		this.userName = userName;
		this.setTodos(todos);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getTodos() {
		return todos;
	}

	public void setTodos(List<String> todos) {
		this.todos = todos;
	}

}
