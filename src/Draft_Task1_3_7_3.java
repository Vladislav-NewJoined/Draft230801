import java.io.IOException;
import java.util.*;

//        Пример _ ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
public class Draft_Task1_3_7_3 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
            Задание:\s
            3. Возьмите любую программу, которую вы писали до этого.. какая сердцу
               ближе. Отрефакторите ее (улучшите читабельность кода) - путем разбиения
               крупных частей на методы поменьше. Стало лучше? (надеюсь, да)\s

            Решение:\s""");

        System.out.println("Ищем максимальное и минимальное значения в динамическом массиве целых чисел ArrayList.");
// initializing the ArrayList elements
        ArrayList<Integer> arr = getArrayList();
        System.out.println("\nРеализуем метод getArrayList: \nИсходный массив ArrayList: " + arr);

// define the length of the ArrayList in variable n
        int n = getSizeOfArrayList(arr);

// loop to find maximum from ArrayList
        int max = getMaxValue(arr, n);

// loop to find minimum from ArrayList
        int min = getMinValue(arr, n);

// The result will be printed
        System.out.println("\nРеализуем метод getMaxValue: \nМаксимальное значение массива: " + max);
        System.out.println("\nРеализуем метод getMinValue: \nМинимальное значение массива: " + min);
    }

    private static int getMinValue(ArrayList<Integer> arr, int n) {
        int min = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    private static ArrayList<Integer> getArrayList() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(-8);
        arr.add(32);
        arr.add(21);
        arr.add(-3);

        return arr;
    }

    private static int getSizeOfArrayList(ArrayList<Integer> arr) {
        int n = arr.size();
        return n;
    }

    private static int getMaxValue(ArrayList<Integer> arr, int n) {
        int max = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }
}
//        Конец Примера _ КККККККККККККККК





////        Пример 1 ППППППППППППППППППППППППППППППППППП  РАБОТАЕТ, НО БЕЗ ВЫНЕСЕНИЯ В ОТДЕЛЬНЫЕ МЕТОДЫ
//public class Draft_Task1_3_7_3 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//            Задание:\s
//            3. Возьмите любую программу, которую вы писали до этого.. какая сердцу
//               ближе. Отрефакторите ее (улучшите читабельность кода) - путем разбиения
//               крупных частей на методы поменьше. Стало лучше? (надеюсь, да)\s
//
//            Решение:\s""");
//
//        System.out.println("Ищем максимальное и минимальное значения в динамическом массиве ArrayList.");
//// initializing the ArrayList elements
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(10);
//        arr.add(20);
//        arr.add(-8);
//        arr.add(32);
//        arr.add(21);
//        arr.add(-3);
//
//        int max = arr.get(0);
//        int min = arr.get(0);
//
//// store the length of the ArrayList in variable n
//        int n = arr.size();
//
//// loop to find maximum from ArrayList
//        for (int i = 1; i < n; i++) {
//            if (arr.get(i) > max) {
//                max = arr.get(i);
//            }
//        }
//
//// loop to find minimum from ArrayList
//        for (int i = 1; i < n; i++) {
//            if (arr.get(i) < min) {
//                min = arr.get(i);
//            }
//        }
//
//// The result will be printed
//        System.out.println("Максимальное значение массива: " + max);
//        System.out.println("Минимальное значение массива: " + min);
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК





