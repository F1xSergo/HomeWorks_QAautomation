package Sergei_Hotynyuk_Final_Project.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailStr = $x("//input[@type='email']");
    private final SelenideElement passwordStr = $x("//input[@type='password']");
    private final SelenideElement continueButton = $x("//input[@id='continue']");
    private final SelenideElement signInButton = $x("//input[@id='signInSubmit']");
    private final SelenideElement checkUser = $x("//span[@id='nav-link-accountList-nav-line-1'][@class='nav-line-1 nav-progressive-content']");


    public LoginPage enterLogAndPass(String email, String pass) {
        emailStr.setValue(email).click();
        continueButton.click();
        passwordStr.setValue(pass).click();
        signInButton.click();
        // checkMainPage.shouldHave(Condition.checked).click();
        return this;
    }

    public String checkName() {
        return checkUser.text();
    }
}
