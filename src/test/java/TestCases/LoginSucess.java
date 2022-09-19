package TestCases;

import org.testng.annotations.Test;
import Utilities.loginUncess;

import java.io.File;
import java.io.IOException;



//import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import Utilities.excelsheet;
public class LoginSucess {
  @Test
  public void f() throws BiffException, IOException {
	  loginUncess ls=new loginUncess();
      ls.incorrectPass();
      ls.withoutEmail();
      ls.withoutPassword();
      ls.NullTest();
      
  }
}
