package com.cognizant.auditwebportal.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.auditwebportal.model.Response;


@FeignClient(name="audit-checklist",url="${AUDIT.CHECKLIST.URI:localhost:8200}")
public interface AuditChecklistProxy {
	
	@GetMapping("/audit-checklist/AuditCheckListQuestions/{type}")
	public Response getAuditCheckListQuestions(@PathVariable String type,
			@RequestHeader(name = "Authorization") String bearerToken);

}
