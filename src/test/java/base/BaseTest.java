package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;



import java.io.File;
import java.io.IOException;

public class BaseTest {
    private ChromeDriver driver;

    private String link = "https://aviasales.by/";

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(); //запускаем драйвер Хрома

        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    @AfterClass
    public void tearDone() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //метод делает скриншот
    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        System.out.println(screenshot.getAbsolutePath());

        //Files.move(screenshot, new File("src/test/resources/screenshots/screen_" + result.getName() + ".png"));//из пакета com.google.common.io
    }

    //скриншот если тест упал
    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result);
        }
    }

}
