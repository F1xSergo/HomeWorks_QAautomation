package Sergei_Hotynyuk_Final_Project;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement sectionAll = $x("//span[@class='hm-icon-label']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public SectionAllPage enterInSectionAll(){
         sectionAll.scrollIntoView(false).click();
         return new SectionAllPage();

    }
}
