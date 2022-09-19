package Utilities;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;
public class loginUncess {
	public void incorrectPass() throws BiffException, IOException {
	       excelsheet j = new excelsheet();
	       j.open("C:\\\\Users\\\\Akshaya TN\\\\Desktop\\\\FinalProject\\\\src\\\\test\\\\java\\\\TestCases\\\\TestCase.xls");

	        String baseURI = j.readexcel(1, 17);
	        RestAssured.baseURI = baseURI;
	        String endpoint = j.readexcel(6, 23);
	        System.out.println(endpoint);
	        String email = j.readexcel(3, 23);
	        String password = j.readexcel(4, 23);
	        String jsonstring = "{\n"



	               + "    \"email\": \"" + email + "\",\n"



	               + "    \"password\": \"" + password + "\"\n"



	               + "}";

	       RequestSpecification requestSpecification = RestAssured.given();
	       requestSpecification.contentType(ContentType.JSON);
	       requestSpecification.body(jsonstring);
	       Response response = requestSpecification.post(endpoint);
	       System.out.println(response.getStatusCode());
	       System.out.println(response.asPrettyString());
	       System.out.println("user login unsuccessful");
	 }
    public void withoutEmail() throws BiffException, IOException {
      excelsheet j = new  excelsheet();
      j.open("C:\\\\Users\\\\Akshaya TN\\\\Desktop\\\\FinalProject\\\\src\\\\test\\\\java\\\\TestCases\\\\TestCase.xls");
        String baseURI = j.readexcel(1, 17);
        RestAssured.baseURI = baseURI;
        String endpoint = j.readexcel(6, 24);
        System.out.println(endpoint);
        String email = j.readexcel(3, 24);
        String password = j.readexcel(4, 24);
        String jsonstring = "{\n"



               + "    \"email\": \"" + email + "\",\n"



               + "    \"password\": \"" + password + "\"\n"



               + "}";
       RequestSpecification requestSpecification = RestAssured.given();
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(jsonstring);
       Response response = requestSpecification.post(endpoint);
       System.out.println(response.getStatusCode());
       System.out.println(response.asPrettyString());
       System.out.println("user login unsuccessful");
    }
    public void withoutPassword() throws BiffException, IOException {
       excelsheet j = new excelsheet();
       j.open("C:\\\\Users\\\\Akshaya TN\\\\Desktop\\\\FinalProject\\\\src\\\\test\\\\java\\\\TestCases\\\\TestCase.xls");

        String baseURI = j.readexcel(1, 17);
        RestAssured.baseURI = baseURI;
        String endpoint = j.readexcel(6, 25);
        System.out.println(endpoint);
        String email = j.readexcel(3, 25);
        String password = j.readexcel(4, 25);
        String jsonstring = "{\n"



               + "    \"email\": \"" + email + "\",\n"



               + "    \"password\": \"" + password + "\"\n"



               + "}";
       RequestSpecification requestSpecification = RestAssured.given();
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(jsonstring);
       Response response = requestSpecification.post(endpoint);
       System.out.println(response.getStatusCode());
       System.out.println(response.asPrettyString());
       System.out.println("user login unsuccessful");
    }
    public void NullTest() throws BiffException, IOException {
      excelsheet j = new excelsheet();
      j.open("C:\\\\Users\\\\Akshaya TN\\\\Desktop\\\\FinalProject\\\\src\\\\test\\\\java\\\\TestCases\\\\TestCase.xls");
        String baseURI = j.readexcel(1, 17);
        RestAssured.baseURI = baseURI;
        String endpoint = j.readexcel(6, 26);
        System.out.println(endpoint);
        String email = j.readexcel(4, 26);
        String password = j.readexcel(5, 26);
        String jsonstring = "{\n"



               + "    \"email\": \"" + email + "\",\n"



               + "    \"password\": \"" + password + "\"\n"



               + "}";
       RequestSpecification requestSpecification = RestAssured.given();
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.body(jsonstring);
       Response response = requestSpecification.post(endpoint);
       System.out.println(response.getStatusCode());
       System.out.println(response.asPrettyString());
       System.out.println("user login unsuccessful");
    }  
}
