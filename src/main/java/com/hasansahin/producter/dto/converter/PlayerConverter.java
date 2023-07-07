package com.hasansahin.producter.dto.converter;

import com.hasansahin.producter.dto.reponse.PlayerCreateResponse;
import com.hasansahin.producter.dto.request.PlayerCreateRequest;
import com.hasansahin.producter.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerConverter {
	public Player convertPlayerCreateRequestToPlayer(PlayerCreateRequest playerCreateRequest){
		return new Player(playerCreateRequest.getName(),playerCreateRequest.getSurname(),playerCreateRequest.getPosition());
	}

	public PlayerCreateResponse convertPlayerToPlayerCreateResponse(Player player){
		return new PlayerCreateResponse(player.getId(),player.getName(),player.getSurname(),player.getPosition());
	}

	public List<PlayerCreateResponse> convertPlayerToPlayerCreateResponseList(List<Player> playerList){
		return playerList.stream().map(this::convertPlayerToPlayerCreateResponse).collect(Collectors.toList());
	}
}
