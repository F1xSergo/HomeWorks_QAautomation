package Sergei_Hotynyuk_HW_5;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    // catalog-navigation-classifier__item
    private final ElementsCollection catalogSections = $$x("//span[@class='catalog-navigation-classifier__item-title-wrapper']");

    public List<String> getSpanFromCatalogSections() {
        return catalogSections.texts();
    }
}
