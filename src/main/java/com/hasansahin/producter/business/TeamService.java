package com.hasansahin.producter.business;

import com.hasansahin.producter.dto.converter.TeamConverter;
import com.hasansahin.producter.dto.reponse.TeamResponse;
import com.hasansahin.producter.entity.Player;
import com.hasansahin.producter.entity.Team;
import com.hasansahin.producter.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
	private final TeamRepository teamRepository;
	private final TeamConverter teamConverter;

	public TeamService(TeamRepository teamRepository, TeamConverter teamConverter) {
		this.teamRepository = teamRepository;
		this.teamConverter = teamConverter;
	}

	public void addPlayer(Player player){
		Team team=new Team();
		player.setTeam(team);
		team.addPlayer(player);
		teamRepository.save(team);
	}

	public List<TeamResponse> listTeam(){
		List<Team> teams=teamRepository.findAll();
		return teamConverter.convertTeamToTeamResponseList(teams);
	}
}
