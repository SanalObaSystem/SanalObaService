package org.oba.portal.service;

import org.oba.portal.model.AaGroup;
import org.oba.portal.repo.AaGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AaGroupService extends BaseServiceImpl<AaGroup, Long> {

	@Autowired
	private AaGroupRepo aaGroupRepo;

	public AaGroupRepo getRepo() {
		return this.aaGroupRepo;
	}
}
