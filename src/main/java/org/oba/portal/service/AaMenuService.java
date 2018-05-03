package org.oba.portal.service;

import java.util.List;

import org.oba.portal.model.AaMenu;
import org.oba.portal.repo.AaMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AaMenuService extends BaseServiceImpl<AaMenu, Long> {

	@Autowired
	private AaMenuRepo aaMenuRepo;

	public AaMenuRepo getRepo() {
		return this.aaMenuRepo;
	}

	public List<AaMenu> getUserMenu(String loginname) {
		return this.aaMenuRepo.findByQueryParam(loginname);
	}
}
