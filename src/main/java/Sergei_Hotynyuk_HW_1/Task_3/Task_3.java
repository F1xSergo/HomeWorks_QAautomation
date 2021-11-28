package Sergei_Hotynyuk_HW_1.Task_3;

//Написать класс Book с полями id, Название, Автор (ы), Год издания, Количество страниц, Цена, Тип переплета.
// Создать массив объектов Book. Вывести: a) список книг заданного автора; b) список книг название которых содержит заданное слово (фразу) c) список книг,
// выпущенных за определенный период времени (пр. С 1980 по 2000 гг). (3 балл)
//Использование Stream API – плюс. (+1 балл)

import java.util.*;

public class Task_3 {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Лето", "Bob", 1900, 2000, 150, "Мягкий"));
        books.add(new Book("Зима", "Bob", 1905, 2500, 3400, "Жесткий"));
        books.add(new Book("Мяч", "Tom", 1900, 300, 457600, "Жесткий"));
        books.add(new Book("Зонтик ", "Tom", 1930, 5000, 156700, "Жесткий"));
        books.add(new Book("Кровать", "Nick", 1944, 600, 1350, "Мягкий"));
        books.add(new Book("Воздух", "Nick", 1940, 2560, 1600, "Мягкий"));
        books.add(new Book("Беларусь", "Sergo", 1937, 20459, 9080, "Жесткий"));
        books.add(new Book("Март", "Sergo", 1925, 2567, 16500, "Жесткий"));
        books.add(new Book("Баян>", "Ira", 1930, 6780, 1700, "Мягкий"));
        books.add(new Book("Радость", "Ira", 1925, 78979, 10, "Мягкий"));


        System.out.println("список книг данного автора:\n " + (bookAutor("Bob", books)));
        System.out.println("список книг по названию:\n " + bookName("Март", books));
        System.out.println("список книг по периоду:\n " + bookYear(1900, 1920, books));
    }

    public static List<Book> bookAutor(String autor, List<Book> books) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (autor.equals(book.getAutor())) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> bookName(String name, List<Book> books) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (name.equals(book.getName())) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> bookYear(int year_min, int year_max, List<Book> books) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (year_min <= book.getYear() && book.getYear() <= year_max) {
                result.add(book);
            }
        }
        return result;
    }
}
