package com.godknows.githubAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.godknows.githubAPI.dtos.PagedUserDTO;
import com.godknows.githubAPI.dtos.UserDTO;

@Service
public class GitHubService {
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	public PagedUserDTO getPagedUser(Long since) {
		ParameterizedTypeReference<List<UserDTO>> responseType = new ParameterizedTypeReference<List<UserDTO>> () {};
		ResponseEntity<List<UserDTO>> result = restTemplate.exchange("https://api.github.com/users?since=" + since, HttpMethod.GET,null, responseType);
		PagedUserDTO dto = new PagedUserDTO();
		dto.setContent(result.getBody());
		long newSince = result.getBody().get(result.getBody().size()-1).getId();
		dto.setNext("http://localhost:8080/api/users?since=" + newSince);
		return dto;
	}

}
