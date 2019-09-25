package com.trivago.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterClass {
	private String[] columns = {"SL_No","Job_Role_Name","JobTitleTag","JobFamilyValue","ExperienceLevelValue","LocationValue","LanguageValue","ApplyBtnPresent","WhatYouDoTag","WhatYouNeedTag","WhatWeLoveYoutoHaveTag","TestStatus"};
	
	
	public void writeExcelData(List<CompanyDescClass> companyDesc){
		Workbook workbook = new XSSFWorkbook();        
        CreationHelper createHelper = workbook.getCreationHelper();        
        Sheet sheet = workbook.createSheet("CompanyPage");        
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());      
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);        
        Row headerRow = sheet.createRow(0);        
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }       
        int rowNum = 1;
        for(CompanyDescClass company: companyDesc) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(company.getSerialNo());
            row.createCell(1).setCellValue(company.getJobRole());
            row.createCell(2).setCellValue(company.getJobRoleTag());
            row.createCell(3).setCellValue(company.getJobFamily());
            row.createCell(4).setCellValue(company.getExperienceLevel());
            row.createCell(5).setCellValue(company.getLocation());
            row.createCell(6).setCellValue(company.getLanguage());
            row.createCell(7).setCellValue(company.getIsApplyBtnPresent());
            row.createCell(8).setCellValue(company.getWhatYouDoTag());
            row.createCell(9).setCellValue(company.getWhatYouNeedTag());
            row.createCell(10).setCellValue(company.getWhatWeLoveYouToHaveTag());    
            row.createCell(11).setCellValue(company.getTestStatus());    
        }
		
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
      
        FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("testResults/Report.xlsx");
			workbook.write(fileOut);
	        fileOut.close();	       
	        workbook.close();
	        System.out.println("done");
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}        
    }
	public static void main(String[] args) {
		List<CompanyDescClass> companyDesc = new ArrayList<>();
		companyDesc.add(new CompanyDescClass(1,"TestROle","h1","CustomerCare","0-1","Pune","English","Yes","b","b","b","passed"));
		//companyDesc.add(new CompanyDescClass(2,"TestROle1","h1","CustomerCare","0-1","Pune","Spanish","Yes","b","b","b","passed"));
		//companyDesc.add(new CompanyDescClass(3,"TestROl2","h1","CustomerCare","0-1","Pune","German","Yes","c","b","b","falied"));
		new ExcelWriterClass().writeExcelData(companyDesc);		
	}
}	
