package com.hasansahin.producter.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerCreateRequest {
	private String name;
	private String surname;
	private String position;
}
