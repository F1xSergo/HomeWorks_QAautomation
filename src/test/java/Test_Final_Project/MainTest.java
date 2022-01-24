package Test_Final_Project;

import com.codeborne.selenide.Configuration;

abstract public class MainTest {
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
}
