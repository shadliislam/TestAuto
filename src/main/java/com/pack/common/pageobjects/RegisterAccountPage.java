package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage {
    private WebDriver driver;

    private By fisrtNameTextBox=By.id("input-firstname");
    private By lastNameTextBox=By.id("input-lastname");
    private By emailTextBox=By.id("input-email");
    private By telephoneTextBox=By.id("input-telephone");
    private By passwordTextBox=By.id("input-password");
    private By confirmPasswrdTextBox=By.id("input-confirm");
    private By subscribeButtonYes=By.xpath("//div[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
    private By subscribeButtonNo=By.xpath("//div[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    private By privacyPolicyCheckbox=By.xpath("//div[@id=\"content\"]/form/div/div/input[1]");
    private By continueButton=By.xpath("//div[@id=\"content\"]/form/div/div/input[2]");


    public RegisterAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageTitle(){
        String title=driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle(){
        String pageTitle="Register Account";
        return getPageTitle().contains(pageTitle);
    }

    public void createAccount(){
        driver.findElement(fisrtNameTextBox).sendKeys("Robin");
        driver.findElement(lastNameTextBox).sendKeys("Hood");
        driver.findElement(emailTextBox).sendKeys("hfhf@xdc.com");
        driver.findElement(telephoneTextBox).sendKeys("82913887392");
        driver.findElement(passwordTextBox).sendKeys("dddd");
        driver.findElement(confirmPasswrdTextBox).sendKeys("dddd");

        driver.findElement(subscribeButtonNo).click();
        driver.findElement(privacyPolicyCheckbox).click();

        driver.findElement(continueButton).click();

    }



}
