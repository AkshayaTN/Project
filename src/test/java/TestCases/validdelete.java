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
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class validdelete {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
  @Test
  public void f() throws BiffException, IOException {
	  excelsheet g = new  excelsheet();
	  excelsheet j=new  excelsheet();
	  j.open("C:\\Users\\Akshaya TN\\Desktop\\FinalProject\\src\\test\\java\\TestCases\\TestCase.xls");
	  String baseURI = j.readexcel(1, 17);
	    RestAssured.baseURI = baseURI;
	    String endpoint = j.readexcel(6,10);
		      Response response = RestAssured.get(endpoint);
		      RequestSpecification requestSpecification= RestAssured.given();
		      requestSpecification.contentType(ContentType.JSON);
		      Response response1 = requestSpecification.delete(endpoint);
		      System.out.println(response1.getStatusCode());
		      String responsestring = response1.asPrettyString();
		      System.out.println(responsestring);
		      if(response.getStatusCode()==204)
		      {
		          j.writexcel("TestCase",15, 17, "passed");
		      }
		      else
		      {
		          j.writexcel("TestCase",15, 17, "failed");
		      }
		      }
		}
  