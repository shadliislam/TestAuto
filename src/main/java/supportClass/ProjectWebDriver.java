package supportClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectWebDriver {
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;

    }
}
