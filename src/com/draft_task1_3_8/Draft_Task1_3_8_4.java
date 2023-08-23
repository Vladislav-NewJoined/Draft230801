package com.draft_task1_3_8;

import java.util.Arrays;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //  надо второй метод делать
//        Method 2: Without using pre-defined function
//        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
public class Draft_Task1_3_8_4 {
// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
        public static void main(String[] args)
        {
        System.out.println("""
            Задание:\s
            4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
               array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
               который возвращает новый массив, в котором он соединяет все предыдущие
               (было 3 массива по 10 элементов, станет массив с 20 элементами)
    
            Решение:\s""");

        MergeArrays mergeArrays = new MergeArrays();

        System.out.println("Должен сделать оговорку, что мне не совсем понятна суть задания. Мною выведен результат в соответствии с тем, как я понял суть задания. \n");

            // первый массив
        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
            // второй массив
        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            // третий массив
        int array3[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1000};

        System.out.println("Исходный массив array1, 10 элементов: " + Arrays.toString(array1));
        System.out.println("Исходный массив array2, 10 элементов: " + Arrays.toString(array2));
        System.out.println("Исходный массив array3, 10 элементов: " + Arrays.toString(array3));
        System.out.println();  //  перенос строки

        mergeArrays.pred_array4 = merge(mergeArrays, array1, array2);
        System.out.println("Результат слияния array1 и array2, массив pred_array4, 10 элементов: " + Arrays.toString(mergeArrays.pred_array4));

        mergeArrays.array4 = merge(mergeArrays, array1, array2, array3);
        System.out.println("Результат слияния array1, array2 и array3, массив array4, 20 элементов: " + Arrays.toString(mergeArrays.array4));


        }

    static int[] merge(MergeArrays perem, int[] array1, int[] array2) {
        // определяем длину первого массива
        int a1 = array1.length;
        // определяем длину второго массива
        int b1 = array2.length;
        // задаем длину результирующего массива
        int c1 = 10;

        // создаем результирующий массив
        int[] c = new int[c1];
        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
        int quantFrom2 = 5;  //  счетчик, сколько элементов берём из второго массива

        // цикл для сохранения элементов первого массива в результирующий массив
        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
            // Storing the elements in
            // the resultant array
            if (i >= a1 || i >= c1) {
                break; // завершить цикл, если вышли за пределы массива
            }
            c[i] = array1[i];
        }
//        System.out.println(Arrays.toString(c));

        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
            // цикл для сохранения элементов второго массива в результирующий массив
            if (i >= b1 || i >= c1-quantFrom1) {
                break; // завершить цикл, если вышли за пределы массива
            }
            c[i+quantFrom1] = array2[i];
        }
//        System.out.println(Arrays.toString(c));

            int targetIndex = 0;
            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
            if( c[sourceIndex] != 0 )
                c[targetIndex++] = c[sourceIndex];
        perem.pred_array4 = new int[targetIndex];
            System.arraycopy( c, 0, perem.pred_array4, 0, targetIndex );
//            System.out.println(Arrays.toString(finishArray1));

        return perem.pred_array4;
    }
    static int[] merge(MergeArrays perem, int[] array1, int[] array2, int[] array3) {
        // определяем длину первого массива
        int a1 = array1.length;
        // определяем длину второго массива
        int b1 = array2.length;
        // определяем длину третьего массива
        int c1 = array3.length;
        // задаем длину результирующего массива
        int d1 = 20;

        // создаем результирующий массив
        int[] d = new int[d1];
        int quantFrom1 = 6;  //  счетчик, сколько элементов берём из первого массива
        int quantFrom2 = 6;  //  счетчик, сколько элементов берём из второго массива
        int quantFrom3 = 8;  //  счетчик, сколько элементов берём из третьего массива

        // цикл для сохранения элементов первого массива в результирующий массив
        for (int i = 0; (i < quantFrom1 && i < d1); i++) {
            // Storing the elements in
            // the resultant array
            if (i >= a1 || i >= d1) {
                break; // завершить цикл, если вышли за пределы массива
            }
            d[i] = array1[i];
        }
//        System.out.println(Arrays.toString(c));

        for (int i = 0; (i < quantFrom2 && i < d1); i++) {

            // цикл для сохранения элементов второго массива в результирующий массив
            if (i >= b1 || i >= d1-quantFrom1) {
                break; // завершить цикл, если вышли за пределы массива
            }
            d[i+quantFrom1] = array2[i];
        }

        for (int i = 0; (i < quantFrom3 && i < d1); i++) {

            // цикл для сохранения элементов третьего массива в результирующий массив
            if (i >= c1 || i >= d1-quantFrom1-quantFrom2) {
                break; // завершить цикл, если вышли за пределы массива
            }
            d[i+quantFrom1+quantFrom2] = array3[i];
        }
//        System.out.println(Arrays.toString(d));

            int targetIndex = 0;
            for( int sourceIndex = 0;  sourceIndex < d.length;  sourceIndex++ )
            if( d[sourceIndex] != 0 )
                d[targetIndex++] = d[sourceIndex];
        perem.array4 = new int[targetIndex];
            System.arraycopy( d, 0, perem.array4, 0, targetIndex );
//            System.out.println(Arrays.toString(array4));

        return perem.array4;
    }
}

