package com.bugsite.dto;

public class BugDTO extends AuditableDTO {
	private Long bugId;
	private String title;
	private String description;
	private String statusCode;
	private String importanceCode;
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
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getImportanceCode() {
		return importanceCode;
	}
	public void setImportanceCode(String importanceCode) {
		this.importanceCode = importanceCode;
	}
}
