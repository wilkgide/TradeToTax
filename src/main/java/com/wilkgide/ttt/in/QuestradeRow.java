package com.wilkgide.ttt.in;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.wilkgide.ttt.ExcelRowBased;

public class QuestradeRow implements ExcelRowBased {

	private DateTime transactionDate;
	private DateTime settlementDate;
	private String action;
	private String symbol;
	private String description;
	private double qty;
	private double price;
	private double grossAmt;
	private double commission;
	private double netAmount;
	private String currency;
	private String acctNumber;
	private String type;
	private String acctType;
	
	
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellTypeEnum()) {
	    case BLANK:
	    case STRING:
	        return cell.getStringCellValue();
	 
	    case BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case NUMERIC:
	        return cell.getNumericCellValue();
	        
	    case FORMULA:
	    	return cell.getRichStringCellValue();
	    
	    case ERROR:
	    case _NONE:
	    	return null;
	    }
	 
	    return null;
	}
	
	public void parseRow(Row row) {
		Iterator<Cell> cellIterator = row.cellIterator();
        
        while (cellIterator.hasNext()) {
            transactionDate = DateTime.parse((String) getCellValue(cellIterator.next()), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss a"));
            settlementDate = DateTime.parse((String) getCellValue(cellIterator.next()), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss a"));
            action = (String) getCellValue(cellIterator.next());
            symbol = (String) getCellValue(cellIterator.next());
            description = (String) getCellValue(cellIterator.next());
            qty = Double.parseDouble((String) getCellValue(cellIterator.next()));
            price = Double.parseDouble((String) getCellValue(cellIterator.next()));
            grossAmt = Double.parseDouble((String) getCellValue(cellIterator.next()));
            commission = Double.parseDouble((String) getCellValue(cellIterator.next()));
            netAmount = Double.parseDouble((String) getCellValue(cellIterator.next()));
            currency = (String) getCellValue(cellIterator.next());
            acctNumber = (String) getCellValue(cellIterator.next());
            type = (String) getCellValue(cellIterator.next());
            acctType = (String) getCellValue(cellIterator.next());
        }
	}

	@Override
	public String toString() {
		return "QuestradeRow [transactionDate=" + transactionDate + ", settlementDate=" + settlementDate + ", action="
				+ action + ", symbol=" + symbol + ", description=" + description + ", qty=" + qty + ", price=" + price
				+ ", grossAmt=" + grossAmt + ", commission=" + commission + ", netAmount=" + netAmount + ", currency="
				+ currency + ", acctNumber=" + acctNumber + ", type=" + type + ", acctType=" + acctType + "]";
	}

	@Override
	public void parseTitle(Row row) {
		
	}

}
