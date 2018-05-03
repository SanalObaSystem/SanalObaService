package org.oba.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Bahadr
 *
 */
@Entity
@Table(name = "AAROLE")
public class AaRole extends BaseModelImpl<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1438138656816858515L;

	@Column(name = "RNAME")
	private String roleName;

	@Column(name = "DESCRIPTION")
	private String description;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
