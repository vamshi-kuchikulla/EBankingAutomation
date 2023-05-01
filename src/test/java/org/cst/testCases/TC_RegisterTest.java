package org.cst.testCases;

import org.cst.baseUtil.BaseTest;
import org.cst.pageObjects.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_RegisterTest extends BaseTest {

    @Test(dataProvider = "userData")
    public void registerUser(Map<String,String> userDataMap) throws IOException {
        RegisterPage registerPage = landingPage.signUp();
        registerPage.registerApplication(userDataMap);
    }

    @DataProvider(name = "userData")
    public Object[][] dataProvider(){
        HashMap<String, String> personalDataMap = new HashMap<>();
        personalDataMap.put("firstName","Vamshi");
        personalDataMap.put("surName","Krishna");
        personalDataMap.put("email","vamshi.krishna@gmail.com");
        personalDataMap.put("mobile","4372994577");
        personalDataMap.put("userName","vamshi.krishna");
        personalDataMap.put("password","Kvk@123");
        personalDataMap.put("conformPassword","Kvk@123");
        return new Object[][]{{personalDataMap}};
    }
}
