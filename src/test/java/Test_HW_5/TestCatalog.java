package Test_HW_5;
//Реализовать 3 тест кейса для онлайнера, используя Selenide (Или чистый селениум):
//
//Обязательное условие - использовать подход Page Object
// (расширять ли его до Page Factory или/и Page Element - как удобно)
//
//1. открыть раздел каталог, проверить присутствие секций "Электроника", "Компьютеры и сети",
// "Бытовая техника","Стройка и ремонт",
//"Дом и сад","Авто и мото","Красота и спорт","Детям и мамам","Работа и офис","Еда".
//2.открыть секцию каталога "Компьютеры и сети". Убедиться, что появляется вертикальный список пунктов секции и присутствуют
// как минимум пункты "Ноутбуки,компьютеры, мониторы","Комплектующие","Хранение данных","Сетевое оборудование".
//3. Открыть пункт "Комплектующие". Проверить, что в появившемся списке комплектующих все элементы содержат название,
// количество товаров и минимальную цену.
//4. Все тесты должны быть независимы друг от друга.
//5. Если используется Junit5 - использовать assertAll, где это целесообразно. В случае использования других фреймворков или
// Selenide.should - сделать аналог,
//позволяющий выполнить несколько независимых проверок без мнгновенного прекращения на первой.
//6. Попробовать включить режим эмуляции мобильного устройства, при необходимости доработать тесты для совместимости с
// таким режимом. (Опционально)

import Sergei_Hotynyuk_HW_5.CatalogPage;
import Sergei_Hotynyuk_HW_5.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCatalog extends MainTest {
    private final static String BASE_URL = "https://www.onliner.by/";
    private final static List<String> EXPECTED_SECTIONS = new ArrayList<>(Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда"));
    private final static List<String> EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS = new ArrayList<>(Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование"));

    @Test
    public void testCheckInCatalogSections() {
        List<String> actualSections = new MainPage(BASE_URL)
                .enterCatalog()
                .getSpanFromCatalogSections();

        Assertions.assertEquals(EXPECTED_SECTIONS, actualSections);
    }

    @Test
    public void testCheckCatalogSectionComputerAndNetwork() {

        List<String> actualSectionsInComputerAndNetwork = new MainPage(BASE_URL)
                .enterCatalogAndNetworks()
                .getDivFromComputerAndNetworks();

        CatalogPage verticalSectionsIsVisible = new CatalogPage();

        //проверяем или вертикальная секция появляется
        Assertions.assertTrue(verticalSectionsIsVisible.isVisible());
        //проверяем или содержатся элементы в Компьютеры и сети имеются определенные секции
        Assertions.assertTrue(actualSectionsInComputerAndNetwork.containsAll(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS));
    }

    @Test
    public void testCheckAccessories() {
        CatalogPage actualInfoAccessories = new MainPage(BASE_URL)
                .enterCatalogAndNetworksAndClickAccessories();

        Assertions.assertTrue(actualInfoAccessories.accessoriesPriceAndNameisNotEmpty());
    }
}