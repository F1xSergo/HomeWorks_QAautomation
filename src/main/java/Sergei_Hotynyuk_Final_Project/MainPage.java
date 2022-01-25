package Sergei_Hotynyuk_Final_Project;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



public class MainPage {
    private SelenideElement sectionAll = $x("//span[@class='hm-icon-label']");
    private SelenideElement sectionComputers = $x("//a[@class = 'hmenu-item'][@data-menu-id = '6']");
    private SelenideElement sectionMonitors = $(byText("Monitors"));
    //private SelenideElement sectionMonitors = $x("//href[@class='https://www.amazon.com/s?bbn=16225007011&rh=i%3Aspecialty-aps%2Cn%3A16225007011%2Cn%3A1292115011&ref_=nav_em__nav_desktop_sa_intl_monitors_0_2_6_8']");


    public MainPage(String url) {
        Selenide.open(url);
    }

    public SectionAllPage enterInSectionAll(){
         sectionAll.scrollIntoView(false).click();
         return new SectionAllPage();
    }

    public MonitorsPage navigationToSectionMonitors(){
        sectionAll.scrollIntoView(false).click();
        sectionComputers.scrollIntoView(false).click();
        sectionMonitors.scrollIntoView(false).click();
        return new MonitorsPage();
    }
}
