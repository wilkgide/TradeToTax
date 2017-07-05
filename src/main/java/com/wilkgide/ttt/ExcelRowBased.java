package com.wilkgide.ttt;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelRowBased {

	public void parseTitle(Row row);
	public void parseRow(Row row);
}
