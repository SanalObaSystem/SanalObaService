package org.oba.portal.repo;

import java.util.List;

import org.oba.portal.base.BaseRepository;
import org.oba.portal.model.AaRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AaRoleRepo extends BaseRepository<AaRole, Long> {
	@Query("SELECT rs FROM AaUser u"
			+ " INNER JOIN u.groups gs"
			+ " INNER JOIN gs.roles rs"
			+ " WHERE u.loginname = :loginname")
	public List<AaRole> findByQueryParam(@Param("loginname") String loginname);
}
