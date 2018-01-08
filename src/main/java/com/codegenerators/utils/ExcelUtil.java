package com.codegenerators.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codegenerators.dtos.ClassProperty;
import com.codegenerators.dtos.ClassStructure;

public class ExcelUtil {

	public static void getData() {
		Workbook wb = null;
		try {
			String filePath = ExcelUtil.class.getResource("").getPath() + "DataElements_WC.xlsx";
			System.out.println(filePath);
			InputStream inp = new FileInputStream(filePath);
		    wb = new XSSFWorkbook(inp);
			Iterator<Sheet> list = wb.sheetIterator();
			while(list.hasNext()) {
				Sheet sheet = list.next();
				System.out.println(sheet.getSheetName());
			}
			Sheet sheet = wb.getSheet("Data Elements");
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()) {
				Row row = rows.next();
				Cell cell = row.getCell(10);
				System.out.println("" + row.getRowNum() +  " ==> " + cell.getStringCellValue());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<ClassStructure> getMorckUpData() {
		List<ClassStructure> list = new ArrayList<ClassStructure>();
		for (int j = 0; j < 2; j++) {
			ClassStructure tempClass = new ClassStructure();
			tempClass.setPackageName("com.mig.edge.capabilities.quote.lob.common.dto");
			tempClass.setClassName("ClassName" + j);
			
			List<ClassProperty> properties = new ArrayList<ClassProperty>();
			for (int i = 0; i < 5; i++) {
				ClassProperty property = new ClassProperty();
				if (i > 2) {
					property.setComment("test " + i);
				}
				property.setName("Property" + i);
				if (i % 2 == 0) {
					property.setRequried(true);
				} else {
					property.setRequried(false);
				}
				property.setType("Boolean");
				properties.add(property);
			}
			tempClass.setProperties(properties);
			list.add(tempClass);
		}
		System.out.println("Mock up ClassStructure data：");
		System.out.println(list);
		return list;
	}
	
}
