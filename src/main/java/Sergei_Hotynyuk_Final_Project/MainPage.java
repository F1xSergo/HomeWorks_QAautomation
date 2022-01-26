package Sergei_Hotynyuk_Final_Project;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    private final SelenideElement sectionAll = $x("//span[@class='hm-icon-label']");
    private final SelenideElement sectionComputers = $x("//a[@class='hmenu-item'][@data-menu-id = '6']");
    private final SelenideElement sectionMonitors = $(byText("Monitors"));


    public MainPage(String url) {
        Selenide.open(url);
    }

    public SectionAllPage enterInSectionAll() {
        sectionAll.scrollIntoView(false).click();
        return new SectionAllPage();
    }

    public MonitorsPage navigationToSectionMonitors() {
        sectionAll.scrollIntoView(false).click();
        sectionComputers.scrollIntoView(false).click();
        sectionMonitors.scrollIntoView(false).click();
        return new MonitorsPage();
    }
}
