package Sergei_Hotynyuk_HW_5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private final ElementsCollection catalogSections = $$x("//span[@class='catalog-navigation-classifier__item-title-wrapper']");
    private final ElementsCollection catalogSectionsInComputerAndNetworks = $$x("//div[@class='catalog-navigation-list__aside-title']");
    private SelenideElement verticalcatalogSection = $x("//div[@class='catalog-navigation-list__aside-list']");
    // private ElementsCollection accessories = $$x("//div[@class='catalog-navigation-list__dropdown-list']");
    private SelenideElement name = $x("//span[@class='catalog-navigation-list__dropdown-title']");
    private SelenideElement minPrice = $x("//span[@class='catalog-navigation-list__dropdown-description']");

    public List<String> getSpanFromCatalogSections() {
        return catalogSections.texts();
    }

    public List<String> getDivFromComputerAndNetworks() {
        return catalogSectionsInComputerAndNetworks.texts();
    }

    public boolean isVisible() {
        return verticalcatalogSection.exists();
    }

    public boolean accessoriesPriceAndNameisNotEmpty() {
        return name.exists() && minPrice.exists();
    }
}
