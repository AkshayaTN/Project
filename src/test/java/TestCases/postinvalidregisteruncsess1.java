package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.excelsheet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;

public class postinvalidregisteruncsess1 {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
	@Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();
	j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
	  
//	Workbook wb = Workbook.getWorkbook(f);
//	 Workbook workbook = Workbook.getWorkbook(f);
//     Sheet sheet1 = workbook.getSheet(2);
//     Cell c1 = sheet1.getCell(1, 17);
//     RestAssured.baseURI = c1.getContents();
//     
//     Sheet sheet2 = workbook.getSheet(2);
//     Cell c2 = sheet2.getCell(6,12);
//     String endpoint = c2.getContents();
//     
//     Cell c3 = sheet2.getCell(3,12);
//     String email = c3.getContents();
	String baseURI = j.readexcel(1, 17);
    RestAssured.baseURI = baseURI;
    String endpoint = j.readexcel(6,23);
    String password = j.readexcel(4, 23);
     String jsonstring = "{\n"
               + "    \"password\": \""+ password + "\"\n"
               + "}";
     
     RequestSpecification requestSpecification= RestAssured.given();
     requestSpecification.contentType(ContentType.JSON);
     requestSpecification.body(jsonstring);
     Response response = requestSpecification.post(endpoint);
     int responseStatusCode = response.getStatusCode();
     System.out.println("************************************************");
     System.out.println("Status Code => "+ responseStatusCode);
     System.out.println("User register UnSuccessful");
     System.out.println(response.asPrettyString());
     if(response.getStatusCode()==400)
     {
         j.writexcel("TestCase",15, 23, "passed");
     }
     else
     {
         j.writexcel("TestCase",15, 23
        		 , "failed");
     }
	     

  }
}
