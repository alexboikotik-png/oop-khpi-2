package ua.khpi.oop.lab16;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[] inputArray = {1.0, 2.5, -3.0, 0.0, 10.12};
        double a = 2.0;
        double b = 5.5;

        System.out.println("Вхідний масив: " + Arrays.toString(inputArray));
        System.out.println("Параметри перетворення: a = " + a + ", b = " + b);

        NativeTransformer transformer = new NativeTransformer();

        try {
            System.out.println("Запуск мовою Java");
            double[] resultJava = transformer.transformJava(inputArray, a, b);
            System.out.println("Результат Java   " + Arrays.toString(resultJava));


            System.out.println("\nЗапуск мовою C++");
            double[] resultNative = transformer.transformNative(inputArray, a, b);
            System.out.println("Результат C++ " + Arrays.toString(resultNative));

            boolean isIdentical = Arrays.equals(resultJava, resultNative);
            if (isIdentical) {
                System.out.println("Успіх");
            } else {
                System.out.println("Помилка");
            }

        } catch (UnsatisfiedLinkError e) {
            System.err.println("Деталі помилки: " + e.getMessage());
        }
    }
}