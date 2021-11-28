package Sergei_Hotynyuk_HW_1.Task_4;

//Необходимо использовать возможности ООП классы, полиморфизм, наследование, инкапсуляция.
//Данные для создания объектов можно хранить в файле.
//Создать таксопарк. Определить иерархию легковых автомобилей.
// Подсчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива.
// Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости. (4 балл)

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        File f = new File("F://JavaProject//AutomationJava_QA//Home works//src//main//java//Sergei_Hotynyuk_HW_1//Task_4//Cars.txt");

        List<Car> cars_pool = new ArrayList<>(Objects.requireNonNull(parseCarToObjList(f)));

// стоимость всего автопарка
        int poolPrice = 0;
        for (Car car : cars_pool) {
            poolPrice += car.getPrice();
        }
        System.out.println("Price all poolCars \n -= " + poolPrice + "$ =-\n");

// Провести сортировку автомобилей парка по расходу топлива.
        cars_pool.sort(Comparator.comparingInt(Car::getFuel));
//        System.out.println("Sort  of cars by fuelConsumption: \n" + cars_pool); // показывает полный список таксопарка уже отсортированным
        System.out.println("Sort  of cars by fuelConsumption: \n");
        for (Car car : cars_pool) {
            System.out.printf("FuelConsumption by %s: %sL \n", car.getBrand(), car.getFuel());
        }

// найти машину, соответствующую диапазону параметров скорости
        System.out.println("\nНайдите автомобили отвечающие Вашим критериям скорости");

        System.err.println("Введите минимальноу значение скорости:");
        int minVelocity = getVelocity();

        System.err.println("Введите максимальное значение скорости");
        int maxVelocity = getVelocity();

        while (maxVelocity < minVelocity) {
            System.out.println("Указанное Вами значение меньше минимальной скорости, \n" +
                    "укажите другое");
            maxVelocity = getVelocity();
        }

        for (Car car : cars_pool) {
            if (car.getVelocity() >= minVelocity && car.getVelocity() <= maxVelocity) {
                System.out.printf("Good speed by %s: %s", car, car.getVelocity());
                System.out.println();
            }
        }
    }


    public static List<Car> parseCarToObjList(File file) {
        List<Car> carList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] cars = line.split(";");
                if (Integer.parseInt(cars[1]) < 0 || Integer.parseInt(cars[2]) < 0 || Integer.parseInt(cars[3]) < 0)//проверка на отрицительные числа
                    throw new IllegalArgumentException();
                Car car = new Car(cars[0], Integer.parseInt(cars[1]), Integer.parseInt(cars[2]), Integer.parseInt(cars[3])) {
                };
                carList.add(car);
            }
            return carList;
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный входной файл");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return null;
    }

    private static int getVelocity() throws IOException {
        int currentVelocity;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                currentVelocity = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Неверный ввод, попробуйте заново");
            }
        }
        return currentVelocity;
    }
}
