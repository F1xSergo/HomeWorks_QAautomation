package Sergei_Hotynyuk_Final_Project;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class SectionAllPage {
    private final ElementsCollection sectionsAll = $$x("//div[@class='hmenu-item hmenu-title']");
    private final ElementsCollection sectionShopByDepartament = $$x("//div[@class='hmenu-item hmenu-title']");

    public List<String> getDivElementsFromSectionAll() {
        return sectionsAll.texts();
    }


}
