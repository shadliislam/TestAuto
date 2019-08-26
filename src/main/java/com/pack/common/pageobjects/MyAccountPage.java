package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private WebDriver driver;

    private By continueRegisterBttn=By.xpath("//div[@id=\"content\"]/div/div[1]/div/a");
    private By emailTextBox=By.id("input-email");
    private By passwordTextBox=By.id("input-password");
    private By loginButton=By.xpath("//div[@id=\"content\"]/div/div[2]/div/form/input");
    private By warningMsgTxt=By.xpath("//*[@id=\"account-login\"]/div[1]");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public String getMyAccPageTitle(){

        String pageTitle=driver.getTitle();
        return pageTitle;
    }

    public boolean verifyMyAccPageTitle(){
        String expectedTitle="Account Login";
        return getMyAccPageTitle().contains(expectedTitle);
    }

    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if(emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordTextBox);
        if(passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public boolean verifySignIn() {
        enterUserName("test");
        enterPassword("pass");
        clickOnLogin();
        return getWarningMessage().contains("No match");
    }

    public RegisterAccountPage clickOnContinueRegister(){
        WebElement element=driver.findElement(continueRegisterBttn);
        if (element.isDisplayed()||element.isEnabled())
            element.click();
        return new RegisterAccountPage(driver);
    }

    public void clickOnLogin() {
        WebElement signInBtn = driver.findElement(loginButton);
        if (signInBtn.isDisplayed())
            signInBtn.click();
    }

    public String getWarningMessage() {
        String strWarningMsg = null;
        WebElement errorMsg = driver.findElement(warningMsgTxt);
        if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
            strWarningMsg = errorMsg.getText();
        return strWarningMsg;
    }













}
