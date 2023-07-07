package com.hasansahin.producter.controller;

import com.hasansahin.producter.business.TeamService;
import com.hasansahin.producter.dto.reponse.TeamResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
	private final TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@GetMapping("/players")
	public ResponseEntity<List<TeamResponse>> listTeam(){
		List<TeamResponse> teamList=teamService.listTeam();
		System.out.println(teamList);
		return ResponseEntity.ok(teamList);
	}
}
