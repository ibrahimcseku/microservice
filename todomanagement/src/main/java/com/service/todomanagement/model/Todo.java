package com.service.todomanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "todo", catalog = "microservice")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "todo_item")
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
