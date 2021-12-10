package Test_HW_3;
//1. Составить чек лист - какие проверки можно провести для данного приложения. (Минимум 10 идей)
//2. Найти все ошибки, которые присутствуют в приложении и подсветить их тестами.
//3. Реализовать идеи из чек листа. Использовать дата провайдеры для параметризации. Использовать конфигурационные файлы тест нг для запуска тестов.
// (10 тестов, для 1-го теста может быть большой набор данных, но это считается за 1 тест)
//
//Исходный код - не трогать! Ошибки не исправлять, только подсвечивать тестами!


import Sergei_Hotynyuk_HW_3.triangle.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest extends DataProvidersTriangle {
    Triangle triangle = null;
    TrueTriangleSQRT trueTrSqrt = null;


    @Test(dataProvider = "test1")//подсвечиваем ошибку в коде
    public void test_checkMethod_GetMessageParam(double a, double b, double c, String x) {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(c <= 0, triangle.checkTriangle(), triangle.getMessage());
    }

    @Test(dataProvider = "test2")//проверка на суммы сторон
    public void test_checkMethod_SumSide(double a, double b, double c, String x) {
        triangle = new Triangle(a, b, c);
        Assert.assertFalse(triangle.checkTriangle(), triangle.getMessage());
    }

    @Test
    public void test_checkMethod_minus() {//проверка на отрцательное значение
        triangle = new Triangle(-2, -2, -2);
        Assert.assertFalse(triangle.checkTriangle());
    }

    @Test
    public void test_checkMethod_Zero() {//проверка на 0
        triangle = new Triangle(3, 3, 0);
        Assert.assertFalse(triangle.checkTriangle());
    }

    @Test(dataProvider = "test3")//подсвечивание ошибки detect метода прямоугольного треугольника
    public void test_detectTriangle_RECTANGULAR(double a, double b, double c, String x) {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(8, triangle.detectTriangle(), x);
    }

    @Test(dataProvider = "test3.1")//подсвечивание ошибки кода detect метода прямоугольного треугольника
    public void test_detectTriangle_RECTANGULAR_message(String x) {
        Assert.assertEquals("a * a + c * c == b * b", x);
    }


    @Test(dataProvider = "test4")//подсвечивание ошибки кода detect метода равностороннего треугольника
    public void test_detectTriangle_EQUILATERAL(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(1, triangle.detectTriangle(), triangle.getMessage());
    }

    @Test(dataProvider = "test5")// проверка detect метода равнобедренного
    public void test_detectTriangle_ISOSCELES(double a, double b, double c) {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(2, triangle.detectTriangle(), triangle.getMessage());
    }


    @Test
    public void test_detectTriangle_ORDYNARY() {// проверка detect метода обычного
        triangle = new Triangle(4, 3, 2);
        Assert.assertEquals(4, triangle.detectTriangle(), triangle.getMessage());
    }

    @Test(expectedExceptions = NullPointerException.class) //проверка на значение null
    public void testNullPointerException() {
        Assert.assertNull(triangle.detectTriangle());
    }

    @Test(groups = "Sqrt")
    public void testSqrtMethodEQUILATERAL() {
        triangle = new Triangle(2, 2, 2);
        trueTrSqrt = new TrueTriangleSQRT(2, 2, 2);
        Assert.assertEquals(trueTrSqrt.getSquareTRUE(), triangle.getSquare(), "bad SQRT");
    }

    @Test(groups = "Sqrt")
    public void testSqrtMethodISOSCELES() {
        triangle = new Triangle(2, 2, 1);
        trueTrSqrt = new TrueTriangleSQRT(2, 2, 1);
        Assert.assertEquals(trueTrSqrt.getSquareTRUE(), triangle.getSquare(), "bad SQRT");
    }

    @Test(groups = "Sqrt")
    public void testSqrtMethodRECTANGULAR() {
        triangle = new Triangle(2, 2, 2.8284271247462);
        trueTrSqrt = new TrueTriangleSQRT(2, 2, 2.8284271247462);
        Assert.assertEquals(trueTrSqrt.getSquareTRUE(), triangle.getSquare(), "bad SQRT");
    }

    @Test(groups = "Sqrt")
    public void testSqrtMethodORDYNARY() {
        triangle = new Triangle(4, 3, 2);
        trueTrSqrt = new TrueTriangleSQRT(4, 3, 2);
        Assert.assertEquals(trueTrSqrt.getSquareTRUE(), triangle.getSquare(), "bad SQRT");
    }
}
