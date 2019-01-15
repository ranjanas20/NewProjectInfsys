package com.bugsite.dto;

public class BugsCountDTO {
    
	private Long openBugs;
	private Long newBugs;
	private Long criticalBugs;
	private Long highBugs;
	public Long getOpenBugs() {
		return openBugs;
	}
	public void setOpenBugs(Long openBugs) {
		this.openBugs = openBugs;
	}
	public Long getNewBugs() {
		return newBugs;
	}
	public void setNewBugs(Long newBugs) {
		this.newBugs = newBugs;
	}
	public Long getCriticalBugs() {
		return criticalBugs;
	}
	public void setCriticalBugs(Long criticalBugs) {
		this.criticalBugs = criticalBugs;
	}
	public Long getHighBugs() {
		return highBugs;
	}
	public void setHighBugs(Long highBugs) {
		this.highBugs = highBugs;
	}
	
	
}
