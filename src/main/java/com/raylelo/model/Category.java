package com.raylelo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoryId")
	private Long categoryId;
	private String categoryName;
	private String categoryDesc;
	private String status;

}
