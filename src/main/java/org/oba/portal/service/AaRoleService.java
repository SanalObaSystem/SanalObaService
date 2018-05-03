package org.oba.portal.service;

import java.util.List;

import org.oba.portal.model.AaRole;
import org.oba.portal.repo.AaRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AaRoleService extends BaseServiceImpl<AaRole, Long> {

	@Autowired
	private AaRoleRepo aaRoleRepo;

	public AaRoleRepo getRepo() {
		return this.aaRoleRepo;
	}

	public List<AaRole> getUserRoles(String loginname) {
		return this.aaRoleRepo.findByQueryParam(loginname);
	}
}
