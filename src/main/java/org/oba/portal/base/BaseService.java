package org.oba.portal.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.oba.portal.base.util.PageableList;
import org.oba.portal.base.util.QueryUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<M, I extends Serializable> {

	protected abstract BaseRepository<M, I> getRepo();

	protected void checkForManipulation(char operation, M m) throws Exception {
	}
	protected void prepareForManipulation(char operation, M m) {
	}
	protected void postManipulation(char operation, M m) {
	}

	/*
	 * CRUD
	 */

	public M getModel(I rid) {
		return getRepo().findOne(rid);
	}

	@Transactional
	public M saveModel(char operation, M model) throws Exception {
		checkForManipulation(operation, model);
		prepareForManipulation(operation, model);
		M res = getRepo().save(model);
		postManipulation(operation, res);
		return res;
	}

	@Transactional
	public boolean deleteModel(I rid) throws Exception {
		M m = getRepo().getOne(rid);
		checkForManipulation('d', m);
		prepareForManipulation('d', m);
		getRepo().delete(rid);
		postManipulation('d', m);
		return true;
	}

	/*
	 * LIST
	 */
	public PageableList<M> getPageableList(int pageFirst, int pageRows, String sortInfo, String whereInfo) {
		Sort sort = QueryUtil.getSort(sortInfo);

		List<Specification<M>> specl = QueryUtil.getSpecs(whereInfo);

		Specifications<M> specs = null;
		if ((specl != null) && (specl.size() > 0)) {
			specs = Specifications.where(specl.get(0));
			for (int i = 1; i < specl.size(); i++)
				specs = specs.and(specl.get(i));
		}

		Pageable pageable = new PageRequest((int) Math.floor((1.0 * pageFirst) / pageRows), pageRows, sort);
		return new PageableList<M>(getRepo().findAll(specs, pageable));		
	}

	public List<M> getList() {
		List<M> res = this.getRepo().findAll();
		if (res == null) {
			System.out.println("NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL");
			return new ArrayList<M>();
		}
		return res;
	}

	public List<M> getList(String sortInfo, String whereInfo) {
		Sort sort = QueryUtil.getSort(sortInfo);

		List<Specification<M>> specl = QueryUtil.getSpecs(whereInfo);

		Specifications<M> specs = null;
		if ((specl != null) && (specl.size() > 0)) {
			specs = Specifications.where(specl.get(0));
			for (int i = 1; i < specl.size(); i++)
				specs = specs.and(specl.get(i));
		}

		List<M> res = getRepo().findAll(specs, sort);
		if (res == null) {
			System.out.println("NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL-NULL");
			return new ArrayList<M>();
		}
		return res;
	}

}
