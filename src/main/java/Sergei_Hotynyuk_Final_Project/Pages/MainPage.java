package Sergei_Hotynyuk_Final_Project.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    private final SelenideElement sectionAll = $x("//span[@class='hm-icon-label']");
    private final SelenideElement sectionComputers = $x("//a[@class='hmenu-item'][@data-menu-id = '6']");
    private final SelenideElement sectionMonitors = $(byText("Monitors"));
    private final SelenideElement searchText = $x("//input[@type='text']");

    private ElementsCollection itemLink = $$x("//a");


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

    public MainPage enterTextToSearchString(String text) {
        searchText.sendKeys(text, Keys.ENTER);
        return this;
    }

    public ItemPage selectItemByText(String text) {
        itemLink.find(Condition.text(text)).scrollIntoView(false).click();
        return page(ItemPage.class);
    }
}
