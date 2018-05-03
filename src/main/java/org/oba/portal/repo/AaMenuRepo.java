package org.oba.portal.repo;

import java.util.List;

import org.oba.portal.base.BaseRepository;
import org.oba.portal.model.AaMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AaMenuRepo extends BaseRepository<AaMenu, Long> {
	@Query("SELECT ms FROM AaUser u"
			+ " INNER JOIN u.groups gs"
			+ " INNER JOIN gs.menus ms"
			+ " WHERE u.loginname = :loginname")
	public List<AaMenu> findByQueryParam(@Param("loginname") String loginname);
}
