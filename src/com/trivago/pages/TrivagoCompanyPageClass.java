package com.trivago.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trivago.utilities.BaseTestClass;
import com.trivago.utilities.CompanyDescClass;
import com.trivago.utilities.ExcelWriterClass;

public class TrivagoCompanyPageClass extends BaseTestClass{
	WebDriver driver;
	public List<WebElement> jobRoles;
	private int slNo;
	String jobRole,jobRoleTag,jobFamily,experienceLevel,location,language,isApplyBtnPresent,whatYouDoTag,whatYouNeedTag,whatWeLoveYouToHaveTag,testStatus;	
	List<CompanyDescClass> companyDescList = new ArrayList<>();
	
	public TrivagoCompanyPageClass(WebDriver driver){
		this.driver=driver;
	}
	
	/*
	 * Page method to call other method to get the validation results
	 */
	public boolean  clickJobRole()throws Exception{
		boolean testResult= false;
		List<Boolean> testResultList = new ArrayList<>();
		setLocatorPropertyFile();				
		int jobRoleSize = driver.findElements(By.xpath(locProp.getProperty("jobRole"))).size();		
		if(jobRoleSize>0){			
			for(int i=1;i<jobRoleSize;i++){
				slNo=i;
				String roleXpath = "("+(locProp.getProperty("jobRole"))+")["+i+"]";
				try{					
					driver.findElement(By.xpath(roleXpath)).click();
					Thread.sleep(2000);
					testResultList.add(verifyJobRoleHeader("h1"));
					Thread.sleep(2000);
					testResultList.add(verifyJobDetailFieldValue());
					Thread.sleep(2000);
					testResultList.add(verifyApplyBtnPresent());
					testResultList.add(verifyTagWhatWillYouDo("b"));
					Thread.sleep(2000);
					testResultList.add(verifyTagWhatYouDefinatlyNeed("b"));
					Thread.sleep(2000);
					testResultList.add(verifyTagWhatWeLoveYouToHav("b"));
					if(!testResultList.contains(false)){						
						testStatus = "PASSED";
					}else{
						testStatus = "FAILED";
					}
					companyDescList.add(new CompanyDescClass(slNo,jobRole,jobRoleTag,jobFamily,experienceLevel,location,language,isApplyBtnPresent,whatYouDoTag,whatYouNeedTag,whatWeLoveYouToHaveTag,testStatus));
					driver.navigate().back();					
					Thread.sleep(3000);
				}catch(StaleElementReferenceException sE){
					sE.printStackTrace();
				}
			}
		}else{
			System.out.println("Oops... There are no current job roles!!");
		}
		if(!testResultList.contains(false)){
			testResult=true;			
		}
		
		new ExcelWriterClass().writeExcelData(companyDescList);
		return testResult;
	}

	/*
	 * This method verifies the job header has "h1" tag
	 */
	public boolean  verifyJobRoleHeader(String expHeader){
		boolean titleResult = false;
		String actHeader= "";
		WebElement headerElm = driver.findElement(By.xpath(locProp.getProperty("jobTitle")));
		actHeader= headerElm.getTagName();
		jobRole = headerElm.getText();
		jobRoleTag = actHeader;
		if(actHeader.equals(expHeader)){			
			titleResult=true;
		}
		return titleResult;
	}
	
	/*
	 * This method takes the present field names and searches for corresponding values
	 */
	public boolean verifyJobDetailFieldValue(){
		boolean jbFamilyRes = false;
		List<String> fieldValList= new ArrayList<>();
		int fieldSize = driver.findElements(By.xpath(locProp.getProperty("fieldNames"))).size();
		if(fieldSize>0){
			for(int i=1;i<=4;i++){				
				String fieldXpath =  "("+(locProp.getProperty("fieldNames"))+")["+i+"]";
				fieldValList.add(getFieldDetailValue(fieldXpath,i));				
			}				
		}
		if(!fieldValList.contains("")){
			jbFamilyRes=true;
		}
		return jbFamilyRes;
	}
	
	/*
	 * This method verifies if the field has corresponding values
	 */
	public String getFieldDetailValue(String fieldxpath,int count){
		String valueXpath = fieldxpath + locProp.getProperty("fieldVal");
		String actTextVal = driver.findElement(By.xpath(valueXpath)).getText();
		if(count==1){
			jobFamily=actTextVal;
		}else if(count==2){
			experienceLevel= actTextVal;
		}else if(count==3){
			location=actTextVal;
		}else if(count==4){
			language=actTextVal;
		}
		return actTextVal;
	}
	
	/*
	 * This method verifies if the apply button is present in the page
	 */
	public boolean verifyApplyBtnPresent(){
		int applyBtnSize = driver.findElements(By.xpath(locProp.getProperty("applyBtn"))).size();
		if(applyBtnSize>0){
			isApplyBtnPresent = "Yes";
			return true;
		}else{
			isApplyBtnPresent = "No";
			return false;
		}
	}
	
	/*
	 * This method verifies if what will you do is with "b" tag
	 */
	public boolean verifyTagWhatWillYouDo(String expTag){
		String actTag = driver.findElement(By.xpath(locProp.getProperty("whtWillYouDo"))).getTagName();
		whatYouDoTag = actTag;
		if(actTag.equals(expTag)){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * This method verifies if what you definately need is with "b" tag
	 */
	public boolean verifyTagWhatYouDefinatlyNeed(String expTag){
		String actTag = driver.findElement(By.xpath(locProp.getProperty("whtYouDefinatlyNeed"))).getTagName();
		whatYouNeedTag=actTag;
		if(actTag.equals(expTag)){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * This method verifies if what we love you to have is wuth "b" tag
	 */
	public boolean verifyTagWhatWeLoveYouToHav(String expTag){
		String actTag = driver.findElement(By.xpath(locProp.getProperty("whatWeLoveYouToHave"))).getTagName();
		whatWeLoveYouToHaveTag=actTag;
		if(actTag.equals(expTag)){
			return true;
		}else{
			return false;
		}
	}
}
