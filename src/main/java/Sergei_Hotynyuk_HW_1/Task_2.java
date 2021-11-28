package Sergei_Hotynyuk_HW_1;

//Необходимо ввести n чисел с консоли. Найти максимальное и минимальное число.
// Вывести их в консоль. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину следующей строкой.(1 балл)

import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите последовательность чисел через пробел и нажмите Enter");
        System.err.println("Для подведения итогов введите любую букву и нажмите ENTER");
        ArrayList<Integer> numbers = new ArrayList<>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
        }

        int a = Collections.min(numbers);
        int b = Collections.max(numbers);

        // создал новый список, в котором отменяю все минусы и ищу самые короткие и длинные числа
        ArrayList<Integer> numbers2 = new ArrayList<>();

        for (Integer nn : numbers) {
            numbers2.add(Math.abs(nn));
        }

        int aa = Collections.min(numbers2);
        int bb = Collections.max(numbers2);

        String min = String.valueOf(aa);
        String max = String.valueOf(bb);

        System.out.println("Вы ввели следующие числа - " + numbers);
        System.out.println("Из них самое маленькое: " + a);
        System.out.println("Из них самое большое: " + b);
        System.out.println("Длина самого короткого: " + min.length());
        System.out.println("Длина самого длинного: " + max.length());
    }
}
