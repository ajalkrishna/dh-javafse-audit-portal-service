package com.cognizant.auditwebportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {
	private long auditId;
	private String projectExcecutionStatus;
	private String remedialActionDuration;
}
