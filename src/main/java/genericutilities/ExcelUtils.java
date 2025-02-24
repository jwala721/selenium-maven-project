package genericutilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    // Method to write data to Excel
    public static void writeToExcel(String filePath, String sheetName, List<String> data) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(data.get(i));
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    // Method to read data from Excel
    public static List<String> readFromExcel(String filePath, String sheetName) throws IOException {
        List<String> data = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    data.add(cell.getStringCellValue());
                }
            }
            workbook.close();
        }
        return data;
    }




   /* public static boolean checkDDListFromUIAndExcel(WebDriver driver, String ddName) {

        int cellNum =0;
        ArrayList<String> expectedList=new ArrayList<String>();
        ArrayList<String> actualList=new ArrayList<String>();
        boolean result =false;
        int counter = 0;
        try {

            File f=new File("test-data/TestData.xlsx");

            FileInputStream fis=new FileInputStream(f);

            XSSFWorkbook wb=new XSSFWorkbook(fis);

            XSSFSheet sheet=wb.getSheet("stations");

            int totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
            for(int i=0;i<totalCells; i++) {

                String currentCellData = sheet.getRow(0).getCell(i).getStringCellValue();

                if (currentCellData.equals(ddName)) {

                    cellNum = i;
                    break;
                }
            }

            int totalRows=sheet.getPhysicalNumberOfRows();

            for(int j=1;j<totalRows;j++) {

                XSSFCell cell=sheet.getRow(j).getCell(cellNum);
                if(cell == null || cell.getCellType()== CellType.BLANK) {
                    break;
                }

                String cellData=sheet.getRow(j).getCell(cellNum).getStringCellValue();

                expectedList.add(cellData);

            }
            wb.close();

            List<WebElement> ls = driver.findElements(By.xpath("//div[starts-with(@id,\"Autocomplete\") and contains(@class,\"autocomplete\")] /div"));
            for(WebElement ele:ls){
                String optionName = ele.getText();
                actualList.add(optionName);
            }

            //here we will compare
            if(expectedList.size() == actualList.size()) {
                for(int i=0;i<expectedList.size(); i++) {

                    if (expectedList.get(i).equals(actualList.get(i))) {
                        continue;
                    } else {

                        System.out.println("Mismatch beetween options === > " + "\n"
                                + "Expected == > " + expectedList.get(i) + "\n"
                                + "Actual == > " + actualList.get(i));
                        counter++;
                    }
                }
                if(counter == 0) {
                    System.out.println("Options are matching .... ");
                    result=true;
                }else {
                    System.out.println("Mismatch beetween options list");
                    result=false;

                }

            }else {

                System.out.println("ERROR: DD options from UI are NOT matching");
                        result=false;
            }


        }catch(Exception e) {

            e.printStackTrace();

        }

        return result;
    }*/

}
