package BasePage;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("-headless");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
    }
}

