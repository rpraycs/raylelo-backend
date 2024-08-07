package com.raylelo.model;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jobId")
	private Long jobId;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	 */
	/*
	 * @Column(name="category_id") private Long categoryId;
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
	@Column(name="title")
	private String title;
	@Column(name="addedDate")
	private Date addedDate;
	@Column(name="shortInfo")
	private String shortInfo;
	@Column(name="advtNumber")
	private String advtNumber;
	@Column(name="jobName")
	private String jobName;
	@Column(name="lastDateApply")
	private Date lastDateApply;
	@Column(name="impDates")
	private String impDates;
	@Column(name="applFee")
	private String applFee;
	@Column(name="ageLimit")
	private String ageLimit;
	@Column(name="vacancyDetails")
	private String vacancyDetails;
	@Column(name="stepsToFill")
	private String stepsToFill;
	@Column(name="applyOnline")
	private String applyOnline;
	@Column(name="notificationEng")
	private String notificationEng;
	@Column(name="notificationHnd")
	private String notificationHnd;
	@Column(name="offShortNotice")
	private String offShortNotice;
	@Column(name="shortNotice")
	private String shortNotice;
	@Column(name="offWebsite")
	private String offWebsite;
	@Column(name="status")
	private String status;
	@Column(name="tileStatus")
	private String tileStatus;
	@Column(name="tileName")
	private String tileName;
	@Column(name="tileType")
	private String tileType;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="createdDate") 
	@CreationTimestamp
	private Date createdDate;
	@Column(name="updatedBy")
	private String updatedBy;
	@Column(name="updatedDate") 
	@CreationTimestamp
	private Date updatedDate;
	
	@Transient
	private Long categoryId;
	
	
	public Jobs (Long jobId, String title, Date lastDateApply, Category category) {
		this.jobId = jobId;
		this.title = title;
		this.lastDateApply = lastDateApply;
		this.category = category;
	}
	
	public Jobs (Long jobId, String tileName, String tileType) {
		this.jobId = jobId;
		this.tileName = tileName;
		this.tileType = tileType;
		
	}
}
