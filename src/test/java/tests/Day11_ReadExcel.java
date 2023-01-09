package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Day11_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
//          workbook>worksheet>row>cell
//        Store the path of the  file in a string
        String path="./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream=new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook= WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet1=workbook.getSheet("Sheet1"); //or I can use getSheetAt(0);because index starts with 0.
//        Go to first row
        Row row1=sheet1.getRow(0);//going to first row

//        Go to first cell on that first row and print
        Cell cell1=row1.getCell(0);
        String cell1Data=cell1.toString();//we can use string manipulations after converting to String
        System.out.println(cell1);
        System.out.println(cell1Data);

//        Go to second cell on that first row and print
        Cell cell2=row1.getCell(1);
        System.out.println("R1C2 : "+cell2);

//        Go to 2nd row first cell  and assert if the data equal to USA
        String cellr2c1Data=sheet1.getRow(1).getCell(0).toString();
        assertEquals("USA",cellr2c1Data);

//        Go to 3rd row 2nd cell-chain the row and cell
        String cellr3c2Data=sheet1.getRow(2).getCell(1).toString();
        System.out.println(cellr3c2Data);

//        Find the number of row
        int numOfRow=sheet1.getLastRowNum()+1;//index start with 0 so we need to add +1
        System.out.println("row count: "+numOfRow);

        //System.out.println(sheet1.getPhysicalNumberOfRows());

//        Find the number of used row
        int numOfData=sheet1.getPhysicalNumberOfRows();//index starts from1. it is skip if there is no data in a cell.
        System.out.println("number of used row: "+numOfData);
//        Print country, capitol key value pairs as map object
 //       {{USA,D.C},{France,Paris}
        //create a map that will store the country, capital pairs
        Map<String,String >countryCapitals=new HashMap<>();
        for (int rowNum=1; rowNum<numOfRow;rowNum++){//row index starts at 1 ends at 11
            String country=sheet1.getRow(rowNum).getCell(0).toString();
            String capitals=sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(country,capitals);

        }
        System.out.println(countryCapitals);


    }
}
