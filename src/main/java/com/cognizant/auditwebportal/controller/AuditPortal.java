package com.cognizant.auditwebportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditwebportal.model.AuditRequest;
import com.cognizant.auditwebportal.model.AuditRequestData;
import com.cognizant.auditwebportal.model.AuditResponse;
import com.cognizant.auditwebportal.model.AuthRequest;
import com.cognizant.auditwebportal.model.AuthResponse;
import com.cognizant.auditwebportal.model.Response;
import com.cognizant.auditwebportal.proxy.AuditChecklistProxy;
import com.cognizant.auditwebportal.proxy.AuditSeverityProxy;
import com.cognizant.auditwebportal.proxy.AuthenticationProxy;
import com.cognizant.auditwebportal.service.AuthenticateRequest;

@RestController
@RequestMapping("/audit-portal")
@CrossOrigin(origins="*")
public class AuditPortal {

//	login to the application by creating token(should return token)
	
	@Autowired
	private AuthenticationProxy authProxy;
	
	@Autowired
	private AuditSeverityProxy severityProxy;
	
	@Autowired
	private AuditChecklistProxy checkProxy;
	
	@Autowired
	private AuthenticateRequest validateToken;
	
	@PostMapping("/login")
	public AuthResponse authenticateUser(@RequestBody AuthRequest request) {
		AuthResponse authenticateUser = authProxy.authenticateUser(request);
		return authenticateUser;
	}
	
	
//	get the audit question on the basis of type
	@GetMapping("/AuditCheckListQuestions/{type}")
	public Response getAuditCheckList(@PathVariable String type,
			@RequestHeader(name = "Authorization") String bearerToken) {
		return checkProxy.getAuditCheckListQuestions(type, bearerToken);
	}
	
	
//	post the audit request data
	@PostMapping("/ProjectExcecutionStatus")
	public AuditResponse getProjectExcecutionStatus(@RequestBody AuditRequest request,@RequestHeader(name = "Authorization") String bearerToken) {
		if(validateToken.isValid(bearerToken)) {
			return severityProxy.getProjectExcecutionStatus(request);
		}
		else {
			return severityProxy.getProjectExcecutionStatus(null);
		}
	}
	
//	get previous audit requests
	@GetMapping("/PastAuditRequests")
	public List<AuditRequestData> getPastAuditRequests(@RequestHeader(name = "Authorization") String bearerToken) {
		if(validateToken.isValid(bearerToken)) {
			return severityProxy.getPastAuditRequest();
		}
		else {
			return null;
		}
		
	}
}
