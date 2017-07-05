package com.wilkgide.ttt.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wilkgide.ttt.ExcelRowBased;

public class ExcelReader<A extends ExcelRowBased> {
	
	private Supplier<A> supplier;
	
	public ExcelReader(Supplier<A> supplier) {
		this.supplier = supplier;
	}
	
	public List<A> readFile(String path, String sheet) throws IOException {
		try (
			FileInputStream inputStream = new FileInputStream(new File(path));
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		) {
			List<A> rows = new ArrayList<A>();
	        Sheet firstSheet = workbook.getSheet(sheet);
	        Iterator<Row> iterator = firstSheet.iterator();
	        boolean isTitle = true;
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            A parsed = supplier.get();
	            if (isTitle) {
	            	parsed.parseTitle(nextRow);
	            	isTitle = false;
	            } else {
	            	parsed.parseRow(nextRow);
		            rows.add(parsed);
	            }
	        }
			return rows;
		}
	}
}
