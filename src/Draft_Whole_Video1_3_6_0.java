import java.util.Scanner;

public class Draft_Whole_Video1_3_6_0 {
    public static void main(String[] args) {
        //  Урок 6. Операторы Continue, break
        //  видео мин 03 01 - найти певый элемент массива, кот. больше 10-ти

        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array of 5 elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int x = 0;
        while (x < 100) {
            if (x == 50) {
                break;
            }
            x++;
            System.out.println(x);
        }
        System.out.println("end of program");


    }
}