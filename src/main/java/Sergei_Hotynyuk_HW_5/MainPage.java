package Sergei_Hotynyuk_HW_5;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement catalogStr = $x("//span[@class='b-main-navigation__text']");


    public void enterCatalog() {
        catalogStr.scrollIntoView(false).click();
//        return page(MainPage.class);
    }
}
