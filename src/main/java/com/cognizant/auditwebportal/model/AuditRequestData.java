package com.cognizant.auditwebportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditRequestData {

	private long auditId;
	private String projectName;
	private String projectManagerName;
	private String applicationOwnerName;
	private String auditType;
	private String auditDate;
	private int yesCount;
	private int noCount;
	private String projectExcecutionStatus;
	private String remedialActionDuration;
	
	public AuditRequestData(AuditRequest request,AuditResponse response) {
		this.auditId=request.getAuditId();
		this.projectName = request.getProjectName();
		this.applicationOwnerName=request.getApplicationOwnerName();
		this.projectManagerName = request.getProjectManagerName();
		this.applicationOwnerName=request.getApplicationOwnerName();
		this.auditType=request.getAuditType();
		this.auditDate=request.getAuditDate();
		this.yesCount=request.getNoCount();
		this.noCount=request.getNoCount();
		this.projectExcecutionStatus=response.getProjectExcecutionStatus();
		this.remedialActionDuration=response.getRemedialActionDuration();
	}
}
