package com.trivago.utilities;

import java.util.List;

public class CompanyDescClass {
	private int    serialNo;
	private String jobRole;
	private String jobRoleTag;
	private String jobFamily;
	private String experienceLevel;
	private String location;
	private String language;
	private String isApplyBtnPresent;
	private String whatYouDoTag;
	private String whatYouNeedTag;
	private String whatWeLoveYouToHaveTag;
	private String testStatus;
	
	public CompanyDescClass(int serialNo,String jobRole,String jobRoleTag,String jobFamily,String experienceLevel,String location,String language,String isApplyBtnPresent,String whatYouDoTag,String whatYouNeedTag,String whatWeLoveYouToHaveTag,String testStatus){
		this.serialNo 				= serialNo;
		this.jobRole				= jobRole;
		this.jobRoleTag				= jobRoleTag;
		this.jobFamily				= jobFamily;
		this.experienceLevel		= experienceLevel;
		this.location				= location;
		this.language				= language;
		this.isApplyBtnPresent		= isApplyBtnPresent;
		this.whatYouDoTag			= whatYouDoTag;
		this.whatYouNeedTag			= whatYouNeedTag;
		this.whatWeLoveYouToHaveTag	= whatWeLoveYouToHaveTag;
		this.testStatus				= testStatus;
	}

	public CompanyDescClass(List<Object> resultReportList) {
		
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobRoleTag() {
		return jobRoleTag;
	}

	public void setJobRoleTag(String jobRoleTag) {
		this.jobRoleTag = jobRoleTag;
	}

	public String getJobFamily() {
		return jobFamily;
	}

	public void setJobFamily(String jobFamily) {
		this.jobFamily = jobFamily;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsApplyBtnPresent() {
		return isApplyBtnPresent;
	}

	public void setIsApplyBtnPresent(String isApplyBtnPresent) {
		this.isApplyBtnPresent = isApplyBtnPresent;
	}

	public String getWhatYouDoTag() {
		return whatYouDoTag;
	}

	public void setWhatYouDoTag(String whatYouDoTag) {
		this.whatYouDoTag = whatYouDoTag;
	}

	public String getWhatYouNeedTag() {
		return whatYouNeedTag;
	}

	public void setWhatYouNeedTag(String whatYouNeedTag) {
		this.whatYouNeedTag = whatYouNeedTag;
	}

	public String getWhatWeLoveYouToHaveTag() {
		return whatWeLoveYouToHaveTag;
	}

	public void setWhatWeLoveYouToHaveTag(String whatWeLoveYouToHaveTag) {
		this.whatWeLoveYouToHaveTag = whatWeLoveYouToHaveTag;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}	
}
