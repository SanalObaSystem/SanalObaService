package org.oba.portal.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AaUserDetails extends AaUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4040058519752736430L;

	private List<AaRole> userRoles = null; 

	public AaUserDetails(final AaUser user, final List<AaRole> userRoles) {
		super(user);
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return getGroups().stream()
//							.flatMap(group -> group.getRoles().stream())
//							.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
//							.collect(Collectors.toList());
		return userRoles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getLoginname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
