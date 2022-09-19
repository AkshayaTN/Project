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
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class postcreate {
	
	@Test
  public void f() throws BiffException, IOException {
		 excelsheet g = new  excelsheet();
		  excelsheet j=new  excelsheet();

		j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
//	      Workbook wb = Workbook.getWorkbook(f);
//	      Sheet sheet = wb.getSheet(2);
//	      System.out.println("Reading all users");
//	      Cell c1 = sheet.getCell(1,17);
//	      String baseURI = c1.getContents();
//	      System.out.println(baseURI);
//	      RestAssured.baseURI = baseURI;
//	      Cell c2 = sheet.getCell(6, 7);
//	      String endpoint = c2.getContents();
//	      System.out.println(endpoint);
//	      Cell c3 = sheet.getCell(1, 7);
//	      String Name = c3.getContents();
//	    //  System.out.println(name.asPrettyString());
//	      Cell c4 = sheet.getCell(2, 7);
//	      String Job = c4.getContents();
		String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,7);
	    String Name     =j.readexcel(1, 7);
	    String Job    =j.readexcel(2, 7);

	      String jsonString = "{\n"
	                + "    \"name\": \""+ Name +"\",\n"
	                + "    \"job\": \""+ Job + "\"\n"
	                + "}";
	          RequestSpecification requestSpecification= RestAssured.given();
	          requestSpecification.contentType(ContentType.JSON);
	          requestSpecification.body(jsonString);
	          Response response = requestSpecification.post(endpoint);
	          String responsestring = response.asPrettyString();
	          System.out.println(responsestring);
	          if(response.getStatusCode()==201)
	          {
	              j.writexcel("TestCase",15, 8, "passed");
	          }
	          else
	          {
	              j.writexcel("TestCase",15, 8, "failed");
	          }

  }
}
