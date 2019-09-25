package com.trivago.testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.trivago.pages.TrivagoCompanyPageClass;
import com.trivago.utilities.BaseTestClass;

public class TrivagoCompanyTestClass {
	BaseTestClass baseClsObj = new BaseTestClass();
	
	@BeforeSuite
	public void initialize(){
		baseClsObj.setAppPropertyFile();
		baseClsObj.setUpTest();		
	}
	
	@Test
	public void navigateToJobListPage(){
		try {
			new TrivagoCompanyPageClass(BaseTestClass.driver).clickJobRole();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void tearDown(){
		baseClsObj.endTest();
	}
}
