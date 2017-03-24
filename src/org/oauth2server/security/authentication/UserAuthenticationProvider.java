package org.oauth2server.security.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Simple authentication provided.
 * Hard coded authentication credentials.
 * 
 * @author psajja
 *
 */
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	private static final String USER_ID = "api-user";
	private static final String PASSWORD = "api-pass";

	@Override
	public Authentication authenticate(Authentication authentication)	throws AuthenticationException {
		boolean isValid = isValidUser(authentication.getPrincipal()
				.toString(), authentication.getCredentials().toString());

		if (isValid) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
					authentication.getPrincipal(),
					authentication.getCredentials(), grantedAuthorities);
	
			return auth;
		} else {
			throw new BadCredentialsException("Invalid User Credentials.");
		}
	}

	/**
	 * Validate the authentication. We have hard coded here for simplicity.
	 * 
	 * @param userName
	 * 		user id
	 * @param password
	 * 		password
	 * 
	 * @return
	 * 		true for valid user authentication, false otherwise
	 */
	private boolean isValidUser(String userName, String password) {
	
		// Verify the user existence in a DB
		return userName.equals(USER_ID) && password.equals(PASSWORD);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
