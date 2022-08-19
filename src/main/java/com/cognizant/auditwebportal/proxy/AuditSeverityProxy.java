package com.cognizant.auditwebportal.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.auditwebportal.model.AuditRequest;
import com.cognizant.auditwebportal.model.AuditRequestData;
import com.cognizant.auditwebportal.model.AuditResponse;

@FeignClient(name="audit-severity-application",url ="${AUDIT.SEVERITY.URI:localhost:8100}")
public interface AuditSeverityProxy {
	
	@PostMapping("/audit-severity/ProjectExcecutionStatus")
	public AuditResponse getProjectExcecutionStatus(@RequestBody AuditRequest request);
	
	@GetMapping("/audit-severity/PastAuditRequests")
	public List<AuditRequestData> getPastAuditRequest();
}
