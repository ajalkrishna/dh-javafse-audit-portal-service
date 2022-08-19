package com.cognizant.auditwebportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditwebportal.model.IsValidToken;
import com.cognizant.auditwebportal.model.TokenValidator;
import com.cognizant.auditwebportal.proxy.AuthenticationProxy;

@Service
public class AuthenticateRequest {
	
	@Autowired
	private AuthenticationProxy proxy;
	
	public Boolean isValid(String bearerToken) {
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			String token = bearerToken.substring(7);
			IsValidToken tokenResponse = proxy.validateToken(new TokenValidator(token));
			return tokenResponse.getIsValid();
		}
		else {
			return false;
		}
	}
}