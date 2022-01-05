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

import static com.codeborne.selenide.Selenide.open;

public class TestCatalog extends MainTest {
    private final static String BASE_URL = "https://www.onliner.by/";
    private final static String CATALOG_URL = "https://catalog.onliner.by/";

    @Test
    public void checkInCatalogSections() {
        MainPage mainPage = open(BASE_URL, MainPage.class);
        mainPage.enterCatalog();
        CatalogPage catalogPage = new CatalogPage();

        List<String> actualSection = catalogPage.getSpanFromCatalogSections();
        List<String> expectedSections = new ArrayList<>(Arrays.asList("Электроника", "Компьютеры и сети",
                "Бытовая техника", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда"));

        //System.out.println(actualSection);
        Assertions.assertEquals(expectedSections, actualSection);
    }
}
