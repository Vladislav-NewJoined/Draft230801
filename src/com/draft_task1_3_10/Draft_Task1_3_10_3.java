package com.draft_task1_3_10;

//змейка здесь https://yandex.ru/search/?text=%2Bjava+%D0%BD%D0%B0%D0%BF%D0%B8%D1%81%D0%B0%D1%82%D1%8C+%D0%B7%D0%BC%D0%B5%D0%B9%D0%BA%D1%83+%D0%BD%D0%B0+java&search_source=dzen_desktop_safe&src=suggest_Nin&lr=42
//и здесь https://www.youtube.com/watch?v=1d1Seo3lO2M
//вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//третья часть https://www.youtube.com/watch?v=UEjMMnBGmgw
//четвертая часть https://www.youtube.com/watch?v=BtEekB1u3t8

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//        Пример _ ППППППППППППППППППППППППППППППППППП  /третья часть закончена, правильно до конца третьей части, отсюда:
//        третья часть https://www.youtube.com/watch?v=UEjMMnBGmgw

public class Draft_Task1_3_10_3 extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 10;

    Snake_3 s = new Snake_3(5, 6, 5, 5, 5, 4);
    Timer timer = new Timer(1000/speed, this);

    public Draft_Task1_3_10_3() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
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

        for (int l = 0; l < s.length; l++) {
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                3. Доработайте змейку, что б при врезании в стену(край поля) - игра оканчивалась

                Решение:\s""");

        jFrame = new JFrame("Title");
        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new Draft_Task1_3_10_3());

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed (KeyEvent event) {
            int key = event.getKeyCode();

            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;
        }
    }
}

///*public */class Snake_clean_copy_3 {
//
//    public int length = 2;
//    public int direction = 2;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_3(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
//
//        //up
//        if (direction == 0) sY[0]--;
//        //down
//        if (direction == 2) sY[0]++;
//        //right
//        if (direction == 1) sX[0]++;
//        //left
//        if (direction == 3) sX[0]--;
//
//        if (sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//            System.out.println("Snake collided into wall. Game over.");
//            System.exit(0);
//        }
//        if (sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//            System.out.println("Snake collided into wall. Game over.");
//            System.exit(0);
//        }
//        if (sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//            System.out.println("Snake collided into wall. Game over.");
//            System.exit(0);
//        }
//        if (sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//            System.out.println("Snake collided into wall. Game over.");
//            System.exit(0);
//        }
//    }
//}

/*class SnakeGame extends JPanel {

}*/

//        Конец Примера _ КККККККККККККККК






////        Пример 9 ППППППППППППППППППППППППППППППППППП  /третья часть закончена, правильно до конца третьей части, отсюда:
////        третья часть https://www.youtube.com/watch?v=UEjMMnBGmgw
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_clean_copy_4 s = new Snake_clean_copy_4(5, 6, 5, 5);
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_2_clean_copy() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true);
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
//
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        repaint();
//    }
//
//    public class KeyBoard extends KeyAdapter {
//        public void keyPressed (KeyEvent event) {
//            int key = event.getKeyCode();
//
//            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;
//            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
//            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
//            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;
//        }
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 2;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
//
//        //up
//        if (direction == 0) sY[0]--;
//        //down
//        if (direction == 2) sY[0]++;
//        //right
//        if (direction == 1) sX[0]++;
//        //left
//        if (direction == 3) sX[0]--;
//
//        if (sX[0] > Draft_Task1_3_10_2_clean_copy.WIDTH - 1) sX[0] = 0;
//        if (sX[0] < 0) sX[0] = Draft_Task1_3_10_2_clean_copy.WIDTH - 1;
//
//        if (sY[0] > Draft_Task1_3_10_2_clean_copy.HEIGHT - 1) sY[0] = 0;
//        if (sY[0] < 0) sY[0] = Draft_Task1_3_10_2_clean_copy.HEIGHT - 1;
//    }
//}
//
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 9 КККККККККККККККК






////        Пример 8 ППППППППППППППППППППППППППППППППППП  //вторая часть закончена, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_clean_copy_4 s = new Snake_clean_copy_4(5, 6, 5, 5);
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_2_clean_copy() {
//        timer.start();
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
//
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        repaint();
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
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
////        Конец Примера 8 КККККККККККККККК






////        Пример 7 ППППППППППППППППППППППППППППППППППП  //правильно до мин 19 17, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_clean_copy_4 s = new Snake_clean_copy_4(5, 6, 5, 5);
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_2_clean_copy() {
//        timer.start();
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
//
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        repaint();
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
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
////        Конец Примера 7 КККККККККККККККК






////        Пример 6 ППППППППППППППППППППППППППППППППППП  //правильно до мин 17 35, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_clean_copy_4 s = new Snake_clean_copy_4(5, 6, 5, 5);
//    Timer timer = new Timer(1000/speed, this);
//
//    public void Draft_Task1_3_10_2_clean_copy() {
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
//
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
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
////        Конец Примера 6 КККККККККККККККК






////        Пример 5 ППППППППППППППППППППППППППППППППППП  //правильно до мин 15 38, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//
//    Snake_clean_copy_4 s = new Snake_clean_copy_4(5, 6, 5, 5);
//
//    public void Draft_Task1_3_10_2_clean_copy() {
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
//
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+2, s.sY[l]*SCALE+2, SCALE-2, SCALE-2);
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
//        sX[0] = x1;
//        sX[1] = x2;
//        sY[0] = y1;
//        sY[1] = y2;
//    }
//
//    public void move() {
//
//        for (int l = length; l > 0; l--) {
//            sX[l] = sX[l-1];
//            sY[l] = sY[l-1];
//        }
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
////        Конец Примера 5 КККККККККККККККК






////        Пример 4 ППППППППППППППППППППППППППППППППППП  //правильно до мин 09 52, пример взят отсюда: вторая часть https://www.youtube.com/watch?v=EwuooLH6N94
//
//public class Draft_Task1_3_10_2_clean_copy extends JPanel {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//
//    public void Draft_Task1_3_10_2_clean_copy() {
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
//
//        jFrame.setVisible(true);
//    }
//}
//
///*public */class Snake_clean_copy_4 {
//
//    public int length = 2;
//    public int direction = 0;
//
//    public int sX[] = new int[300];
//    public int sY[] = new int[300];
//
//    public Snake_clean_copy_4(int x1, int y1, int x2, int y2) {
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
//public class Draft_Task1_3_10_2_clean_copy extends JPanel {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//
//    public void Draft_Task1_3_10_2_clean_copy() {
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
//        jFrame.add(new Draft_Task1_3_10_2_clean_copy());
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
//public class Draft_Task1_3_10_2_clean_copy extends JPanel {
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
//public class Draft_Task1_3_10_2_clean_copy {
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
//        Snake_clean_copy_4 test = new Snake_clean_copy_4();
//        test.test();
//
//        String anotherTest = "Snake_clean_copy_4 test_Another test";
//        AnotherTest str = new AnotherTest();
//        str.anotherTest(anotherTest);
//    }
//}
//
//class Snake_clean_copy_4 extends JPanel {
//
//    /*static */void test() {
//        System.out.println("Snake_clean_copy_4 test");
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






