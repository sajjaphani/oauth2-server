package org.oauth2server.security.oauth2.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 *  A simple service that provides client details.
 *  
 * @author psajja
 *
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {

	private static final String RESOURCE = "movies";
	
	private String clientId;
    private String clientSecret;
    
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
		if (getClientId().equals(clientId)) {
			List<String> authorizedGrantTypes = new ArrayList<String>();
			authorizedGrantTypes.add("password");
			authorizedGrantTypes.add("refresh_token");
			authorizedGrantTypes.add("client_credentials");

			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(clientId);
			clientDetails.setClientSecret(clientSecret);
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			clientDetails.setAuthorities(grantedAuthorities);
			List<String> resources = new ArrayList<String>();
			resources.add(RESOURCE);
			clientDetails.setResourceIds(resources);
			
			return clientDetails;
		}

		throw new NoSuchClientException("No client found with the given id: " + clientId);
	}

	/**
	 * Get the client id.
	 * 
	 * @return
	 * 		the client id
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Set the client id.
	 * 
	 * @param clientId
	 * 		the client id to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Get the client secret.
	 * 
	 * @return
	 * 		the client secret to get
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * Set the client secret.
	 * 
	 * @param clientSecret
	 * 		the client secret to set
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}