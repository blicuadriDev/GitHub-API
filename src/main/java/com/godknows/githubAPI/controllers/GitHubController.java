package com.godknows.githubAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.githubAPI.dtos.PagedUserDTO;
import com.godknows.githubAPI.services.GitHubService;

@RestController
@RequestMapping(value="/api")
public class GitHubController {
	
	@Autowired
	private GitHubService githubService;
	
	
	@GetMapping(value="/users")
	public ResponseEntity<PagedUserDTO> getPagedUser (@RequestParam(name="since", defaultValue="0") Long since) {
		PagedUserDTO dto = githubService.getPagedUser(since);
		return ResponseEntity.ok(dto);
		
	}

}
