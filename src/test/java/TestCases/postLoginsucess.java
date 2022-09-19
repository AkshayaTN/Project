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

public class postLoginsucess {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();
	  j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
//      Workbook wb = Workbook.getWorkbook(f);
//
//      Sheet sheet = wb.getSheet(2);   
//
//      Cell c1 = sheet.getCell(1,17);
//
//      RestAssured.baseURI = c1.getContents();
//
//      Cell c2 = sheet.getCell(3, 13);
//
//      String email = c2.getContents();
//
//      Cell c3 = sheet.getCell(4, 15);
//
//      String password = c3.getContents();
//
//      Cell c4 = sheet.getCell(6, 13);
//
//      String endpoint = c4.getContents();
	  String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,13);
	    String email = j.readexcel(3, 13);
	    String password = j.readexcel(4, 13);
      String jsonstring = "{\n"

            + "    \"email\": \""+ email + "\",\n"

            + "    \"password\": \""+ password + "\"\n"

            + "}";

        RequestSpecification requestSpecification= RestAssured.given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonstring);

        Response response = requestSpecification.post(endpoint);

        System.out.println(response.getStatusCode());

        System.out.println("user login successful");

        System.out.println(response.asPrettyString());

        System.out.println();
        if(response.getStatusCode()==200)
        {
            j.writexcel("TestCase",15, 11, "passed");
        }
        else
        {
            j.writexcel("TestCase",15, 11, "failed");
        }
  }
}
