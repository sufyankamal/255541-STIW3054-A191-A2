import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class writeExcel {

    public void writeExcel() {


        String excelFile = "excel.xls";
        System.out.println("\nwriting the" + excelFile + ".....");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("details");

        try {
            JSONObject[] x = new JSONObject[0];

            for (int i = 0; i < x.length; i++) {
                HSSFRow row = sheet.createRow(i);
                HSSFCell cell1 = row.createCell(0);
                cell1.setCellValue(x[i].getString("login"));
                HSSFCell cell2 = row.createCell(1);
                cell1.setCellValue(x[i].getInt("public repos"));
                HSSFCell cell3 = row.createCell(2);
                cell1.setCellValue(x[i].getInt("followers"));
                HSSFCell cell4 = row.createCell(3);
                cell1.setCellValue(x[i].getInt("id"));
                HSSFCell cell5 = row.createCell(4);
                cell1.setCellValue(x[i].getInt("following"));

            }

            FileOutputStream outputFile = new FileOutputStream(excelFile);
            workbook.write(outputFile);
            outputFile.flush();
            outputFile.close();
            System.out.println("excel file has been written");

        } catch (IOException e) {
            System.out.println("failed to write");


        }
    }
}
