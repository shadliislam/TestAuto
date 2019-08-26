package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NinjaStoreHomePage{
    protected WebDriver driver;
    private By myAccButton=By.xpath("//div[@id=\"top-links\"]/ul/li[2]/a");
    private By loginButton=By.xpath("//div[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");

    public NinjaStoreHomePage(WebDriver driver){
        this.driver=driver;
    }

    public MyAccountPage clickLogInBtn() {

        System.out.println("clicking on log in button");

        WebElement myAccBtnElement=driver.findElement(myAccButton);
        if(myAccBtnElement.isDisplayed()||myAccBtnElement.isEnabled())
            myAccBtnElement.click();
        else System.out.println("My Account button not found");

        WebElement loginBtnElement=driver.findElement(loginButton);
        if (loginBtnElement.isDisplayed()||loginBtnElement.isEnabled())
            loginBtnElement.click();
        else System.out.println("Login option not found");

        return new MyAccountPage(driver);
    }

   public String getPageTitle(){
        String title=driver.getTitle();
        return title;
   }

   public boolean verifyHomePageTitle(){
        String expectedPageTitle="The Ninja Store";
        return getPageTitle().contains(expectedPageTitle);
   }


}
