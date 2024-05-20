package com.raylelo.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long jobId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
	private String title;
	private Date addedDate;
	private String shortInfo;
	private String advtNumber;
	private String jobName;
	private String impDates;
	private String applFee;
	private String ageLimit;
	private String vacancyDetails;
	private String stepsToFill;
	private String applyOnline;
	private String notificationHindi;
	private String notificatioinEng;
	private String offShortNotice;
	private String shortNotice;
	private String offWebsite;
	private String status;
	private Boolean isTile;
	private String tileName;
	private String tileType;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private String updatedDate;
	

}
