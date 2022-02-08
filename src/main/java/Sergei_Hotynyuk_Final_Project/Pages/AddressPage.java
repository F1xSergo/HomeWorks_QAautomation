package Sergei_Hotynyuk_Final_Project.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddressPage {
    private final SelenideElement manageAddressBook = $(byText("Manage address book"));
    private final SelenideElement addAddressButton = $x("//div[@id='ya-myab-plus-address-icon']");
    private final SelenideElement removeAddressButton = $x("//a[@id='ya-myab-address-delete-btn-0']");
    private final SelenideElement buttonYes = $x("//span[@id='deleteAddressModal-0-submit-btn-announce'][@class='a-button-text']");

    private final SelenideElement addCountry = $x("//span[@class='a-button-text a-declarative'][@data-action='a-dropdown-button']");
    private final SelenideElement Belarus = $x("//a[@id='address-ui-widgets-countryCode-dropdown-nativeId_20']");
    private final SelenideElement addFullName = $x("//input[@type='text'][@id='address-ui-widgets-enterAddressFullName']");
    private final SelenideElement addStreetAddress = $x("//input[@type='text'][@id='address-ui-widgets-enterAddressLine1']");
    private final SelenideElement addCity = $x("//input[@type='text'][@id='address-ui-widgets-enterAddressCity']");
    private final SelenideElement addZipCode = $x("//input[@type='text'][@id='address-ui-widgets-enterAddressPostalCode']");
    private final SelenideElement addPhoneNumber = $x("//input[@type='text'][@id='address-ui-widgets-enterAddressPhoneNumber']");
    private final SelenideElement buttonAddAddress = $x("//input[@class='a-button-input']");

    private final SelenideElement bannerAddressSaved = $x("//h4[@class='a-alert-heading']");
//    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;



    public AddressPage goToAddressForm() {
        manageAddressBook.hover().click();
        return this;
    }
    public AddressPage addAddressButton() {
        addAddressButton.click();
        return this;
    }
    public AddressPage removeAddressButton() {
        removeAddressButton.click();
        buttonYes.hover().click();
        return this;
    }
    public AddressPage enterAddressDetails(String name, String street, String city, String index, String number){
        addCountry.click();
        Belarus.click();
        addFullName.setValue(name);
        addStreetAddress.setValue(street);
        addCity.setValue(city);
        addZipCode.setValue(index);
        addPhoneNumber.setValue(number);
        buttonAddAddress.click();
        return this;
    }


    public String checkAddressSave(){
        return bannerAddressSaved.text();
    }
}