class MergeArrays {
    int[] pred_array4;
    int[] array4;
}
//        Конец Примера _ КККККККККККККККК








////        Пример 16 ППППППППППППППППППППППППППППППППППП  //  ДО КОНЦА, сделан первый метод
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//        com.draft_task1_3_8.MergeArrays mergeArrays = new com.draft_task1_3_8.MergeArrays();
//            // первый массив
//        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
//            // второй массив
//        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//            // третий массив
//        int array3[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1000};
//
//        mergeArrays.finishArray1 = merge(mergeArrays, array1, array2);
//        System.out.println(Arrays.toString(mergeArrays.finishArray1));
//        }
//
//    static int[] merge(com.draft_task1_3_8.MergeArrays perem, int[] array1, int[] array2) {
//        // определяем длину первого массива
//        int a1 = array1.length;
//        // определяем длину второго массива
//        int b1 = array2.length;
//        // задаем длину результирующего массива
//        int c1 = 10;
//
//        // создаем результирующий массив
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 2;  //  счетчик, сколько элементов берём из второго массива
//
//        // цикл для сохранения элементов первого массива в результирующий массив
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i] = array1[i];
//
//        }
////        System.out.println(Arrays.toString(c));
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // цикл для сохранения элементов второго массива в результирующий массив
//            if (i >= b1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
//            if( c[sourceIndex] != 0 )
//                c[targetIndex++] = c[sourceIndex];
//        perem.finishArray1 = new int[targetIndex];
//            System.arraycopy( c, 0, perem.finishArray1, 0, targetIndex );
////            System.out.println(Arrays.toString(finishArray1));
//
//        return perem.finishArray1;
//    }
//}
//
//class com.draft_task1_3_8.MergeArrays {
//    int[] finishArray1;
//}
////        Конец Примера 16 КККККККККККККККК








////        Пример 15 ППППППППППППППППППППППППППППППППППП  //  Сделан первый метод, НО НЕ ДО КОНЦА
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//        com.draft_task1_3_8.MergeArrays mergeArrays = new com.draft_task1_3_8.MergeArrays();
//            // первый массив
//        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
//            // второй массив
//        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//            // третий массив
//        int array3[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1000};
//
////        merge(mergeArrays, array1, array2);
//        mergeArrays.finishArray1 = Arrays.toString(merge(array1, array2));
//        System.out.println(mergeArrays.finishArray1);
////        merge(mergeArrays, mergeArrays.finishArray1, array3);
//        }
//
//    static int[] merge(int[] array1, int[] array2) {
//        // определяем длину первого массива
//        int a1 = array1.length;
//        // определяем длину второго массива
//        int b1 = array2.length;
//        // задаем длину результирующего массива
//        int c1 = 10;
//
//        // создаем результирующий массив
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 2;  //  счетчик, сколько элементов берём из второго массива
//
//        // цикл для сохранения элементов первого массива в результирующий массив
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i] = array1[i];
//
//        }
////        System.out.println(Arrays.toString(c));
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // цикл для сохранения элементов второго массива в результирующий массив
//            if (i >= b1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
//            if( c[sourceIndex] != 0 )
//                c[targetIndex++] = c[sourceIndex];
//        int[] finishArray1 = new int[targetIndex];
//            System.arraycopy( c, 0, finishArray1, 0, targetIndex );
////            System.out.println(Arrays.toString(finishArray1));
//
//        return finishArray1;
//    }
//}
//
//class com.draft_task1_3_8.MergeArrays {
//    String finishArray1;
//}
////        Конец Примера 15 КККККККККККККККК








