package com.sbn.tests;
import com.sbn.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest{
    @Test
    @Parameters({"user","password"})
    public void validateValidLoginCredentials(String user, String password){
        LoginPage loginPage = new LoginPage(driver);
        boolean isLoggedIn = loginPage.doLogin(user,password);
        Assert.assertTrue(isLoggedIn);
    }

    @Test(dataProvider = "simpleInvalidCred")
    public void validateInvalidLoginCredentials(String user, String password){
        LoginPage loginPage = new LoginPage(driver);
        boolean isLoggedIn = loginPage.doLogin(user,password);
        Assert.assertFalse(isLoggedIn);
    }


    @DataProvider(name = "fileBasedInvalidCred")
    Object[][] myData() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("./inputData/invalidCred.csv"));
        String[][] invalidCred = new String[lines.size()][2];
        int i=0;
        for (String line : lines) {
            invalidCred[i++] = line.split(",");
        }
        return invalidCred;
    }

    @DataProvider(name = "simpleInvalidCred")
    Object[][] invalidCred(){
        String[][] data = {{"user1","password1"},{"user2","password2"}};
        return data;
    }
}
