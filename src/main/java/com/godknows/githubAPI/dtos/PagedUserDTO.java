package com.godknows.githubAPI.dtos;

import java.util.ArrayList;
import java.util.List;

public class PagedUserDTO {
	
	private List<UserDTO> content = new ArrayList<>();
	private String next;
	
	
	public List<UserDTO> getContent() {
		return content;
	}
	public void setContent(List<UserDTO> content) {
		this.content = content;
	}
	
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}

}