////        Пример 14 ППППППППППППППППППППППППППППППППППП  //  Предварительно: встроил первый метод
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//        com.draft_task1_3_8.MergeArrays mergeArrays = new com.draft_task1_3_8.MergeArrays();
//            // первый массив
//        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
//            // второй массив
//        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//            // третий массив
//        int array3[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1000};
//
//        merge(mergeArrays, array1, array2);
////        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    static /*int[]*/ int[] merge(com.draft_task1_3_8.MergeArrays mergeArrays, int[] array1, int[] array2) {
//        // определяем длину первого массива
//        int a1 = array1.length;
//        // определяем длину второго массива
//        int b1 = array2.length;
//        // задаем длину результирующего массива
//        int c1 = 10;
//
//        // создаем результирующий массив
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 2;  //  счетчик, сколько элементов берём из второго массива
//
//        // цикл для сохранения элементов первого массива в результирующий массив
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i] = array1[i];
//
//        }
////        System.out.println(Arrays.toString(c));
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // цикл для сохранения элементов второго массива в результирующий массив
//            if (i >= b1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
//            if( c[sourceIndex] != 0 )
//                c[targetIndex++] = c[sourceIndex];
//        int[] finishArray1 = new int[targetIndex];
//            System.arraycopy( c, 0, finishArray1, 0, targetIndex );
//            System.out.println(Arrays.toString(finishArray1));
//
//        return mergeArrays.finishArray1;
//    }
//}
//
//class com.draft_task1_3_8.MergeArrays {
//    int[] finishArray1;
//}
////        Конец Примера 14 КККККККККККККККК








////        Пример 13 ППППППППППППППППППППППППППППППППППП  //  Работает, обрезано, переведено. ДОБАВЛЕН ТРЕТИЙ МАССИВ
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // первый массив
//        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
//            // второй массив
//        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//            // третий массив
//        int array3[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 1000};
//
//        merge(array1, array2);
////        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int array1[], int array2[]) {
//        // определяем длину первого массива
//        int a1 = array1.length;
//        // определяем длину второго массива
//        int b1 = array2.length;
//        // задаем длину результирующего массива
//        int c1 = 10;
//
//        // создаем результирующий массив
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 5;  //  счетчик, сколько элементов берём из второго массива
//
//        // цикл для сохранения элементов первого массива в результирующий массив
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i] = array1[i];
//
//        }
////        System.out.println(Arrays.toString(c));
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // цикл для сохранения элементов второго массива в результирующий массив
//            if (i >= b1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
//            if( c[sourceIndex] != 0 )
//                c[targetIndex++] = c[sourceIndex];
//            int[] finishArray1 = new int[targetIndex];
//            System.arraycopy( c, 0, finishArray1, 0, targetIndex );
//            System.out.println(Arrays.toString(finishArray1));
//
//        return finishArray1;
//    }
//}
////        Конец Примера 13 КККККККККККККККК








////        Пример 12 ППППППППППППППППППППППППППППППППППП  //  Работает, обрезано, переведено
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java-программа для демонстрации слияния двух массивов без использования предопределенного метода
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // первый массив
//        int array1[] = {11, 15, 20, 25, 30, 35, 40, 45, 50, 55};
//            // второй массив
//        int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//            // результирующий массив
//
//        merge(array1, array2);
////        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int array1[], int array2[]) {
//        // определяем длину первого массива
//        int a1 = array1.length;
//        // определяем длину второго массива
//        int b1 = array2.length;
//
//        // задаем длину результирующего массива
//        int c1 = 10;
//
//        // создаем результирующий массив
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 5;  //  счетчик, сколько элементов берём из второго массива
//
//        // цикл для сохранения элементов первого массива в результирующий массив
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i] = array1[i];
//
//        }
////        System.out.println(Arrays.toString(c));
//
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // цикл для сохранения элементов второго массива в результирующий массив
//            if (i >= b1) {
//                break; // завершить цикл, если вышли за пределы массива
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < c.length;  sourceIndex++ )
//            if( c[sourceIndex] != 0 )
//                c[targetIndex++] = c[sourceIndex];
//            int[] finishArray1 = new int[targetIndex];
//            System.arraycopy( c, 0, finishArray1, 0, targetIndex );
//            System.out.println(Arrays.toString(finishArray1));
//
//        return finishArray1;
//    }
//}
////        Конец Примера 12 КККККККККККККККК








