package by.borisov.mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "ru.ozon.app.android:id/menu_main")
    private MobileElement mainPageButton;

    public MainPage clickOnMainPageButton() {
        mainPageButton.click();
        return this;
    }
}
