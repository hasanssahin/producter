package com.hasansahin.producter.controller;

import com.hasansahin.producter.business.PlayerService;
import com.hasansahin.producter.dto.reponse.PlayerCreateResponse;
import com.hasansahin.producter.dto.request.PlayerCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostMapping("/add")
	public ResponseEntity<PlayerCreateResponse> createPlayer(@RequestBody PlayerCreateRequest playerCreateRequest){
		return ResponseEntity.ok(playerService.createPlayer(playerCreateRequest));
	}

	@DeleteMapping("/{playerID}")
	public void deletePlayer(@PathVariable Long playerID){
		playerService.deletePlayer(playerID);
	}

	@GetMapping
	public ResponseEntity<List<PlayerCreateResponse>> listAllPlayer(){
		return ResponseEntity.ok(playerService.listAllPlayer());
	}
}
