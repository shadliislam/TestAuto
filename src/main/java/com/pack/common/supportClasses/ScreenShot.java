package com.pack.common.supportClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    private WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    String destPath="C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\java\\com\\pack\\logReports\\";

    public void CaptureScreenShot(String fileName) {

        //driver.get(url);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src,new File(this.destPath+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}



