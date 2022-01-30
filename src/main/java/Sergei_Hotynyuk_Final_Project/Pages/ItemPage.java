package Sergei_Hotynyuk_Final_Project.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class ItemPage {
    private final SelenideElement addToCart = $x("//input[@id='add-to-cart-button']");

    public CartPage addToCart() {
        addToCart.click();
        return new CartPage();
    }
}
