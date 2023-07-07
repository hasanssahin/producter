package com.hasansahin.producter.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerCreateResponse {
	private Long id;
	private String name;
	private String surname;
	private String position;
}
