package Test_Final_Project;

import Sergei_Hotynyuk_Final_Project.Pages.CartPage;
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

    @Test
    public void testNavigationThroughSection() {
        SelenideElement sectionMonitors = new MainPage(BASE_URL)
                .navigationToSectionMonitors()
                .sectionMonitorsIsNotEmpty();

        Assertions.assertTrue(sectionMonitors.exists());
    }

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

    @Test
    public void testAuthorization() {
        String expectedName = new MainPage(BASE_URL)
                .authorization()
                .enterLogAndPass(email, password)
                .checkName();
//проверяем что мы авторизованы, и наш юзер Sergey
        Assertions.assertTrue(expectedName.endsWith("Sergey"));
        Assertions.assertTrue(expectedName.contains("Sergey"));
    }
}
