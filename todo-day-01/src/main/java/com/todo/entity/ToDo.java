package com.todo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class ToDo {
	@Id
	@GeneratedValue
	private Integer id;
	private String content;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", content=" + content + ", status=" + status + "]";
	}
}
