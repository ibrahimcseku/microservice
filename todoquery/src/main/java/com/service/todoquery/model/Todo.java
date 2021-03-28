package com.service.todoquery.model;

public class Todo {

	private Integer id;

	private String userName;

	private String todoItem;

	public Todo() {

	}

	public Todo(String userName, String todoItem) {
		this.userName = userName;
		this.todoItem = todoItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}

}
