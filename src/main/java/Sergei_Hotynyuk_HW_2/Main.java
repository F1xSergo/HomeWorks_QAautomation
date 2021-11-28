package Sergei_Hotynyuk_HW_2;
//Для написания тестов использовать Junit 5
//Скачать с гита проект git@github.com:VladislavTulay/Test_calculator.git
//Написать юнит тесты на существующие операции
//Обработать исключение для операции деления, вывести информативное сообщение
//Написать отдельный метод, который добавляет возможность отправлять на вход любое количество параметров (либо заранее указанное, либо неопределенное)
//Добавить операции возведения в степень и взятие корня по аналогии с существующими операциями
//Дописать юнит-тесты на новый функционал
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 2 числа для обычных операций");
        int n1 = Integer.parseInt(sc.next());
        int n2 = Integer.parseInt(sc.next());

        System.out.println("Введите число для возведения в степень");
        int n3 = Integer.parseInt(sc.next());
        System.out.println("укажите в какую степень его возвести");
        int n4 = Integer.parseInt(sc.next());

        System.out.println("Введите число из которого хотите получить квадратный корень");
        int n5 = Integer.parseInt(sc.next());
        Calculator calculator = new Calculator(n1, n2);
        Calculator calculatorEx = new Calculator(n3, n4);
        Calculator calculatorSQRT = new Calculator(n5);

//        String[] stringmass = new String[10];
//
//        for (int i = 0; i < 10; i++) {
//            String randomStringUtils = RandomStringUtils.randomAlphanumeric(5);// генерируем строки длинной 5
//            stringmass[i] = StringUtils.capitalize(randomStringUtils);// помещаем в массив уже с большой заглавной буквы
//        }
//        System.out.println(Arrays.toString(stringmass));

        System.out.println("Plus result: " + calculator.calculate('+'));
        System.out.println("Minus result: " + calculator.calculate('-'));
        System.out.println("Division result: " + calculator.calculate('/'));
        System.out.println("Multiply result: " + calculator.calculate('*'));
        System.out.println("Exponentiation result: " + calculatorEx.calculate('^'));
        System.out.println("SQRT result: " + calculatorSQRT.calculate('№'));
        System.out.println("VAR result: " + calculator.varMethod(1,2,3,4));
    }
}

