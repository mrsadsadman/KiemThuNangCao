package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // TC01 – Đăng nhập hợp lệ
    @Test(priority = 1)
    public void loginWithValidAccount() {

        driver.findElement(By.name("username"))
                .sendKeys("0912345678"); // tài khoản hợp lệ

        driver.findElement(By.name("password"))
                .sendKeys("password123");

        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"))
                .click();

        // Kiểm tra login thành công (ví dụ: URL thay đổi)
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Đăng nhập không thành công!");
    }

    // TC02 – Sai mật khẩu
    @Test(priority = 2)
    public void loginWithInvalidPassword() {

        driver.navigate().refresh();

        driver.findElement(By.name("username"))
                .sendKeys("0912345678");

        driver.findElement(By.name("password"))
                .sendKeys("saimatkhau");

        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"))
                .click();

        Assert.assertTrue(
            driver.getPageSource().contains("Sai thông tin đăng nhập"),
            "Không hiển thị thông báo lỗi!"
        );
    }

    // TC03 – Bỏ trống dữ liệu
    @Test(priority = 3)
    public void loginWithEmptyData() {

        driver.navigate().refresh();

        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"))
                .click();

        Assert.assertTrue(
            driver.getPageSource().contains("Vui lòng nhập"),
            "Không hiển thị validate!"
        );
    }
}
