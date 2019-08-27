package com.pack.common.tests;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.MyAccountPage;
import com.pack.common.pageobjects.NinjaStoreHomePage;
import com.pack.common.supportClasses.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

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
        screenShot=new ScreenShot(driver);

        Assert.assertTrue(logInPage.verifyMyAccPageTitle(), "Sign In page title doesn't match");
        Assert.assertTrue(logInPage.verifySignIn(), "Unable to Log in");
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult){
        if (testResult.getStatus() == ITestResult.FAILURE) {

            String testName=testResult.getName();
            String testType= Arrays.toString(testResult.getParameters());
            String screenshotFileName=testName+testType;

            screenShot.CaptureScreenShot(screenshotFileName);
        }
    }




}
