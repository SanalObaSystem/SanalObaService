package org.oba.portal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Bahadr
 *
 */
@Entity
@Table(name = "AAUSER")
public class AaUser extends BaseModelImpl<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6696794476397988758L;

	@Column(name = "LOGINNAME")
	private String loginname;

	@Column(name = "PASSWORD")
	@JsonIgnore
	private String password;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AAGROUPUSER"
				, joinColumns = @JoinColumn(name = "USERID", referencedColumnName = "RID")
				, inverseJoinColumns = @JoinColumn(name = "GROUPID", referencedColumnName = "RID"))
	private List<AaGroup> groups;

	public AaUser() {
	}
	public AaUser(AaUser user) {
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.loginname = user.loginname;
		this.password = user.password;
		this.rid = user.rid;
		this.groups = user.groups;
		this.createdBy = user.createdBy;
		this.updatedBy = user.updatedBy;
		this.creationTime = user.creationTime;
		this.updateTime = user.updateTime;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<AaGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AaGroup> groups) {
		this.groups = groups;
	}
}
