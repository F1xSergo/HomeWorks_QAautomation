package Sergei_Hotynyuk_HW_5;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement catalogStr = $x("//span[@class='b-main-navigation__text']");
    private SelenideElement catalogStrComputerAndNetworks = $(byText("Компьютеры и сети"));
    private SelenideElement clickAccessories = $(byText("Комплектующие"));


    public MainPage(String url) {
        Selenide.open(url);
    }

    public CatalogPage enterCatalog() {
        catalogStr.scrollIntoView(false).click();
        return new CatalogPage();
    }

    public CatalogPage enterCatalogAndNetworks() {
        catalogStr.scrollIntoView(false).click();
        catalogStrComputerAndNetworks.scrollIntoView(false).click();
        return new CatalogPage();
    }

    public CatalogPage isVisibleVerticalSection() {
        catalogStr.scrollIntoView(false).click();
        catalogStrComputerAndNetworks.scrollIntoView(false).click();
        return new CatalogPage();
    }

    public CatalogPage enterCatalogAndNetworksAndClickAccessories() {
        catalogStr.scrollIntoView(false).click();
        catalogStrComputerAndNetworks.scrollIntoView(false).click();
        clickAccessories.click();
        return new CatalogPage();
    }
}
