package org.oba.portal.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.oba.portal.model.AaRole;
import org.oba.portal.model.AaUser;
import org.oba.portal.model.AaUserDetails;
import org.oba.portal.repo.AaRoleRepo;
import org.oba.portal.repo.AaUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private AaUserRepo userRepository;

	@Autowired
	private AaRoleRepo roleRepository;

	@Override
	public UserDetails loadUserByUsername(String loginname) throws UsernameNotFoundException {
		Optional<AaUser> userOpt = userRepository.findByLoginname(loginname);
		userOpt.orElseThrow(() -> new UsernameNotFoundException(String.format("The username %s doesn't exist", loginname)));
		List<AaRole> userRoles = roleRepository.findByQueryParam(loginname);

System.out.println("ROLES begin");
System.out.println(userRoles.size());
Iterator<AaRole> roleItr = userRoles.iterator();
while (roleItr.hasNext())
	System.out.println(roleItr.next().getRoleName());
System.out.println("ROLES end");

//		return userOpt.map(AaUserDetails::new).get();
		return userOpt.map((AaUser user) -> { return new AaUserDetails(user, userRoles); }).get();

//		List<GrantedAuthority> authorities = new ArrayList<>();
//		user.getRoles().forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//		});
//
//		UserDetails res = new org.springframework.security.core.userdetails.User(user.getUsername(),
//				user.getPassword(), authorities);
//
//		return res;
	}
}
