package com.didi.ser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didi.mapper.StatisticsMapper;
import com.didi.until.MyDateUtil;




@Service
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/applicationContext.xml") 
public class StatisticsService {

   @Resource
   StatisticsMapper statisticsMapper;
	
	

	public HSSFWorkbook exportEexel(Date startTime,Date endTime) throws FileNotFoundException, IOException{
	
/*	@Test	
	public void exportEexel() throws FileNotFoundException, IOException{*/
//		Date startTime=MyDateUtil.parseDate("2017-11-1");
//		Date endTime=MyDateUtil.parseDate("2017-11-30");
//		
			 
		HSSFWorkbook workbook = new HSSFWorkbook();
		//统计总表

		HSSFSheet sheet = workbook.createSheet("账户总览");
		for (int i = 0; i < 3; i++) {
			sheet.setColumnWidth(i, 15 * 256);
		}
	   
		// 设置字体
		HSSFFont font = workbook.createFont();
		// font.setColor(HSSFFont.COLOR_RED);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 14);

		// 设置样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置第一行
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 4));
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("账户总览");
		
		// 设置第二行
		row = sheet.createRow(1);
		row.createCell(0).setCellValue("日期");
		row.createCell(1).setCellValue("交押金");
		row.createCell(2).setCellValue("退押金");
		row.createCell(3).setCellValue("充值");
		
		//开始循环
//	    Calendar calendar = Calendar.getInstance();	
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endTime);
		calendar.add(Calendar.DATE, 1);
		endTime=calendar.getTime();
		
		Date temp=startTime;
		int i=1;
		while(temp.getTime() < endTime.getTime()){
			//第一步
			Map<String,Object> paramMap1=new HashMap<String, Object>();
			paramMap1.put("day", temp);
			Map<String,Object> moneyStatistics=statisticsMapper.moneyStatistics(paramMap1);
			
//			System.out.println(MyDateUtil.format(calendar.getTime()));
			//第二步
	
				row = sheet.createRow(1 + i);
				row.createCell(0).setCellValue(MyDateUtil.format(temp));
				row.createCell(1).setCellValue(((BigDecimal) moneyStatistics.get("chargeShare")).doubleValue());
				row.createCell(2).setCellValue(((BigDecimal) moneyStatistics.get("returnShare")).doubleValue());
				row.createCell(3).setCellValue(((BigDecimal) moneyStatistics.get("chargeAmount")).doubleValue());
				
//				row.createCell(4).setCellValue(list.get(i).getDdb());
		
			
			i++;
			calendar.setTime(temp);
			calendar.add(Calendar.DATE, 1);
			temp=calendar.getTime(); 
		}
		
		//workbook.write(new FileOutputStream("g:/poi.xls"));
		return workbook;
		
			
	}



	public List<Map<String, Object>> list(Date startTime,Date endTime) {
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endTime);
		calendar.add(Calendar.DATE, 1);
		endTime=calendar.getTime();
		
		Date temp=startTime;

		while(temp.getTime() < endTime.getTime()){
			//第一步
			Map<String,Object> paramMap1=new HashMap<String, Object>();
			paramMap1.put("day", temp);
			Map<String,Object> moneyStatistics=statisticsMapper.moneyStatistics(paramMap1);
			
//			System.out.println(MyDateUtil.format(calendar.getTime()));
			//第二步
			moneyStatistics.put("date",MyDateUtil.format(temp));
			list.add(moneyStatistics);

			calendar.setTime(temp);
			calendar.add(Calendar.DATE, 1);
			temp=calendar.getTime(); 
		}
		
		
		return list;
	}


}
