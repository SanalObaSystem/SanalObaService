package org.oba.portal.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel<I> implements Serializable {

	private static final long serialVersionUID = 7672158199547112255L;

	@Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqBase")	//	Should be enabled to use ORACLE sequences!
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RID")
	protected I rid;

	public void setRid(I rid) {
		this.rid = rid;
	}

	public I getRid() {
		return rid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getRid() != null ? getRid().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof BaseModel) {
			if (getClass().equals(obj.getClass())) {
				@SuppressWarnings("unchecked")
				BaseModel<I> model = (BaseModel<I>) obj;
				result = (model.getRid() != null && getRid() != null && model.getRid().equals(getRid()));
			}
		}
		return result;
	}
}
