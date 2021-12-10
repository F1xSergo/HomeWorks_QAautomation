package Test_HW_3;

import org.testng.annotations.DataProvider;

public class DataProvidersTriangle {
    @DataProvider(name = "test1")
    public static Object[][] paramTriangleMessage() {
        return new Object[][]{
                {0, 1, 1, "a<=0"},
                {1, 0, 1, "b<=0"},
                {1, 1, 0, "c<=0"},
        };
    }

    @DataProvider(name = "test2")
    public static Object[][] paramSumSideTriangleMessage() {
        return new Object[][]{
                {2, 2, 4, "a+b<=c"},
                {2, 4, 2, "a+c<=b"},
                {4, 2, 2, "b+c<=a"}
        };
    }

    @DataProvider(name = "test3")
    public static Object[][] paramDetectTriangleRECTANGULAR() {
        return new Object[][]{
                {2, 3.4641016151378, 4, "a * a + c * c == b * c"},
                {3.4641016151378, 2, 4, "b * b + c * c == a * a"},
                {2, 2, 2.8284271247462, "a * a + b * b == c * c"}
        };
    }

    @DataProvider(name = "test3.1")
    public static Object[][] paramDetectTriangleMessageRECTANGULAR() {
        return new Object[][]{
                {"a * a + c * c == b * c"}
        };
    }

    @DataProvider(name = "test4")
    public static Object[][] paramDetectTriangleMessageEQUILATERAL() {
        return new Object[][]{
                {3, 3, 3}
        };
    }

    @DataProvider(name = "test5")
    public static Object[][] paramDetectTriangleMessageISOSCELES() {
        return new Object[][]{
                {2, 2, 3},
                {2, 3, 2},
                {3, 2, 2}
        };
    }
}
