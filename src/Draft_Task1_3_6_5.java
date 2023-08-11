import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


//        Пример _ ППППППППППППППППППППППППППППППППППП
public class Draft_Task1_3_6_5 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("""
                Задание:\s
                5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 
                (пример такого числа - 875)

                Решение:\s""");

        int n = 0;
        int count = 0;
        while (count != 20) {
            n = n+1;
            System.out.print("Добавлено число: " + n + ", ");
            System.out.println("Сумма цифр равна: " + sumDigits(n));
            count = sumDigits(n);
        }
        System.out.println("Это первое найденное число с заданными условиями. Программа закончена.");
    }
    public static int sumDigits (int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
//        Конец Примера _ КККККККККККККККК









////        Пример 1 ППППППППППППППППППППППППППППППППППП
//public class Draft_Task1_3_6_5 {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("""
//                Задание:\s
//                5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20
//                (пример такого числа - 875)
//
//                Решение:\s""");
//
//        Scanner input = new Scanner (System.in);
//        System.out.print("Введите число: ");
//        int n = input.nextInt();
//        System.out.println("Сумма цифр равна: " + sumDigits(n));
//    }
//
//    public static int sumDigits (int n) {
//        int sum = 0;
//        while (n != 0) {
//            sum += n % 10;
//            n /= 10;
//        }
//        return sum;
//    }
//
//}
////        Конец Примера 1 КККККККККККККККК









