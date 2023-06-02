package com.hefshine.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 private String projectName;
	  private String reason;
	  private String   division;
	  private String   department;
	  private Date  startDate;
	  private Date    endDate;
	  private String   location;
	  private String  status="Register";
	  

}
