package Test_HW_5;


import com.codeborne.selenide.Configuration;

abstract public class MainTest {
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

//    @BeforeAll
//    public void init() {
//        setUp();
//    }
//
//    @AfterAll
//    public void tearDown() {
//        Selenide.closeWebDriver();
//    }
}
