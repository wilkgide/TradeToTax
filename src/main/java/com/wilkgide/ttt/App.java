package com.wilkgide.ttt;

import java.io.IOException;
import java.util.List;

import com.wilkgide.ttt.in.ExcelReader;
import com.wilkgide.ttt.in.QuestradeRow;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String[] files = new String[2];
    	files[0] = "C:/temp/Activities_for_01Jan2010_to_03Jul2017.xlsx";
    	files[1] = "C:/temp/Activities_for_01Jan2010_to_03Jul2017 (1).xlsx";
    	
    	String sheet = "Activities";
    	ExcelReader<QuestradeRow> reader = new ExcelReader<QuestradeRow>(QuestradeRow::new);
    	
    	for (int i=0; i<files.length; i++) {
    		try {
    			System.out.println("Reading in " + files[i]);
				List<QuestradeRow> rows = reader.readFile(files[i], sheet);
				System.out.println(String.format("Read %s rows", rows.size()));
				for (QuestradeRow row : rows) {
					System.out.println(row);
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
    	}
    }
}
