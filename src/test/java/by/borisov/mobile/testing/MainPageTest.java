package by.borisov.mobile.testing;

import by.borisov.mobile.testing.driver.DriverManager;
import by.borisov.mobile.testing.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void clickOnMainButton() {
        MainPage mainPage = new MainPage();
        By id = By.id("ru.ozon.app.android:id/menu_main");
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(id));
        mainPage.clickOnMainPageButton();
        //Assert.assertEquals(2,3);
    }
}
