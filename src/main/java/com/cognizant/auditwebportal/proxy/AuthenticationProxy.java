package com.cognizant.auditwebportal.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.auditwebportal.model.AuthRequest;
import com.cognizant.auditwebportal.model.AuthResponse;
import com.cognizant.auditwebportal.model.IsValidToken;
import com.cognizant.auditwebportal.model.TokenValidator;


@FeignClient(name="authorization-application",url="${AUTHENTICATION.URI:localhost:9000}")
public interface AuthenticationProxy {	
	@PostMapping("/api/authorize/authenticate")
	public AuthResponse authenticateUser(@RequestBody AuthRequest request);
	
	@PostMapping("/api/authorize/validate")
	public IsValidToken validateToken(@RequestBody TokenValidator inputToken);
}
