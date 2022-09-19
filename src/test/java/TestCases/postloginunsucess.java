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
public class postloginunsucess {
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();

	  j.open("C:\\\\Users\\\\Akshaya TN\\\\Desktop\\\\FinalProject\\\\src\\\\test\\\\java\\\\TestCases\\\\TestCase.xls");

//      Workbook wb = Workbook.getWorkbook(f);
//
//      Sheet sheet = wb.getSheet(2);
//
//      System.out.println("Invalid user login");
//
//      Cell c1 = sheet.getCell(1,17);
//
//      RestAssured.baseURI = c1.getContents();
//
//      Cell c2 = sheet.getCell(3, 14);
//
//      String email = c2.getContents();
//
//      Cell c3 = sheet.getCell(6, 14);
//
//      String endpoint = c3.getContents();
	  String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,21);
	    String password = j.readexcel(4, 21);
	    
      String jsonstring = "{\n"

            + "    \"password\": \""+ password +"\"\n"

            + "}";

        RequestSpecification requestSpecification= RestAssured.given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonstring);

        Response response = requestSpecification.post(endpoint);

        System.out.println(response.getStatusCode());

        System.out.println(response.asPrettyString());

        System.out.println("user login unsuccessful");
        if(response.getStatusCode()==400)
        {
            j.writexcel("Test Cases",15, 20, "passed");
        }
        else
        {
            j.writexcel("Test Cases",15, 20, "failed");
        }
  }
}
