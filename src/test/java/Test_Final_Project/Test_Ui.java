package Test_Final_Project;

import Sergei_Hotynyuk_Final_Project.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_Ui extends MainTest {
    private final static String BASE_URL = "https://www.amazon.com/";
    private final static List<String> EXPECTED_ELEMENTS_IN_SECTION_ALL = new ArrayList<>(Arrays.asList("Digital Content & Devices", "Shop By Department", "Programs & Features", "Help & Settings"));

    @Test
    public void testSectionAll(){
       List<String> elementsInSectionAll = new MainPage(BASE_URL)
               .enterInSectionAll()
               .getDivElementsFromSectionAll();

        Assertions.assertTrue(elementsInSectionAll.containsAll(EXPECTED_ELEMENTS_IN_SECTION_ALL));

    }
}
