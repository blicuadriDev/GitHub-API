package com.godknows.githubAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.githubAPI.dtos.DetailedUserDTO;
import com.godknows.githubAPI.dtos.PagedUserDTO;
import com.godknows.githubAPI.dtos.RepoUserDTO;
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
	
	
	@GetMapping(value="/users/{username}/details")
	public ResponseEntity<DetailedUserDTO> getDetailedUser (@PathVariable String username) {
		DetailedUserDTO dto = githubService.getDetailedUser(username);
		return ResponseEntity.ok(dto);
	}
	
	
	@GetMapping(value="/users/{username}/repos")
	public ResponseEntity<List<RepoUserDTO>> getUsersRepo (@PathVariable String username) {
		List<RepoUserDTO> dto = githubService.getUsersRepo(username);
		return ResponseEntity.ok(dto);
	}
	

}
