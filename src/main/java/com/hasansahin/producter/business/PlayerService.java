package com.hasansahin.producter.business;

import com.hasansahin.producter.dto.converter.PlayerConverter;
import com.hasansahin.producter.dto.reponse.PlayerCreateResponse;
import com.hasansahin.producter.dto.request.PlayerCreateRequest;
import com.hasansahin.producter.entity.Player;
import com.hasansahin.producter.entity.enums.Positions;
import com.hasansahin.producter.exception.CreatePlayerException;
import com.hasansahin.producter.exception.FullTeamException;
import com.hasansahin.producter.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class PlayerService {
	private final PlayerConverter playerConverter;
	private final PlayerRepository playerRepository;

	private final TeamService teamService;

	public PlayerService(PlayerConverter playerConverter, PlayerRepository playerRepository, TeamService teamService) {
		this.playerConverter = playerConverter;
		this.playerRepository = playerRepository;
		this.teamService = teamService;
	}

	public PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest) {
		if(playerRepository.count()>=10){
			throw new FullTeamException("Takım doldu");
		}
		playerCreateRequest.setPosition(playerCreateRequest.getPosition().trim());
		if(playerCreateRequest.getPosition()!=null && !playerCreateRequest.getPosition().isEmpty()){
			try{
				Positions.valueOf(playerCreateRequest.getPosition().toUpperCase(Locale.ENGLISH).replace(" ","_"));
			}catch (IllegalArgumentException e){
				throw new CreatePlayerException("Yanlış pozisyon girdisi");
			}
			Player player = playerConverter.convertPlayerCreateRequestToPlayer(playerCreateRequest);
			player.setCreatedDate(new Date());
			teamService.addPlayer(player);
			playerRepository.save(player);
			return playerConverter.convertPlayerToPlayerCreateResponse(player);
		}else{
			throw new CreatePlayerException("Pozisyon bilgisi boş");
		}

	}

	public void deletePlayer(Long playerID) {
		playerRepository.deleteById(playerID);
	}

	public List<PlayerCreateResponse> listAllPlayer() {
		return playerConverter.convertPlayerToPlayerCreateResponseList(playerRepository.findAll());
	}
}
