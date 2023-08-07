import java.util.*;

//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_6_2 {
    public static void main(String[] args) {
        System.out.println("Задание: \n2.Пользователь вводит массив чисел. Найдите первое четное число\n\nРешение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите несколько целых чисел, разделяя числа клавишей Enter, " +
                "\nпо окончании ввода, введите две запятые, т.е. \",,\" и далее Enter: ");
        String input = "";
        List<String> arrStr = new ArrayList<>();
        int inputInt;

        while(!input.equals(",,")){
            input = scanner.nextLine();
            arrStr.add(input);
        }
        scanner.close();

        int index = arrStr.size() - 1;
        arrStr.remove(index);

        List<Integer> arrInt = new ArrayList<>();

        for(int i = 0; i<arrStr.size(); i++) {
            String value = arrStr.get(i);
            inputInt = Integer.parseInt(value);
            arrInt.add(inputInt);
        }
        System.out.println("Исходный массив чисел: " + arrInt);
        int firstEven = 1;
        int count = 0;
        for(int i = 0; i<arrInt.size(); i++) {
            if (arrInt.get(i) % 2 == 0) {
                firstEven = arrInt.get(i);
                count = i+1;
                break;
            }
        }
        System.out.println("Найжено первое четное число: " + firstEven + ", его порядковый номер в списке: " + count);

    }
}
//        Конец Примера _ КККККККККККККККК






////        Пример 2 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_2 {
//    public static void main(String[] args) {
//        System.out.println("Задание: \n2.Пользователь вводит массив чисел. Найдите первое четное число\n\nРешение: ");
//        Scanner scanner = new Scanner(System.in);
////        System.out.println("Введите несколько чисел (после ввода каждого числа - клавиша Enter): ");
////        List<String> names  = new ArrayList<>(Arrays.asList("Clementine", "Duran", "Mike"));
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите: ");
//        String input = "";
//        int inputInt;
//
//
//        do{
//            input = sc.nextLine();
////            inputInt = Integer.parseInt(input);
//            System.out.println(input);
//////        } while(!input.equals("ex"));
//        } while(!input.equals(",,"));
//        sc.close();
//
//
//
//
//
////        Scanner sc = new Scanner(System.in);
////        System.out.println("Введите: ");
////        List<Integer> arr = new ArrayList<>();
////        String input = "";
////
////
////        String myString = "1234";
////        int foo = Integer.parseInt(myString);
////        System.out.println(foo);
////        System.out.println(foo * 2);
////
////        do{
////            input = sc.nextLine();
////            int inputInt = Integer.parseInt(input);
////            arr.add(inputInt);
//////            System.out.println(input);
////        } while(!input.equals("#"));
////        sc.close();
////        System.out.println(arr);
//////        System.out.println(arr/*.toString()*/);
//    }
//}
//
////        Конец Примера 1 КККККККККККККККК






