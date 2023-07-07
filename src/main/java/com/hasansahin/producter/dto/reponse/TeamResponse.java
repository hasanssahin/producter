package com.hasansahin.producter.dto.reponse;

import com.hasansahin.producter.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {
	private Long id;
	private PlayerCreateResponse player;
}
