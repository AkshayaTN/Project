package TestCases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.excelsheet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class put {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();
	  j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
//	  Workbook workbook = Workbook.getWorkbook(f);
//      System.out.println("Creating user data");
//      Sheet sheet1 = workbook.getSheet(2);
//      Cell c1 = sheet1.getCell(1, 17);
//      String baseURI = c1.getContents();
//      System.out.println(baseURI);
//      RestAssured.baseURI = baseURI;
//      
//     
//      Cell c2 = sheet1.getCell(6,8);
//      String endpoint = c2.getContents();
//      System.out.println(endpoint);
//      
//      
//      Cell c3 = sheet1.getCell(1, 8);
//      String name = c3.getContents();
//      Sheet sheet4 = workbook.getSheet(0);
//      Cell c4 = sheet4.getCell(2, 8);
//      String job = c4.getContents();
	  String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,8);
	    String name = j.readexcel(1, 8);
	    String job = j.readexcel(2, 8);
     String jsonString = "{\n"
                + "    \"name\": \""+ name +"\",\n"
                + "    \"job\": \""+ job + "\"\n"
                + "}";
          RequestSpecification requestSpecification= RestAssured.given();
          requestSpecification.contentType(ContentType.JSON);
          requestSpecification.body(jsonString);
          Response response1 = requestSpecification.put(endpoint);
         System.out.println(response1.getStatusCode());
          String responsestring = response1.asPrettyString();
          System.out.println(responsestring);
          if(response1.getStatusCode()==200)
          {
              j.writexcel("TestCase",15, 14, "passed");
          }
          else
          {
              j.writexcel("TestCase",15, 14, "failed");
          }
  }
}
