package org.oba.portal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Bahadr
 *
 */
@Entity
@Table(name = "AAGROUP")
public class AaGroup extends BaseModelImpl<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2293741868196871683L;

	@Column(name = "RNAME")
	private String groupName;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AAPERM"
				, joinColumns = @JoinColumn(name = "GROUPID", referencedColumnName = "RID")
				, inverseJoinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "RID"))
	private List<AaRole> roles = null;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AAGROUPMENU"
				, joinColumns = @JoinColumn(name = "GROUPID", referencedColumnName = "RID")
				, inverseJoinColumns = @JoinColumn(name = "MENUID", referencedColumnName = "RID"))
	private List<AaMenu> menus = null;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AaRole> getRoles() {
		return roles;
	}

	public void setRoles(List<AaRole> roles) {
		this.roles = roles;
	}

	public List<AaMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<AaMenu> menus) {
		this.menus = menus;
	}
}
