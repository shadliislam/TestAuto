package com.pack.common.tests;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.MyAccountPage;
import com.pack.common.pageobjects.NinjaStoreHomePage;
import com.pack.common.pageobjects.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterAccountTest extends TestBaseSetup {
    private WebDriver driver;
    private MyAccountPage loginPage;
    private NinjaStoreHomePage homePage;
    private RegisterAccountPage registerAccPage;



    @BeforeClass
    public void setUp(){
        driver=getDriver();
    }

    @Test
    public void verifyRegisterAccountPage(){
        System.out.println("Create An Account page test...");
        homePage = new NinjaStoreHomePage(driver);
        loginPage = homePage.clickLogInBtn();
        registerAccPage = loginPage.clickOnContinueRegister();
        Assert.assertTrue(registerAccPage.verifyPageTitle(), "Page title not matching");

    }
}