////        Пример 11 ППППППППППППППППППППППППППППППППППП  //  Как обрезать
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//        public static void main(String[] args) {
//
//            int array[] = {10, 15, 20, 25, 30, 0, 0, 0, 0};
//            int targetIndex = 0;
//            for( int sourceIndex = 0;  sourceIndex < array.length;  sourceIndex++ )
//            if( array[sourceIndex] != 0 )
//                array[targetIndex++] = array[sourceIndex];
//            int[] finishArray = new int[targetIndex];
//            System.arraycopy( array, 0, finishArray, 0, targetIndex );
//            System.out.println(Arrays.toString(finishArray));
//    }
//}
////        Конец Примера 11 КККККККККККККККК








////        Пример 10 ППППППППППППППППППППППППППППППППППП  //  Работает, проверить и обрезать
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
//            // second array
//        int array2[] = {1, 2, 3, 4/*, 5, 6, 7, 8, 9, 111*/};
//            // resultant array
////        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
////        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int array1[], int array2[]) {
//        // determining length of first array
//        int a1 = array1.length;
//        // determining length of second array
//        int b1 = array2.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int quantFrom1 = 3;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 7;  //  счетчик, сколько элементов берём из второго массива
//
//        // Loop to store the elements of first
//        // array into resultant array
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= a1) {
//                break; // завершить цикл, если i больше длины массива array1
//            }
//
//            c[i] = array1[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//
//        for (int i = 0; (i < quantFrom2 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            if (i >= b1) {
//                break; // завершить цикл, если i больше длины массива array1
//            }
//
//            c[i+quantFrom1] = array2[i];
//
//        }
//        System.out.println(Arrays.toString(c));
//
//        return c;
//    }
//}
////        Конец Примера 10 КККККККККККККККК








////        Пример 9 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ_9 _ЭКСПЕРИМЕНТ УДАЧЕН, ПОДГОНЯЕМ ПОД НАШЕ ЗАДАНИЕ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
//            // second array
//        int array2[] = {1, 2, 3, 4/*, 5, 6, 7, 8, 9, 111*/};
//            // resultant array
//        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
//        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int array1[], int array2[]) {
//        // determining length of first array
//        int a1 = array1.length;
//        // determining length of second array
//        int b1 = array2.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int quantFrom1 = 5;  //  счетчик, сколько элементов берём из первого массива
//        int quantFrom2 = 7;  //  счетчик, сколько элементов берём из второго массива
//
//        // Loop to store the elements of first
//        // array into resultant array
//        for (int i = 0; (i < quantFrom1 && i < c1); i++) {
//            // Storing the elements in
//            // the resultant array
//            c[i] = array1[i];
//
//            if (i > a1) {
//                break; // завершить цикл, если i больше длины массива array1
//            }
//
//
//        }
//
//
//        for (int i = quantFrom1; (i < quantFrom2+quantFrom1 && i < c1+quantFrom1); i++) {
//            c[i] = array2[i-quantFrom1];
//
//            int countArray2 = i-quantFrom1+1;
//            if (countArray2 >= b1) {
//                break; // завершить цикл, если вышли за пределы массива array2
//            }
//
//
//        }
//
////        for (int i = 5; (i < quantFrom2+5 && i < c1+5); i = i + 1) {
////            // Storing the elements in
////            // the resultant array
////            c[i] = array2[i-5];
////        }
//
//        // Loop to concat the elements of second
//        // array into resultant array
////        for (int i = 0; i < b1 && i < c1-quantFrom1 /*(i < b1 && (i + a1) < c1)*/; i = i + 1) {
//////        for (int i = 0; (i < b1 && (i + quantFrom1) < c1); i = i + 1) {
////
////            if (i == 4) {
////                c1 = quantFrom1 + i;
////                break; // завершить цикл, если i = 4
////            }
////
////            // Storing the elements in the
////            // resultant array
////            c[i+quantFrom1] = array2[i];
////        }
//        return c;
//    }
//}
////        Конец Примера 9 КККККККККККККККК








////        Пример 8 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ8 _ЭКСПЕРИМЕНТ УДАЧЕН, ПОДГОНЯЕМ ПОД НАШЕ ЗАДАНИЕ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
//            // second array
//        int array2[] = {111, 1, 2, 3/*, 4, 5, 6, 7, 8, 9*/};
//            // resultant array
//        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
//        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int array1[], int array2[]) {
//        // determining length of first array
//        int a1 = array1.length;
//        // determining length of second array
//        int b1 = array2.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int count1 = 3;  //  счетчик, сколько элементов берём из первого массива
////        int count2 = c1 - count1;  //  счетчик, сколько элементов берём из второго массива
//
//        // Loop to store the elements of first
//        // array into resultant array
////        for (int i = 0; (i < a1 && i < c1); i = i + 1) {
//        for (int i = 0; (i < count1 && i < c1); i = i + 1) {
//            // Storing the elements in
//            // the resultant array
//            c[i] = array1[i];
//        }
//
//        // Loop to concat the elements of second
//        // array into resultant array
//        for (int i = 0; i < b1 && i < c1-count1 /*(i < b1 && (i + a1) < c1)*/; i = i + 1) {
////        for (int i = 0; (i < b1 && (i + count1) < c1); i = i + 1) {
//
//
//            if (i == 4) {
//                c1 = count1 + i;
//                break; // завершить цикл, если i = 4
//            }
//
//
//            // Storing the elements in the
//            // resultant array
//            c[i+count1] = array2[i];
////            c1 = count1 + i;
//
//
//        }
//        return c;
//    }
//}
////        Конец Примера 8 КККККККККККККККК








////        Пример 7 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ7 _ЭКСПЕРИМЕНТ УДАЧЕН, ПОДГОНЯЕМ ПОД НАШЕ ЗАДАНИЕ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {30, 25, 40, 555, 666, 777, 888, 999, 888, 999};
//            // second array
//        int array2[] = {1111, 1, 2, 3/*, 4, 5, 6, 7, 8, 9*/};
//            // resultant array
//        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
//        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int a[], int b[]) {
//        // determining length of first array
//        int a1 = a.length;
//        // determining length of second array
//        int b1 = b.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int count1 = 3;  //  счетчик, сколько элементов берём из первого массива
//
//        // Loop to store the elements of first
//        // array into resultant array
////        for (int i = 0; (i < a1 && i < c1); i = i + 1) {
//        for (int i = 0; (i < count1 && i < c1); i = i + 1) {
//            // Storing the elements in
//            // the resultant array
//            c[i] = a[i];
//        }
//
//        // Loop to concat the elements of second
//        // array into resultant array
//        for (int i = 0; i < b1 && (i + count1) < c1 /*(i < b1 && (i + a1) < c1)*/; i = i + 1) {
////        for (int i = 0; (i < b1 && (i + count1) < c1); i = i + 1) {
//
//            // Storing the elements in the
//            // resultant array
//            c[count1 + i] = b[i/*-count1*/];
//        }
//        return c;
//    }
//}
////        Конец Примера 7 КККККККККККККККК








////        Пример 6 ППППППППППППППППППППППППППППППППППП  //  ПРОДОЛЖЕНИЕ _ЭКСПЕРИМЕНТ УДАЧЕН, ПОДГОНЯЕМ ПОД НАШЕ ЗАДАНИЕ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {30, 25, 40, 555, 666, 777, 888, 999, 888, 999};
//            // second array
//        int array2[] = {1111, 1, 2, 3/*, 4, 5, 6, 7, 8, 9*/};
//            // resultant array
//        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
//        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int a[], int b[]) {
//        // determining length of first array
//        int a1 = a.length;
//        // determining length of second array
//        int b1 = b.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int count1 = 3;  //  счетчик, сколько элементов берём из первого массива
//
//        // Loop to store the elements of first
//        // array into resultant array
////        for (int i = 0; (i < a1 && i < c1); i = i + 1) {
//        for (int i = 0; (i < count1 && i < c1); i = i + 1) {
//            // Storing the elements in
//            // the resultant array
//            c[i] = a[i];
//        }
//
//        // Loop to concat the elements of second
//        // array into resultant array
//        for (int i = 0; i < b1 /*(i < b1 && (i + a1) < c1)*/; i = i + 1) {
////        for (int i = 0; (i < b1 && (i + count1) < c1); i = i + 1) {
//
//            // Storing the elements in the
//            // resultant array
//            c[count1 + i] = b[i/*-count1*/];
//        }
//        return c;
//    }
//}
////        Конец Примера 6 КККККККККККККККК








////        Пример 5 ППППППППППППППППППППППППППППППППППП  //  ЭКСПЕРИМЕНТ УДАЧЕН, ПОДГОНЯЕМ ПОД НАШЕ ЗАДАНИЕ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//        System.out.println("""
//                Задание:\s
//                4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[]
//                   array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) -
//                   который возвращает новый массив, в котором он соединяет все предыдущие
//                   (было 3 массива по 10 элементов, станет массив с 20 элементами)
//
//                Решение:\s""");
//
//            // first array
//        int array1[] = {30, 25, 40, 555, 666, 777};
//            // second array
//        int array2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//            // resultant array
//        int arr1_AND_arr2[] = merge(array1, array2);
//
//        merge(array1, array2);
//        System.out.println(Arrays.toString(arr1_AND_arr2));
//        }
//
//    private static int[] merge(int a[], int b[]) {
//        // determining length of first array
//        int a1 = a.length;
//        // determining length of second array
//        int b1 = b.length;
//
//        // resultant array size
//        int c1 = 10;
//
//        // Creating a new array
//        int[] c = new int[c1];
//        int count1 = 3;
//
////            while (n < c1) {
//        // Loop to store the elements of first
//        // array into resultant array
//        for (int i = 0; (i < a1 && i < c1); i = i + 1) {
////        for (int i = 0; (i < count1 && i < c1); i = i + 1) {
//            // Storing the elements in
//            // the resultant array
//            c[i] = a[i];
//        }
//
//        // Loop to concat the elements of second
//        // array into resultant array
//        for (int i = 0; (i < b1 && (i + a1) < c1); i = i + 1) {
////        for (int i = 0; (i < b1 && (i + count1) < c1); i = i + 1) {
//
//            // Storing the elements in the
//            // resultant array
//            c[a1 + i] = b[i];
//        }
//        return c;
//    }
//}
////        Конец Примера 5 КККККККККККККККК








////        Пример 4 ППППППППППППППППППППППППППППППППППП  //  ЭКСПЕРИМЕНТИРУЕМ, из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
//// Java Program to demonstrate merging
//// two array without using pre-defined method
//        public static void main(String[] args)
//        {
//
//            // first array
//            int a[] = {30, 25, 40, 555, 666, 777};
//            // second array
//            int b[] = {0, 1, 2, 3, 4, 5,6, 7, 8, 9};
//
//            // determining length of first array
//            int a1 = a.length;
//            // determining length of second array
//            int b1 = b.length;
//
//            // resultant array size
////            int c1 = a1 + b1;
//            int c1 = 10;
//
//            // Creating a new array
//            int[] c = new int[c1];
////            int n = 0;
//
////            while (n < c1) {
//                // Loop to store the elements of first
//                // array into resultant array
//                for (int i = 0; (i < a1 && i < c1); i = i + 1) {
//                    // Storing the elements in
//                    // the resultant array
//                    c[i] = a[i];
////                    n++;
//                }
//
//                // Loop to concat the elements of second
//                // array into resultant array
//                for (int i = 0; (i < b1 && (i + a1) < c1); i = i + 1) {
//
//                    // Storing the elements in the
//                    // resultant array
//                    c[a1 + i] = b[i];
////                    n++;
//                }
////                c1 = c1-6 + 1;
////                n++;
////            }
//            System.out.println(Arrays.toString(c));
//        }
//    }
////        Конец Примера 4 КККККККККККККККК








////        Пример 3 ППППППППППППППППППППППППППППППППППП  //  из интернет:
////        Method 2: Without using pre-defined function
////        https://www.geeksforgeeks.org/java-program-to-merge-two-arrays/
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
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
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
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
//public class com.draft_task1_3_8.Draft_Task1_3_8_4 {
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








