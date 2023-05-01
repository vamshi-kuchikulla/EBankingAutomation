package org.cst.testCases;

import org.cst.baseUtil.BaseTest;

import org.cst.pageObjects.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void userLoginTest(Map<String, String> loginDataMap) throws IOException {
        LoginPage loginPage = landingPage.login();
        loginPage.userLogin(loginDataMap);
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider(){
        HashMap<String, String> personalDataMap = new HashMap<>();
        personalDataMap.put("userName","vamshi.krishna");
        personalDataMap.put("password","Kvk@123");
        return new Object[][]{{personalDataMap}};
    }
}
