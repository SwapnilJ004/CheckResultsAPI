package com.resultsDeclaration.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "elections")
@Entity
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ElectionType type;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
	private EpollUser createdBy;
	@Column(name = "status")
	private ElectionStatus status;
	
	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public int getId(){
		return id;
	}
	public void setId(int electionId){
		this.id = electionId;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public ElectionType getElectionType(){
		return type;
	}
	public void setElectionType(ElectionType electionType){
		this.type = electionType;
	}
	public LocalDateTime getStartDate(){
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate){
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate(){
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate){
		this.endDate = endDate;
	}
	public EpollUser getCreatedBy(){
		return createdBy;
	}
	public void setCreatedBy(EpollUser createdBy){
		this.createdBy = createdBy;
	}
	public ElectionStatus getElectionStatus(){
		return status;
	}
	public void setElectionStatus(ElectionStatus status){
		this.status = status;
	}
	public LocalDateTime getCreatedAt(){
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt){
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt(){
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt){
		this.updatedAt = updatedAt;
	}
}

