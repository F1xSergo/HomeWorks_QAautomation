package Sergei_Hotynyuk_HW_1.Task_3;

public class Book {
    public static int number_id = 0;
    public int id;
    public String name;
    public String autor;
    public int year;
    public int page;
    public int price;
    public String pereplet;

    public Book(String name, String autor, int year, int page, int price, String pereplet) {
        this.id = ++number_id;
        this.name = name;
        this.autor = autor;
        this.year = year;
        this.page = page;
        this.price = price;
        this.pereplet = pereplet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPereplet() {
        return pereplet;
    }

    public void setPereplet(String pereplet) {
        this.pereplet = pereplet;
    }

    @Override
    public String toString() {
        return  "\nКнига с индентификационным номером " + id +
                ", под названием: '" + name + '\'' +
                ", автор: '" + autor + '\'' +
                ", год выпуска: " + year +
                ", количество страниц: " + page +
                ", цена: " + price +
                "$, переплет: '" + pereplet + '\'';
    }
}
