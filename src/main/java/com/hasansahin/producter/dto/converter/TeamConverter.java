package com.hasansahin.producter.dto.converter;

import com.hasansahin.producter.dto.reponse.TeamResponse;
import com.hasansahin.producter.entity.Player;
import com.hasansahin.producter.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamConverter {

	private final PlayerConverter playerConverter;

	public TeamConverter(PlayerConverter playerConverter) {
		this.playerConverter = playerConverter;
	}

	public TeamResponse convertTeamToTeamResponse(Team team){
		Player player = team.getPlayers().isEmpty() ? null : team.getPlayers().get(0);
		if(player == null){
			throw new RuntimeException();
		}
		playerConverter.convertPlayerToPlayerCreateResponse(player);
		return new TeamResponse(team.getId(), playerConverter.convertPlayerToPlayerCreateResponse(player));
	}

	public List<TeamResponse> convertTeamToTeamResponseList(List<Team> teams){
		return teams.stream().map(this::convertTeamToTeamResponse).collect(Collectors.toList());
	}
}
