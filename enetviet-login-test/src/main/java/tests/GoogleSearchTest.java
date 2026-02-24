package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

import java.time.Duration;

public class GoogleSearchTest extends BaseTest {

    WebDriver driver;


    @Test
    public void searchWithKeywordSeleniumJava() {
        // 1. Mở Google
        driver.get("https://www.google.com");

        // 2. Nhập từ khóa "Selenium java"
        driver.findElement(By.name("q"))
                .sendKeys("Selenium java", Keys.ENTER);

        // 3. Kiểm tra kết quả tìm kiếm
        String title = driver.getTitle();
        Assert.assertTrue(
                title.toLowerCase().contains("selenium java"),
                "Tiêu đề không chứa từ khóa tìm kiếm!"
        );
    }

  
}
