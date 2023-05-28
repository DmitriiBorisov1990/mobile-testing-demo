package by.borisov.mobile.testing;

import by.borisov.mobile.testing.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void clickOnMainButton() {
        MainPage mainPage = new MainPage();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnMainPageButton();
        //Assert.assertEquals(2,3);
    }
}
