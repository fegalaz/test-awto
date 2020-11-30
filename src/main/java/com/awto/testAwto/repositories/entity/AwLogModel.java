package com.awto.testAwto.repositories.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AW_LOG")
public class AwLogModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = true)
	private int id;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@Column(name = "host")
	private String host;

	@Column(name = "details")
	private String details;
	
	@OneToMany(mappedBy = "awLogModel")
    Set<AwHashtagLogModel> awHashtagLogModel;

}
