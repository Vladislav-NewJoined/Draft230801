import java.util.Arrays;

//   ПРИВЕТ. ТЕСТИРУЕМ!
//        Пример _ ППППППППППППППППППППППППППППППППППП  //  из интернет: 
public class Draft_Task1_3_8_4 {
    public static void main(String[] args) {
//  Пример взят отсюда: видео мин 06 15 https://youtu.be/tAtBPxw2RRQ   https://yandex.ru/video/preview/2055233165764642050
        System.out.println("""
                Задание:\s
                4. Реализуйте методы merge(int[] array1, int[] arr2), merge(int[] array1, int[]
                   arr2,int[] arr3), merge(int[] array1, int[] arr2, int[] arr3, int[] array4) -
                   который возвращает новый массив, в котором он соединяет все предыдущие
                   (было 3 массива по 10 элементов, станет массив с 20 элементами)

                Решение:\s""");

        int[] arr1 = new int[10];
        arr1[0] = 0;
        arr1[1] = 1;
        arr1[2] = 2;
        arr1[3] = 3;
        arr1[4] = 4;
        arr1[5] = 5;
        arr1[6] = 6;
        arr1[7] = 7;
        arr1[8] = 8;
        arr1[9] = 9;

        int[] arr2 = new int[10];
        arr2[0] = 10;
        arr2[1] = 20;
        arr2[2] = 30;
        arr2[3] = 40;
        arr2[4] = 50;
        arr2[5] = 60;
        arr2[6] = 70;
        arr2[7] = 80;
        arr2[8] = 90;
        arr2[9] = 100;

        int[] arr3 = new int[10];
        arr3[0] = 5;
        arr3[1] = 15;
        arr3[2] = 25;
        arr3[3] = 35;
        arr3[4] = 45;
        arr3[5] = 55;
        arr3[6] = 65;
        arr3[7] = 75;
        arr3[8] = 85;
        arr3[9] = 95;

        int[] array4 = new int[20];

        int[] srr = merge(arr1, arr2);
        System.out.println(Arrays.toString(srr));
    }

    public static int[] merge(int arr1[], int arr2[]) {
        int[] arr1_and_arr2 = new int[arr1.length + arr2.length];
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr1_and_arr2[k] = arr1[i];
                i++;
            } else {
                arr1_and_arr2[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            arr1_and_arr2[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) {
            arr1_and_arr2[k] = arr2[j];
            j++;
            k++;
        }

        return arr1_and_arr2;

    }
}
//        Конец Примера _ КККККККККККККККК








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
//        int[] array4 = new int[20];
//
//        int[] srr = merge(arr1, arr2);
//        System.out.println(Arrays.toString(srr));
//    }
//
//    public static int[] merge(int arr1[], int arr2[]) {
//        int[] arr1_and_arr2 = new int[arr1.length + arr2.length];
//        int n = arr1.length;
//        int m = arr2.length;
//        int i = 0, j = 0, k = 0;
//
//        while (i < n && j < m) {
//            if (arr1[i] <= arr2[j]) {
//                arr1_and_arr2[k] = arr1[i];
//                i++;
//            } else {
//                arr1_and_arr2[k] = arr2[j];
//                j++;
//            }
//            k++;
//        }
//        while (i < n) {
//            arr1_and_arr2[k] = arr1[i];
//            i++;
//            k++;
//        }
//        while (j < m) {
//            arr1_and_arr2[k] = arr2[j];
//            j++;
//            k++;
//        }
//
//        return arr1_and_arr2;
//
//    }
//}
////        Конец Примера 1 КККККККККККККККК








