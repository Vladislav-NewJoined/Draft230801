package com.draft_task1_3_10;

//змейка здесь https://yandex.ru/search/?text=%2Bjava+%D0%BD%D0%B0%D0%BF%D0%B8%D1%81%D0%B0%D1%82%D1%8C+%D0%B7%D0%BC%D0%B5%D0%B9%D0%BA%D1%83+%D0%BD%D0%B0+java&search_source=dzen_desktop_safe&src=suggest_Nin&lr=42
//и здесь https://www.youtube.com/watch?v=1d1Seo3lO2M
//вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//третья часть https://www.youtube.com/watch?v=UEjMMnBGmgw

import javax.swing.*;
import java.awt.*;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //правильно до мин 09 52, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94

public class Draft_Task1_3_10_2 extends JPanel {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public void Draft_Task1_3_10_2() {

    }

    public void paint (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);

        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
            g.setColor(Color.white);
            g.drawLine(x,0, x, HEIGHT*SCALE);
        }
        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
            g.setColor(Color.white);
            g.drawLine(0, y,WIDTH*SCALE, y);
        }
    }

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                2. Напишите “змейку”. Есть поле 20х20, есть змейка длинной, пусть, 3
                квадрата. Выводится поле с положением змейки. Пользователь вводит, куда
                сделать следующий шаг - повернуть, или не двигаться. Рисуется поле с
                новым положением змейки.

                Решение:\s""");

        jFrame = new JFrame("Title");
        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new Draft_Task1_3_10_2());

        jFrame.setVisible(true);
    }
}

/*public */class Snake {

    public int length = 2;
    public int direction = 0;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake(int x1, int y1, int x2, int y2) {
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move() {

        //up
        if (direction == 0) sY[0]--;
        //down
        if (direction == 2) sY[0]++;
        //right
        if (direction == 1) sX[0]++;
        //left
        if (direction == 3) sX[0]--;
    }
}

/*class SnakeGame extends JPanel {

}*/

//        Конец Примера _ КККККККККККККККК






////        Пример 4 ППППППППППППППППППППППППППППППППППП  //правильно до мин 09 52, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2 extends JPanel {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//
//    public void Draft_Task1_3_10_2() {
//
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
//            g.setColor(Color.white);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
//            g.setColor(Color.white);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                2. Напишите “змейку”. Есть поле 20х20, есть змейка длинной, пусть, 3
//                квадрата. Выводится поле с положением змейки. Пользователь вводит, куда
//                сделать следующий шаг - повернуть, или не двигаться. Рисуется поле с
//                новым положением змейки.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_2());
//
//        jFrame.setVisible(true);
//    }
//}
//
///*public */class Snake {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        //up
//        if (direction == 0) sY[0]--;
//        //down
//        if (direction == 2) sY[0]++;
//        //right
//        if (direction == 1) sX[0]++;
//        //left
//        if (direction == 3) sX[0]--;
//    }
//}
//
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 4 КККККККККККККККК






////        Пример 3 ППППППППППППППППППППППППППППППППППП  //правильно до мин 07 05 пример взят отсюда: https://youtu.be/1d1Seo3lO2M или https://www.youtube.com/watch?v=1d1Seo3lO2M
//
//public class Draft_Task1_3_10_2 extends JPanel {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//
//    public void Draft_Task1_3_10_2() {
//
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                2. Напишите “змейку”. Есть поле 20х20, есть змейка длинной, пусть, 3
//                квадрата. Выводится поле с положением змейки. Пользователь вводит, куда
//                сделать следующий шаг - повернуть, или не двигаться. Рисуется поле с
//                новым положением змейки.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE,HEIGHT*SCALE);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_2());
//
//        jFrame.setVisible(true);
//    }
//}
//
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 3 КККККККККККККККК






////        Пример 2 ППППППППППППППППППППППППППППППППППП  //правильно до мин 03 10 пример взят отсюда: https://youtu.be/1d1Seo3lO2M или https://www.youtube.com/watch?v=1d1Seo3lO2M
//
//import javax.swing.*;
//
//public class Draft_Task1_3_10_2 extends JPanel {
//
//    public static JFrame jFrame;
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                2. Напишите “змейку”. Есть поле 20х20, есть змейка длинной, пусть, 3
//                квадрата. Выводится поле с положением змейки. Пользователь вводит, куда
//                сделать следующий шаг - повернуть, или не двигаться. Рисуется поле с
//                новым положением змейки.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(600,600);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
//    }
//}
//
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 2 КККККККККККККККК






////        Пример 1 ППППППППППППППППППППППППППППППППППП
//
//import javax.swing.*;
//
//public class Draft_Task1_3_10_2 {
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                2. Напишите “змейку”. Есть поле 20х20, есть змейка длинной, пусть, 3
//                квадрата. Выводится поле с положением змейки. Пользователь вводит, куда
//                сделать следующий шаг - повернуть, или не двигаться. Рисуется поле с
//                новым положением змейки.
//
//                Решение:\s""");
//
//        Snake test = new Snake();
//        test.test();
//
//        String anotherTest = "Snake test_Another test";
//        AnotherTest str = new AnotherTest();
//        str.anotherTest(anotherTest);
//    }
//}
//
//class Snake extends JPanel {
//
//    /*static */void test() {
//        System.out.println("Snake test");
//    }
//}
//
//class AnotherTest {
//    /*static */String anotherTest(String anotherTest) {
//        System.out.println(anotherTest);
//        return anotherTest;
//    }
//}
////        Конец Примера 1 КККККККККККККККК






