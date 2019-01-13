package com.bugsite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bugsite.entity.Auditable;


@Entity
@Table(name = "bug")
public class BugEntity extends Auditable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "bug_id", nullable = false)
	private Long bugId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="status_code", referencedColumnName="code")    
    private StatusEntity statusEntity;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="importance_code", referencedColumnName="code")    
    private ImportanceEntity importanceEntity;
	
	public Long getBugId() {
		return bugId;
	}
	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StatusEntity getStatusEntity() {
		return statusEntity;
	}
	public void setStatusEntity(StatusEntity statusEntity) {
		this.statusEntity = statusEntity;
	}
	public ImportanceEntity getImportanceEntity() {
		return importanceEntity;
	}
	public void setImportanceEntity(ImportanceEntity importanceEntity) {
		this.importanceEntity = importanceEntity;
	}
	
}


	