import java.util.Arrays;
import java.io.*;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //  ЭКСПЕРИМЕНТИРУЕМ, из интернет:
//        Method 2: Without using pre-defined function
//        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
public class Draft_Task1_3_8_4 {
// Java Program to demonstrate merging
// two array without using pre-defined method
        public static void main(String[] args)
        {

            // first array
            int a[] = {30, 25, 40, 555, 666, 777};
            // second array
            int b[] = {0, 1, 2, 3, 4, 5,6, 7, 8, 9};

            // determining length of first array
            int a1 = a.length;
            // determining length of second array
            int b1 = b.length;

            // resultant array size
//            int c1 = a1 + b1;
            int c1 = 10;

            // Creating a new array
            int[] c = new int[c1];
//            int n = 0;

//            while (n < c1) {
                // Loop to store the elements of first
                // array into resultant array
                for (int i = 0; (i < a1 && i < c1); i = i + 1) {
                    // Storing the elements in
                    // the resultant array
                    c[i] = a[i];
//                    n++;
                }

                // Loop to concat the elements of second
                // array into resultant array
                for (int i = 0; (i < b1 && (i + a1) < c1); i = i + 1) {

                    // Storing the elements in the
                    // resultant array
                    c[a1 + i] = b[i];
//                    n++;
                }
//                c1 = c1-6 + 1;
//                n++;
//            }
            System.out.println(Arrays.toString(c));
        }
    }
//        Конец Примера _ КККККККККККККККК








////        Пример 3 ППППППППППППППППППППППППППППППППППП  //  из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//
//            // first array
//            int a[] = { 30, 25, 40 };
//            // second array
//            int b[] = { 45, 50, 55, 60, 65 };
//
//            // determining length of first array
//            int a1 = a.length;
//            // determining length of second array
//            int b1 = b.length;
//
//            // resultant array size
//            int c1 = a1 + b1;
////            int c1 = 6;
//
//            // Creating a new array
//            int[] c = new int[c1];
//
//            // Loop to store the elements of first
//            // array into resultant array
//            for (int i = 0; i < a1; i = i + 1) {
//                // Storing the elements in
//                // the resultant array
//                c[i] = a[i];
//            }
//
//            // Loop to concat the elements of second
//            // array into resultant array
//            for (int i = 0; i < b1; i = i + 1) {
//
//                // Storing the elements in the
//                // resultant array
//                c[a1 + i] = b[i];
//            }
//
//            // Loop to print the elements of
//            // resultant array after merging
//            for (int i = 0; i < c1; i = i + 1) {
//
//                // print the element
//                System.out.println(c[i]);
//            }
//            System.out.println(Arrays.toString(c));
//        }
//    }
////        Конец Примера 3 КККККККККККККККК








////        Пример 2 ППППППППППППППППППППППППППППППППППП  //  из интернет: Method 1: Using Predefined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class Draft_Task1_3_8_4 {
//    public static void main(String[] args)
//    {
//        // first array
//        int[] a = { 10, 20, 30, 40 };
//
//        // second array
//        int[] b = { 50, 60, 70, 80 };
//
//        // determines length of firstArray
//        int a1 = a.length;
//
//        // determines length of secondArray
//        int b1 = b.length;
//
//        // resultant array size
//        int c1 = a1 + b1;
//
//        // create the resultant array
//        int[] c = new int[c1];
//
//        // using the pre-defined function arraycopy
//        System.arraycopy(a, 0, c, 0, a1);
//        System.arraycopy(b, 0, c, a1, b1);
//
//        // prints the resultant array
//        System.out.println(Arrays.toString(c));
//    }
//}
////        Конец Примера 2 КККККККККККККККК








////        Пример 1 ППППППППППППППППППППППППППППППППППП  //  видео из интернет, отсюда: https://youtu.be/tAtBPxw2RRQ
//public class Draft_Task1_3_8_4 {
//    public static void main(String[] args) {
////  Пример взят отсюда: видео мин 06 15 https://youtu.be/tAtBPxw2RRQ   https://yandex.ru/video/preview/2055233165764642050
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] arr2), merge(int[] array1, int[]
//                   arr2,int[] arr3), merge(int[] array1, int[] arr2, int[] arr3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//        int[] arr1 = new int[10];
//        arr1[0] = 0;
//        arr1[1] = 1;
//        arr1[2] = 2;
//        arr1[3] = 3;
//        arr1[4] = 4;
//        arr1[5] = 5;
//        arr1[6] = 6;
//        arr1[7] = 7;
//        arr1[8] = 8;
//        arr1[9] = 9;
//
//        int[] arr2 = new int[10];
//        arr2[0] = 10;
//        arr2[1] = 20;
//        arr2[2] = 30;
//        arr2[3] = 40;
//        arr2[4] = 50;
//        arr2[5] = 60;
//        arr2[6] = 70;
//        arr2[7] = 80;
//        arr2[8] = 90;
//        arr2[9] = 100;
//
//        int[] arr3 = new int[10];
//        arr3[0] = 5;
//        arr3[1] = 15;
//        arr3[2] = 25;
//        arr3[3] = 35;
//        arr3[4] = 45;
//        arr3[5] = 55;
//        arr3[6] = 65;
//        arr3[7] = 75;
//        arr3[8] = 85;
//        arr3[9] = 95;
//
//        int[] arr4 = new int[20];
//
//        int[] srr = merge(arr1, arr2);
//        System.out.println(Arrays.toString(srr));
//    }
//
//    public static int[] merge(int arr1[], int arr2[]) {
//        int[] arr1_AND_arr2 = new int[arr1.length + arr2.length];
//        int n = arr1.length;
//        int m = arr2.length;
//        int i = 0, j = 0, k = 0;
//
//        while (i < n && j < m) {
//            if (arr1[i] <= arr2[j]) {
//                arr1_AND_arr2[k] = arr1[i];
//                i++;
//            } else {
//                arr1_AND_arr2[k] = arr2[j];
//                j++;
//            }
//            k++;
//        }
//        while (i < n) {
//            arr1_AND_arr2[k] = arr1[i];
//            i++;
//            k++;
//        }
//        while (j < m) {
//            arr1_AND_arr2[k] = arr2[j];
//            j++;
//            k++;
//        }
//
//        return arr1_AND_arr2;
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК








