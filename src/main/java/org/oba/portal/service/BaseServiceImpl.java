package org.oba.portal.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.oba.portal.base.BaseService;
import org.oba.portal.model.BaseModelImpl;

public abstract class BaseServiceImpl<M extends BaseModelImpl<I>, I extends Serializable> extends BaseService<M, I> {

	@Override
	protected void prepareForManipulation(char operation, M m) {
		if (operation != 'd') {
			String loginName = "FIXED USER";
			if (operation == 'c') {
				m.setCreatedBy(loginName);
				m.setUpdatedBy(loginName);
				m.setCreationTime(LocalDateTime.now());
				m.setUpdateTime(LocalDateTime.now());
			} else {
				m.setUpdatedBy(loginName);
				m.setUpdateTime(LocalDateTime.now());
			}
		} else {
			//	TODO Delete operation must be logged!
		}
	}
}
