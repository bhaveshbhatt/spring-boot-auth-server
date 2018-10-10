package com.techfeel.authserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 
 * @author bhavesh bhatt
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	protected Logger logger = LoggerFactory.getLogger(AuthorizationServerConfig.class);

	@Value("${clientId}")
	protected String clientId;
	
	@Value("${secret}")	
	protected String secret;

	@Value("${authGrantType}")	
	protected String authGrantType;

	@Value("${scope}")	
	protected String scope;
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    	logger.debug("AuthorizationServerConfig configure AuthorizationServerSecurityConfigurer start");
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
        
    	logger.debug("AuthorizationServerConfig-configure-AuthorizationServerSecurityConfigurer end");
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	logger.debug("AuthorizationServerConfig configure ClientDetailsServiceConfigurer start");

    	clients
                .inMemory()
                .withClient(clientId)
                .secret(secret)
                .authorizedGrantTypes(authGrantType)
                .scopes(scope)
                .autoApprove(true);
    
    	logger.debug("AuthorizationServerConfig configure ClientDetailsServiceConfigurer end");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager);
    }
}