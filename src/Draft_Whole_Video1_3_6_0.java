import java.util.Scanner;

public class Draft_Whole_Video1_3_6_0 {
    public static void main(String[] args) {
        //  Урок 6. Операторы Continue, break
        //  видео мин 03 01 - найти певый элемент массива, кот. больше 10-ти
        //  видео мин 04 30 - вывести только первое слово
        //  видео мин 06 55 - в случае с вложенными циклами
        //  видео мин 07 16 - оператор continue
        //  видео мин 09 40 - вывести только нечетные числа
        //  видео мин 11 04 - вывести все заглавные символы со StringBuilder

        // вывести, если больше 10
//        int[] arr = new int[5];
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter array of 5 elements: ");
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//
//        System.out.println("result:");
//        for (int i=0; i<arr.length; i++) {
//            if (arr[i] > 10) {
//                System.out.println(arr[i]);
//                break;
//            }
//        }

        // вывести первое слово
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter line: ");
//
//        String line = scanner.nextLine();
//        System.out.println("result:");
//        for (int i = 0; i < line.length(); i++) {
//            if (line.charAt(i) == ' ') {
//                break;
//            }
//            System.out.print(line.charAt(i));
//        }

//        int x = 0;
//        while (x < 100) {
//            if (x == 50) {
//                break;
//            }
//            x++;
//            System.out.println(x);
//        }
//        System.out.println(); //  перенос строки
//        System.out.println("end of program");


//        //  Вывести нечетные
//        int x = 0; while (x<100) {
//            x++;
//            if (x % 2 == 0) {
//                continue;
//            }
//            System.out.println(x);
//        }


        //  видео мин 11 04 - вывести все заглавные символы со StringBuilder
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder builder = new StringBuilder(line);
        int count = 0;
        for (int i=0; i<builder.length(); i++) {
            char ch = builder.charAt(i);
            if (Character.isLowerCase(ch)) {
                continue;
            }
            char small = Character.toLowerCase(ch);
            builder.deleteCharAt(i);
            builder.insert(i, small);
            count++;
        }
        System.out.println("There is " + count + " not-lowercase symbols");
        System.out.println(builder.toString());
    }
}