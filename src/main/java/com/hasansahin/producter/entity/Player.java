package com.hasansahin.producter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String position;
	private Date createdDate;

	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "team_id",referencedColumnName = "id")
	private Team team;

	public Player(String name, String surname, String position) {
		this.name = name;
		this.surname = surname;
		this.position = position;
	}
}
