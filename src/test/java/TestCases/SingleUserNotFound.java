package TestCases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.excelsheet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SingleUserNotFound  {
  @Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();
	  j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
//      Workbook wb = Workbook.getWorkbook(f);
//      Sheet sheet = wb.getSheet(2);
//      System.out.println("Reading all users");
//      Cell c1 = sheet.getCell(1,17);
//      String baseURI = c1.getContents();
//      System.out.println(baseURI);
//      RestAssured.baseURI = baseURI;
//      Cell c2 = sheet.getCell(6, 3);
//      String endpoint = c2.getContents();
	  String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,3);
      System.out.println(endpoint);
      Response response = RestAssured.get(endpoint);
      System.out.println(response.getStatusCode());
      System.out.println(response.getStatusLine());
      System.out.println(response.getTime());
      System.out.println(response.getBody().asPrettyString());
      if(response.getStatusCode()==404)
      {
          j.writexcel("TestCase",15, 6, "passed");
      }
      else
      {
          j.writexcel("TestCase",15, 6, "failed");
      }
  }
}
