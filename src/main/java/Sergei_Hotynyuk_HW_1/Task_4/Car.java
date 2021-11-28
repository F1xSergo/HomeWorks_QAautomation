package Sergei_Hotynyuk_HW_1.Task_4;

public class Car {
    public String brand;
    public int fuel;
    public int velocity;
    public int price;

    public Car(String brand, int fuel, int velocity, int price) {
        this.brand = brand;
        this.fuel = fuel;
        this.velocity = velocity;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nМашины: " +
                "brand='" + brand + '\'' +
                ", fuel=" + fuel +
                "L, velocity=" + velocity +
                "km/h, price=" + price +
                '$';
    }
}
