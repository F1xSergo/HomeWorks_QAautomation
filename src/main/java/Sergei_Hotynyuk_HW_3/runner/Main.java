package Sergei_Hotynyuk_HW_3.runner;


import Sergei_Hotynyuk_HW_3.triangle.Triangle;

public class Main {


    public static void main(String[] args) {

        Triangle tr = new Triangle(2.0, 2.0, 4.0);
        System.out.println(tr.checkTriangle());
        System.out.println(tr.getMessage());
        System.out.println(tr.detectTriangle());
        System.out.println(tr.getSquare());
    }

}
