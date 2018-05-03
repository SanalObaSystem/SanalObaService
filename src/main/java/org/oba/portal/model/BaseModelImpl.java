package org.oba.portal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.oba.portal.base.BaseModel;

@MappedSuperclass
public class BaseModelImpl<I> extends BaseModel<I> {

	private static final long serialVersionUID = -5987478487374556908L;

	@Column(name = "CREATION_TIME")
	protected LocalDateTime creationTime;

	@Column(name = "UPDATE_TIME")
	protected LocalDateTime updateTime;

	@Column(name = "CREATED_BY")
	protected String createdBy;

	@Column(name = "UPDATED_BY")
	protected String updatedBy;

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
