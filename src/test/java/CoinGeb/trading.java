package CoinGeb;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class trading extends login{

    File src = new File("D:/Files/Book1.xlsx");
    FileInputStream fis;
    XSSFWorkbook xsf;
    XSSFSheet sheet;
    int row_count;
    int col_count = 8;
    String market = "sxpbtc";
    String filename;
    HSSFWorkbook workbook;
    HSSFSheet sheet1;
    HSSFRow rowhead;



    //super("admin2@monster.com", "Admin_test@123");



    public trading() throws IOException {



        //super(email ="shiva.mahajan+6@antiersolutions.com", pass= "Test@123");
//        Login l = new Login("admin2@monster.com", "Admin_test@123");
        src = new File("D:/Files/Book1.xlsx");
        fis = new FileInputStream(src);
        xsf = new XSSFWorkbook(fis);
        sheet = xsf.getSheet("Sheet1");
        row_count = sheet.getPhysicalNumberOfRows();
        // super("admin2@monster.com", "Admin_test@123");
//        filename = "D:\\demo\\new.xlsx";
//        //creating an instance of HSSFWorkbook class
//        workbook = new HSSFWorkbook();
//        //invoking creatSheet() method and passing the name of the sheet to be created
//        sheet1 = workbook.createSheet("January");


    }

    @Test(priority = 8)
    void main() throws IOException, InterruptedException {
        read_data(row_count, col_count);
    }

    //@Test(priority = 10)
    void read_data(int rowNum, int colNum) throws IOException, InterruptedException {
        System.out.println(row_count);

        Thread.sleep(3000);
        driver.get("https://exchange.stage-coingeb.com/trading/" + market +"");  //" + market + "
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)","");





        for (int i = 2; i < 7; i++) {


            Thread.sleep(3000);
            for (int j = 0; j <= col_count; j++) {
                if (j == 0) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    //System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    String str = String.valueOf(entry);
                    WebElement g = driver.findElement(By.xpath("//input[@placeholder='Price']"));
                    g.click();
                    g.clear();
                    g.sendKeys(str);
                } else if (j == 1) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    // System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    String str = String.valueOf(entry);
                    driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(str);
                }
                else if (j == 7) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                }
                else if (j == 8) {

                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    driver.findElement(By.xpath("//button[@class='ui button resetButton buyButton']")).click();
                }

                //go to order history

            }
        }

        super.secondUser();

        Thread.sleep(3000);
        driver.get("https://exchange.stage-coingeb.com/trading/" + market +"");  //" + market + "
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)","");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[normalize-space()='Sell']")).click();
        for(int i = 11; i<17;i++){
            Thread.sleep(3000);
            for (int j = 0; j <= col_count; j++) {
                if (j == 0) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    //System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    String str = String.valueOf(entry);
                    WebElement g = driver.findElement(By.xpath("//input[@placeholder='Price']"));
                    g.click();
                    g.clear();
                    g.sendKeys(str);
                } else if (j == 1) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    // System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    String str = String.valueOf(entry);
                    driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(str);
                }
                else if (j == 7) {
                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                }
                else if (j == 8) {

                    double entry = sheet.getRow(i).getCell(j).getNumericCellValue();                                //String entry1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    System.out.println("The data in row " + i + " column " + j + " is : " + entry);
                    driver.findElement(By.xpath("//button[@class='ui button resetButton sellButton']")).click();//button[@class='ui button resetButton sellButton']
                }

                //go to order history

            }
        }
        //closing the workbook
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
//closing the Stream
        fileOut.close();
//closing the workbook
        workbook.close();
        xsf.close();


    }

//    @Test(priority = 2)
//    void navigateTrading() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.navigate().to("https://exchange.stage-coingeb.com/trading/dogeusdt");
//        Thread.sleep(1000);
//    }
//
//    @Test(priority = 3)
//    void trade() throws InterruptedException {
//        Thread.sleep(2000);
//        WebElement s = driver.findElement(By.xpath("//input[@placeholder='Price']"));
//        s.clear();
//        s.sendKeys("0.2");
//        driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("12");
//    }
}
