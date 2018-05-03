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
@Table(name = "AAMENU")
public class AaMenu extends BaseModelImpl<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5841366537443980893L;

	@Column(name = "RNAME")
	private String menuName;

	@Column(name = "VIEW_ORDER")
	private Integer viewOrder;

	@Column(name = "TARGET_PAGE")
	private String targetPage;
	@Column(name = "MAIN_CLASS")
	
	private String mainClass;

	@Column(name = "PARENT_MENU_ID")
	private Long parentMenuId;

	@Column(name = "ICON")
	private String icon;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getViewOrder() {
		return viewOrder;
	}

	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}

	public String getMainClass() {
		return mainClass;
	}

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	public Long getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
