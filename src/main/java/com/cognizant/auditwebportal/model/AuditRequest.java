package com.cognizant.auditwebportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditRequest {

	private long auditId;
	private String projectName;
	private String projectManagerName;
	private String applicationOwnerName;
	private String auditType;
	private String auditDate;
	private int yesCount;
	private int noCount;
}
