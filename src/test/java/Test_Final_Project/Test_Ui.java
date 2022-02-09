package Test_Final_Project;

import Sergei_Hotynyuk_Final_Project.Pages.AddressPage;
import Sergei_Hotynyuk_Final_Project.Pages.CartPage;
import Sergei_Hotynyuk_Final_Project.Pages.LoginPage;
import Sergei_Hotynyuk_Final_Project.Pages.MainPage;
import Test_Final_Project.ConfProperties.ConfProperties;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class Test_Ui extends MainTest {
    private final static String BASE_URL = "https://www.amazon.com/";
    private final static List<String> EXPECTED_ELEMENTS_IN_SECTION_ALL =
            new ArrayList<>(Arrays.asList("Digital Content & Devices", "Shop By Department", "Programs & Features", "Help & Settings"));
    private static final String email = ConfProperties.getProperty("email");
    private static final String password = ConfProperties.getProperty("password");


    @Description("Тест проверяет или в секции находятся нужные элементы")
    @DisplayName("Тест проверяет или в секции находятся нужные элементы")
    @Test
    public void testSectionAll() {
        List<String> elementsInSectionAll = new MainPage(BASE_URL)
                .enterInSectionAll()
                .getDivElementsFromSectionAll();
        Assertions.assertTrue(elementsInSectionAll.containsAll(EXPECTED_ELEMENTS_IN_SECTION_ALL));
    }

    @Description("Тест проверяет или в секции 'Monitors' находятся товары")
    @DisplayName("Тест проверяет или в секции 'Monitors' находятся товары")
    @Test
    public void testNavigationThroughSection() {
        SelenideElement sectionMonitors = new MainPage(BASE_URL)
                .navigationToSectionMonitors()
                .sectionMonitorsIsNotEmpty();

        Assertions.assertTrue(sectionMonitors.exists());
    }

    @Description("Тест проверят или юзер находит товар через поиск, кладет его в корзину и проверят, что в корзине именно тот товар")
    @DisplayName("Тест проверят или юзер находит товар через поиск, кладет его в корзину и проверят, что в корзине именно тот товар")
    @CsvSource({"Lg ultragear, 'LG 27GL850-B 27 Inch Ultragear QHD Nano IPS 1ms NVIDIA G-Sync Compatible Gaming Monitor, Black'"})
    @ParameterizedTest
    public void testSearchItem(String serchItem, String expectedNameInCart) {
        CartPage cart = new MainPage(BASE_URL)
                .enterTextToSearchString(serchItem)
                .selectItemByText(expectedNameInCart)
                .addToCart()
                .openCart();

        String actualNameInCart = cart.getItemNameInCart();
//        Assertions.assertEquals(expectedNameInCart, actualNameInCart);

        assertAll(
                //проверка что в корзине не пусто
                () -> Assertions.assertTrue(cart.checkCartIsNotEmpty()),
                //проверяем что содержится нужное имя(необязательно)
                () -> Assertions.assertTrue(cart.checkItemExistInCart(expectedNameInCart)),
                //сравниваем что в корзине именно ожидаемы результат совпадает с актульным
                () -> Assertions.assertEquals(expectedNameInCart, actualNameInCart)
        );
    }

    @Description("Тест проверяет успешна ли авторизация и доп проверка, что авторизован 'Sergey' ")
    @DisplayName("Тест проверяет успешна ли авторизация и доп проверка, что авторизован 'Sergey' ")
    @Test
    public void testAuthorization() {
        LoginPage loginPage = new MainPage(BASE_URL)
                .authorization()
                .enterLogAndPass(email, password);
        String expectedName = loginPage.checkName();

//проверяем что мы авторизованы, и наш юзер Sergey
        Assertions.assertTrue(expectedName.endsWith("Sergey"));
        Assertions.assertTrue(expectedName.contains("Sergey"));
//добавить метод выхода из акк
      new MainPage(BASE_URL)
                .exitFromAccount();
    }

    @Description("Тест проверяет что авторизоция с неправильным логином выводит предупреждение ")
    @DisplayName("Тест проверяет что авторизоция с неправильным логином выводит предупреждение ")
    @Test
    public void testFalseEmailAuthorization() {
        boolean expectedName = new MainPage(BASE_URL)
                .authorization()
                .enterBadLog("BadEmail", password)
                .checkAlertForEmail();
        Assertions.assertTrue(expectedName);
    }

    @Description("Тест проверяет что авторизоция с неправильным паролем выводит предупреждение ")
    @DisplayName("Тест проверяет что авторизоция с неправильным паролем выводит предупреждение ")
    @Test
    public void testFalsePassAuthorization() {
        boolean expectedName = new MainPage(BASE_URL)
                .authorization()
                .enterLogAndPass(email, "BadPassword")
                .checkAlertForPass();
        Assertions.assertTrue(expectedName);
    }

    @Description("Тест проверяет что адрес успешно добавлен")
    @DisplayName("Тест проверяет что адрес успешно добавлен")
    @Test
    public void testAddAddress() throws InterruptedException {
        AddressPage addressPage = new MainPage(BASE_URL)
                .authorization()
                .enterLogAndPass(email, password)
                .enterToAddressSection()
                .goToAddressForm()
                .addAddressButton()
                .enterAddressDetails("Sergey", "Platonova", "Minsk", "220005", "375298003301");

        String actualCheckAddressSaveBanner = addressPage.checkAddressSave();

        Assertions.assertEquals("Address saved", actualCheckAddressSaveBanner);

        new MainPage(BASE_URL)
                .exitFromAccount();
    }

    @Description("Тест проверяет что адрес успешно удален")
    @DisplayName("Тест проверяет что адрес успешно удален")
    @Test
    public void testRemoveAddress() throws InterruptedException {
        AddressPage addressPage = new MainPage(BASE_URL)
                .authorization()
                .enterLogAndPass(email, password)
                .enterToAddressSection()
                .goToAddressForm()
                .removeAddressButton();

        String actualCheckAddressRemoveBanner = addressPage.checkAddressSave();

        Assertions.assertEquals("Address removed", actualCheckAddressRemoveBanner);
        
        new MainPage(BASE_URL)
                .exitFromAccount();
    }
}
