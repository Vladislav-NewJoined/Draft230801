import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

//        Пример _ ППППППППППППППППППППППППППППППППППП  СДЕЛАН ОКОНЧАТЕЛЬНО, ОТПРАВЛЕН В ЭТОМ ВИДЕ !!!!!
//  Преобразование строки в массив слов: https://overcoder.net/q/172469/%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B8-%D0%BF%D1%80%D0%B5%D0%B4%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D1%81%D0%BB%D0%BE%D0%B2-%D0%B2-java
public class Draft_Task1_3_7_1 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                Задание:\s
                1. Реализуйте метод, который находит из трех чисел то, которое делится на 2
                   остальных; или возвращает -1, если такого нет

                Решение:\s""");

        System.out.println("Вводим три исходных целых числа:");
        int num1 = 3;
        int num2 = 15;
        int num3 = 5;
        System.out.println("Первое число: " + num1 + ", второе число: " + num2 + ", третье число: " + num3);
        System.out.println();  //  перенос строки
        System.out.println("Реализуем метод getResult: ");
        getResult(num1, num2, num3);
    }

    private static void getResult(int num1, int num2, int num3) {
        String negativeResult = "-1";
        String result;

        if (num1 % num2 == 0 && num1 % num3 == 0) {
            result = "Искомое число - первое число, " + num1;
            System.out.println("Результат: " + result);
            System.exit(0);

        } else if (num2 % num1 == 0 && num2 % num3 == 0) {
            result = "Искомое число - второе число, " + num2;
            System.out.println("Результат: " + result);
            System.exit(0);
        } else if (num3 % num1 == 0 && num3 % num2 == 0) {
            result = "Искомое число - третье число, " + num3;
            System.out.println("Результат: " + result);
            System.exit(0);
        } else {
            result = negativeResult;
            System.out.println("Результат: " + result);
        }
    }
}
//        Конец Примера _ КККККККККККККККК







