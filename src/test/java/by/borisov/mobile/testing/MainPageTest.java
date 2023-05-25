package by.borisov.mobile.testing;

import by.borisov.mobile.testing.pages.BasePage;
import by.borisov.mobile.testing.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BasePage {

    @Test
    public void clickOnMainButton() {
        MainPage mainPage = new MainPage();
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnMainPageButton();
        Assert.assertEquals(2,3);
    }
}
