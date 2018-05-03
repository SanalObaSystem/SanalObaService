package org.oba.portal.repo;

import java.util.Optional;

import org.oba.portal.base.BaseRepository;
import org.oba.portal.model.AaUser;

public interface AaUserRepo extends BaseRepository<AaUser, Long> {
	public Optional<AaUser> findByLoginname(String loginname);
}
