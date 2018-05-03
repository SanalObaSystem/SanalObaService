package org.oba.portal.service;

import org.oba.portal.model.AaUser;
import org.oba.portal.repo.AaUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AaUserService extends BaseServiceImpl<AaUser, Long> {

	@Autowired
	private AaUserRepo aaUserRepo;

	public AaUserRepo getRepo() {
		return this.aaUserRepo;
	}

	public AaUser getUser(String loginname) {
		return this.aaUserRepo.findByLoginname(loginname).get();
	}
}
