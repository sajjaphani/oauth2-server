package org.oauth2server.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * A simple implementation of user authentication token based on user id and password.
 * 
 * @author psajja
 *
 */
public final class UserAuthenticationToken extends AbstractAuthenticationToken {

	/**
	 * Serial version id.
	 */
	private static final long serialVersionUID = 2579546988092863249L;

	private final Object principal;
    private Object credentials;
    
	public UserAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
