package com.pack.common.tests;

import com.pack.base.TestBaseSetup;
import com.pack.common.pageobjects.NinjaStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NInjaStoreHomeTest extends TestBaseSetup {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver=getDriver();
    }

    @Test
    public void verifyHomePage(){
        System.out.println("Home Page test...");
        NinjaStoreHomePage homePage=new NinjaStoreHomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageTitle(),"Home page Title doesn't match");
    }

}
