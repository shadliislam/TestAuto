package com.pack.common.tests;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.MyAccountPage;
import com.pack.common.pageobjects.NinjaStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supportClass.ScreenShot;

public class MyAccountTest extends TestBaseSetup {
    private WebDriver driver;
    private MyAccountPage logInPage;
    private NinjaStoreHomePage homePage;
    private ScreenShot screenShot;

    @BeforeClass
    public void setUp(){
        driver=getDriver();
    }

    @Test
    public void verifyLoginFunction(){
        System.out.println("Sign In functionality details...");

        homePage=new NinjaStoreHomePage(driver);
        logInPage=homePage.clickLogInBtn();


        Assert.assertTrue(logInPage.verifyMyAccPageTitle(), "Sign In page title doesn't match");
        Assert.assertTrue(logInPage.verifySignIn(), "Unable to Log in");
        screenShot.CaptureScreenShot("sign in");

    }


}
