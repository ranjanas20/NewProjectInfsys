package com.bugsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "importance_master")
public class ImportanceEntity {

	@Id
	@Column(name = "code")
	private String impCode;
	
	@Column(name = "description")
	private String impDescription;

	public ImportanceEntity() {

	}
	
	public ImportanceEntity(String impCode) {
		super();
		this.impCode = impCode;
	}

	public String getImpCode() {
		return impCode;
	}

	public void setImpCode(String impCode) {
		this.impCode = impCode;
	}

	public String getImpDescription() {
		return impDescription;
	}

	public void setImpDescription(String impDescription) {
		this.impDescription = impDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((impCode == null) ? 0 : impCode.hashCode());
		result = prime * result + ((impDescription == null) ? 0 : impDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportanceEntity other = (ImportanceEntity) obj;
		if (impCode == null) {
			if (other.impCode != null)
				return false;
		} else if (!impCode.equals(other.impCode))
			return false;
		if (impDescription == null) {
			if (other.impDescription != null)
				return false;
		} else if (!impDescription.equals(other.impDescription))
			return false;
		return true;
	}
	
	
}

