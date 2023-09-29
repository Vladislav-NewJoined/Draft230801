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

//        Пример _ ППППППППППППППППППППППППППППППППППП  // _
// во второй части создание таймера Timer мин 15 59
// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
public class Draft_Task1_3_10_4_2copy extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 2;

    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
    Apple apple = new Apple(Math.abs((int) (Math.random() * Draft_Task1_3_10_4_2copy.WIDTH - 1)), Math.abs((int) (Math.random() * Draft_Task1_3_10_4_2copy.HEIGHT - 1)));
    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random() * Draft_Task1_3_10_4_2copy.WIDTH - 1)), Math.abs((int) (Math.random() * Draft_Task1_3_10_4_2copy.HEIGHT - 1)));
    Timer timer = new Timer(1000 / speed, this);

    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
    static Obstacle2 o2 = new Obstacle2(4, 17, 5, 17, 6, 17, 7, 17);

    public Draft_Task1_3_10_4_2copy() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
//            g.setColor(Color.white);
            g.setColor(Color.black);
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
//            g.setColor(Color.white);
            g.setColor(Color.black);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        g.setColor(Color.red);
        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);
        g.fillOval(apple2.posX2 * SCALE + 4, apple2.posY2 * SCALE + 4, SCALE - 8, SCALE - 8);
        for (int l = 1; l < s.length; l++) {
            g.setColor(Color.green);
            g.fillRect(s.sX[l] * SCALE + 3, s.sY[l] * SCALE + 3, SCALE - 6, SCALE - 6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0] * SCALE + 3, s.sY[0] * SCALE + 3, SCALE - 6, SCALE - 6);
        }

        //Отрисовываем стены (препятствия)
        for (int l = 0; l < o.lengthObstacle; l++) {
            g.setColor(Color.gray);
            g.fillRect(o.oX[l] * SCALE, o.oY[l] * SCALE, SCALE, SCALE);
        }

        for (int l = 0; l < o2.lengthObstacle2; l++) {
            g.setColor(Color.gray);
            g.fillRect(o2.oX2[l] * SCALE, o2.oY2[l] * SCALE, SCALE, SCALE);
        }
        //конец раздела: Отрисовываем стены (препятствия)
    }

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
                   она растет. Если съела все фрукты - игрок победил.

                Решение:\s
                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");

        jFrame = new JFrame("Snake");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
        jFrame.setSize(WIDTH * SCALE + 14, HEIGHT * SCALE + 37);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new Draft_Task1_3_10_4_2copy());
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//            ПРОПИСЫВАЕМ MUST EAT 4 APPLES чтобы не каждый раз
              // Лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
        s.move();
        timer.start();
//        timer.restart();

                if ((s.sX[0] == 5) && (s.sY[0] == 7)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//                jFrame.setVisible(false);
                    jFrame.setVisible(true);
                    timer.restart();
                }
//            //Конец: лучше условие: Появление первоначальной таблички про победу после 4-х яблок.

////            ПРОПИСЫВАЕМ MUST EAT 4 APPLES чтобы не каждый раз
//              // Лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
//        s.move();
//        timer.start();
////        timer.restart();
//
//                if ((s.sX[0] == 5) && (s.sY[0] == 7)) {
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
////            //Конец: лучше условие: Появление первоначальной таблички про победу после 4-х яблок.



//        timer.start();
//        timer.restart();



//            //Условие: Появление первоначальной таблички про победу после 4-х яблок.
////        if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
////                repaint();
//            timer.stop();
//            JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
//            jFrame.setVisible(true);
//            timer.restart();
////        }
//            //Конец условия про Появление первоначальной таблички про победу после 4-х яблок.



        //пишем условие для победы (съедено 4 яблока)
        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
            s.countApples++;

            if (s.countApples == 4) {
                s.length++;
                repaint();
                timer.stop();
                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
                jFrame.setVisible(false);
                System.exit(0);
            }
        }

        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
            s.countApples++;

            if (s.countApples == 4) {
                s.length++;
                repaint();
                timer.stop();
                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
                jFrame.setVisible(false);
                System.exit(0);
            }
        }
        //конец условия для победы



        //Условие, что происходит после съедения яблока и пересечения самой себя.
        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
            apple.setRandomPosition();
            s.length++;
        }

        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
            apple2.setRandomPosition2();
            while (apple2.posX2 == apple.posX) {
                apple2.setRandomPosition2();
            }
            s.length++;
        }

        for (int l = 1; l < s.length; l++) {
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }

            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
                apple2.setRandomPosition2();
                while (apple2.posX2 == apple.posX) {
                    apple2.setRandomPosition2();
                }
            }
        //Конец условия, что происходит после съедения яблока.


            //Snake crossed itself
            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
//                System.out.println("crash");
                timer.stop();
                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
                jFrame.setVisible(false);
                System.exit(0);
            }
        }
        //Конец условия, что происходит после съедения яблока и пересечения самой себя.


            //Условие, что происходит при столкновении с препятствием.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((s.sX[0] == o.oX[i]) && (s.sY[0] == o.oY[j])) {
//                repaint();
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
                    jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
//                break;
                    System.exit(0);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((s.sX[0] == o2.oX2[i]) && (s.sY[0] == o2.oY2[j])) {
//                repaint();
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
                    jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
//                break;
                    System.exit(0);
                }
            }
        }

            //Конец условия, что происходит при столкновении с препятствием.



            //Snake collided into wall.
            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
                jFrame.setVisible(false);
                System.exit(0);
            }
            if (s.sX[0] < 0) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
                jFrame.setVisible(false);
                System.exit(0);
            }
            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
                jFrame.setVisible(false);
                System.exit(0);
            }
            if (s.sY[0] < 0) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
                jFrame.setVisible(false);
                System.exit(0);
            }
//        }
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
/*class SnakeGame extends JPanel {

}*/

//        Конец Примера _ КККККККККККККККК






////        Пример 32 ППППППППППППППППППППППППППППППППППП  // Работает, поменять координату на выключатель или счетчик
//// во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random() * Draft_Task1_3_10_4.WIDTH - 1)), Math.abs((int) (Math.random() * Draft_Task1_3_10_4.HEIGHT - 1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random() * Draft_Task1_3_10_4.WIDTH - 1)), Math.abs((int) (Math.random() * Draft_Task1_3_10_4.HEIGHT - 1)));
//    Timer timer = new Timer(1000 / speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//    static Obstacle2 o2 = new Obstacle2(4, 17, 5, 17, 6, 17, 7, 17);
//
//
//    public Draft_Task1_3_10_4() {
//        int n = 0;
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint(Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
//
//        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x, 0, x, HEIGHT * SCALE);
//        }
//        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y, WIDTH * SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);
//        g.fillOval(apple2.posX2 * SCALE + 4, apple2.posY2 * SCALE + 4, SCALE - 8, SCALE - 8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l] * SCALE + 3, s.sY[l] * SCALE + 3, SCALE - 6, SCALE - 6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0] * SCALE + 3, s.sY[0] * SCALE + 3, SCALE - 6, SCALE - 6);
//        }
//
//        //Отрисовываем стены (препятствия)
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l] * SCALE, o.oY[l] * SCALE, SCALE, SCALE);
//        }
//
//        for (int l = 0; l < o2.lengthObstacle2; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o2.oX2[l] * SCALE, o2.oY2[l] * SCALE, SCALE, SCALE);
//        }
//        //конец раздела: Отрисовываем стены (препятствия)
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH * SCALE + 14, HEIGHT * SCALE + 37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
////        s.move();
////        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////        s.move();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
////            //Лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
//        s.move();
//        timer.start();
////        timer.restart();
//
//                if ((s.sX[0] == 5) && (s.sY[0] == 7)) {
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
////            //Конец: лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
////        timer.start();
////        timer.restart();
//
//
//
////            //Условие: Появление первоначальной таблички про победу после 4-х яблок.
//////        if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//////                repaint();
////            timer.stop();
////            JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////            jFrame.setVisible(true);
////            timer.restart();
//////        }
////            //Конец условия про Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока и пересечения самой себя.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            while (apple2.posX2 == apple.posX) {
//                apple2.setRandomPosition2();
//            }
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//                while (apple2.posX2 == apple.posX) {
//                    apple2.setRandomPosition2();
//                }
//            }
//        //Конец условия, что происходит после съедения яблока.
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //Конец условия, что происходит после съедения яблока и пересечения самой себя.
//
//
//            //Условие, что происходит при столкновении с препятствием.
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ((s.sX[0] == o.oX[i]) && (s.sY[0] == o.oY[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == o2.oX2[i]) && (s.sY[0] == o2.oY2[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
////        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 32 КККККККККККККККК






////        Пример 31 ППППППППППППППППППППППППППППППППППП  // Тест 2, более желательный. Тестируем пример из интернета: ссылка ниже
//// https://translated.turbopages.org/proxy_u/en-ru.ru.3c0e7cff-64f03bde-44592750-74722d776562/https/stackoverflow.com/questions/1022880/accessing-a-variable-from-another-class
//
//public class Draft_Task1_3_10_4 {
//
//    public static void main(String[] args) {
//
//        DrawFrame frame = new DrawFrame();
//        int theWidth = frame.getWidth();
//        int theHeight = frame.getHeight();
//
//        System.out.println(theWidth + " " + theHeight);
//    }
//}
////        Конец Примера 31 КККККККККККККККК






////        Пример 30 ППППППППППППППППППППППППППППППППППП  // Тест 1, менее желательный. Тестируем пример из интернета: ссылка ниже
//// https://translated.turbopages.org/proxy_u/en-ru.ru.3c0e7cff-64f03bde-44592750-74722d776562/https/stackoverflow.com/questions/1022880/accessing-a-variable-from-another-class
//
//public class Draft_Task1_3_10_4 {
////    public int widthHere = 100;
////    public int heightHere = 100;
//
//    public static void main(String[] args) {
////        DrawFrame frame = new DrawFrame();
////        int theWidthT = frame.widthThere;
////        int theHeightT = frame.heightThere;
////
////        int result1 = theWidthT * 2;
////        int result2 = theHeightT * 2;
////
////        System.out.println("result1, result2: " + result1 + " " + result2);
////        System.out.println("result1 first, result2 first: " + result1 + " " + result2);
////
////        System.out.println("result1, result2: " + theWidthT * 2 + " " + theHeightT * 2);
////        System.out.println("result1 second, result2 second: " + theWidthT * 2 + " " + theHeightT * 2);
//
//
//
//
////        Draft_Task1_3_10_4 draft_task = new Draft_Task1_3_10_4();
////        int theWidthH = draft_task.widthHere;
////        int theHeightH = draft_task.heightHere;
////
////        int result3 = theWidthH * 5;
////        int result4 = theHeightH * 5;
////
////        System.out.println("result3, result4: " + result3 + " " + result4);
////        System.out.println("result3 third, result4 third: " + result3 + " " + result4);
////
////        System.out.println("result3, result4: " + theWidthH * 5 + " " + theHeightH * 5);
////        System.out.println("result3 fourth, result4 fourth: " + theWidthH * 5 + " " + theHeightH * 5);
//
//
//        //Вот так точно, как в интернет примере:
//        DrawFrame frame = new DrawFrame();
//        int theWidth = frame.widthThere;
//        int theHeight = frame.heightThere;
//        System.out.println(theWidth + " " + theHeight);
//    }
//}
////        Конец Примера 30 КККККККККККККККК






////        Пример 29 ППППППППППППППППППППППППППППППППППП  // _
//// во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//    static Obstacle2 o2 = new Obstacle2(4, 17, 5, 17, 6, 17, 7, 17);
//
//
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//
//    //Отрисовываем стены (препятствия)
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l]*SCALE, o.oY[l]*SCALE, SCALE, SCALE);
//        }
//
//        for (int l = 0; l < o2.lengthObstacle2; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o2.oX2[l]*SCALE, o2.oY2[l]*SCALE, SCALE, SCALE);
//        }
//    //конец раздела: Отрисовываем стены (препятствия)
//
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
////        s.move();
////        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////        s.move();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
////            //Лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
//        s.move();
//        timer.start();
////        timer.restart();
//
//
////        for (int i = 0; i < 4; i++) {
////            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == 5) && (s.sY[0] == 7)) {
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
////            }
////        }
////            //Конец: лучше условие: Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
////        timer.start();
////        timer.restart();
//
//
//
////            //Условие: Появление первоначальной таблички про победу после 4-х яблок.
//////        if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//////                repaint();
////            timer.stop();
////            JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////            jFrame.setVisible(true);
////            timer.restart();
//////        }
////            //Конец условия про Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока и пересечения самой себя.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            while (apple2.posX2 == apple.posX) {
//                apple2.setRandomPosition2();
//            }
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//                while (apple2.posX2 == apple.posX) {
//                    apple2.setRandomPosition2();
//                }
//            }
//        //Конец условия, что происходит после съедения яблока.
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //Конец условия, что происходит после съедения яблока и пересечения самой себя.
//
//
//            //Условие, что происходит при столкновении с препятствием.
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ((s.sX[0] == o.oX[i]) && (s.sY[0] == o.oY[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == o2.oX2[i]) && (s.sY[0] == o2.oY2[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
////        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 29 КККККККККККККККК






////        Пример 28 ППППППППППППППППППППППППППППППППППП  // Табличка с надписью работает, теперь нужно изменить
//// условие, когда табличка появляется
//// во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//    static Obstacle2 o2 = new Obstacle2(4, 17, 5, 17, 6, 17, 7, 17);
//
//
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//
//    //Отрисовываем стены (препятствия)
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l]*SCALE, o.oY[l]*SCALE, SCALE, SCALE);
//        }
//
//        for (int l = 0; l < o2.lengthObstacle2; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o2.oX2[l]*SCALE, o2.oY2[l]*SCALE, SCALE, SCALE);
//        }
//    //конец раздела: Отрисовываем стены (препятствия)
//
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
////        s.move();
////        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////        s.move();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        timer.start();
////        timer.restart();
//
//
////        for (int i = 0; i < 4; i++) {
////            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == 5) && (s.sY[0] == 7)) {
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
////            }
////        }
//
//
//
////        timer.start();
////        timer.restart();
//
//
//
////            //Условие: Появление первоначальной таблички про победу после 4-х яблок.
//////        if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//////                repaint();
////            timer.stop();
////            JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////            jFrame.setVisible(true);
////            timer.restart();
//////        }
////            //Конец условия про Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока и пересечения самой себя.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //Конец условия, что происходит после съедения яблока и пересечения самой себя.
//
//
//            //Условие, что происходит при столкновении с препятствием.
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ((s.sX[0] == o.oX[i]) && (s.sY[0] == o.oY[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == o2.oX2[i]) && (s.sY[0] == o2.oY2[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
////        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 28 КККККККККККККККК






////        Пример 27 ППППППППППППППППППППППППППППППППППП  // Два препятствия сделано. Работает.
//// Сделать, чтобы таймер правильно заработал. Условие победы, 4 яблока, сделано, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//    static Obstacle2 o2 = new Obstacle2(4, 17, 5, 17, 6, 17, 7, 17);
//
//
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//
//    //Отрисовываем стены (препятствия)
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l]*SCALE, o.oY[l]*SCALE, SCALE, SCALE);
//        }
//
//        for (int l = 0; l < o2.lengthObstacle2; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o2.oX2[l]*SCALE, o2.oY2[l]*SCALE, SCALE, SCALE);
//        }
//    //конец раздела: Отрисовываем стены (препятствия)
//
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
////        CollisionWithObstacle collisionWithObstacle = new CollisionWithObstacle();
////        collisionWithObstacle.crashWithObst();
////
////        CollisionWithObstacle2 collisionWithObstacle2 = new CollisionWithObstacle2();
////        collisionWithObstacle2.crashWithObst2();
//
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
////        s.move();
//        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//        s.move();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
////        timer.start();
////        timer.restart();
//
//        s.move();
//        timer.start();
////        timer.restart();
//
////            //Условие: Появление первоначальной таблички про победу после 4-х яблок.
//////        if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//////                repaint();
////            timer.stop();
////            JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////            jFrame.setVisible(true);
////            timer.restart();
//////        }
////            //Конец условия про Появление первоначальной таблички про победу после 4-х яблок.
//
//
//
//
//
//
//
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока и пересечения самой себя.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //Конец условия, что происходит после съедения яблока и пересечения самой себя.
//
//
//
//
//            //Условие, что происходит при столкновении с препятствием.
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ((s.sX[0] == o.oX[i]) && (s.sY[0] == o.oY[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if ((s.sX[0] == o2.oX2[i]) && (s.sY[0] == o2.oY2[j])) {
////                repaint();
//                    timer.stop();
//                    JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
////                jFrame.setVisible(false);
//                    jFrame.setVisible(true);
//                    timer.restart();
////                System.exit(0);
////                break;
//                }
//            }
//        }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//
//
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
////        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 27 КККККККККККККККК






////        Пример 26 ППППППППППППППППППППППППППППППППППП  // Сработало при столкновении с первой ячейкой.
//// Пишем стены. Сделать, чтобы таймер правильно заработал. Условие победы, 4 яблока, сделано, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//
//
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//
//    //Отрисовываем стены
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l]*SCALE, o.oY[l]*SCALE, SCALE, SCALE);
//        }
//
//    //конец раздела: Отрисовываем стены
//
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        CollisionWithObstacle collisionWithObstacle = new CollisionWithObstacle();
//        collisionWithObstacle.crashWithObst();
////        Obstacle baraban = new Obstacle(14, 2, 14, 1, 14, 0);
//
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
//        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//        s.move();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        timer.start();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Условие, что происходит при столкновении с препятствием.
//            if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
//                jFrame.setVisible(false);
//                System.exit(0);
//
//            }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 26 КККККККККККККККК









////        Пример 25 ППППППППППППППППППППППППППППППППППП  // Пишем стены. Сделать, чтобы таймер правильно заработал. Условие победы, 4 яблока, сделано, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    static Obstacle o = new Obstacle(14, 2, 14, 1, 14, 0);
//
//
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//
//    //Отрисовываем стены
//        for (int l = 0; l < o.lengthObstacle; l++) {
//            g.setColor(Color.gray);
//            g.fillRect(o.oX[l]*SCALE, o.oY[l]*SCALE, SCALE, SCALE);
//        }
//
//    //конец раздела: Отрисовываем стены
//
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        CollisionWithObstacle collisionWithObstacle = new CollisionWithObstacle();
//        collisionWithObstacle.crashWithObst();
////        Obstacle baraban = new Obstacle(14, 2, 14, 1, 14, 0);
//
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
//        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//        s.move();
////        timer.start();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        timer.start();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Условие, что происходит при столкновении с препятствием.
//            if ((s.sX[0] == o.oX[0]) && (s.sY[0] == o.oY[0])) {
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "CRASH WITH OBSTACLE");
//                jFrame.setVisible(false);
//                System.exit(0);
//
//            }
//
//            //Конец условия, что происходит при столкновении с препятствием.
//
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 25 КККККККККККККККК






////        Пример 24 ППППППППППППППППППППППППППППППППППП  // Сделать, чтобы таймер правильно заработал. Условие победы, 4 яблока, сделано, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//
//
//        //таймер отладить
//        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//        s.move();
////        timer.start();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        timer.stop();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 24 КККККККККККККККК






////        Пример 23 ППППППППППППППППППППППППППППППППППП // Условие победы, 4 яблока, сделано, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//
//        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
////        s.move();
////        timer.start();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
////        timer.stop();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 23 КККККККККККККККК






////        Пример 22 ППППППППППППППППППППППППППППППППППП  //Условие победы, 4 яблока, сделал, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s
//                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 22 КККККККККККККККК






////        Пример 21 ППППППППППППППППППППППППППППППППППП  //Условие победы, 4 яблока, сделал, теперь надо создать
//// стенки ( стенку ), препятствия,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                s.move();
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                s.move();
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 21 КККККККККККККККК






////        Пример 20 ППППППППППППППППППППППППППППППППППП  //Работает без зажеванных краев. Сделать сдвиг на одно яблоко, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//// в третьей части нет сдвига,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
////            s.length++;
////            s.move();
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                s.move();
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
////            s.length++;
////            s.move();
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                s.length++;
//                s.move();
//                repaint();
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples. Game over.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall. Game over."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 20 КККККККККККККККК






////        Пример 19 ППППППППППППППППППППППППППППППППППП  //Работает без зажеванных краев. Сделать сдвиг на одно яблоко, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//// в третьей части нет сдвига,
//// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
//// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
//// и здесь же создать движение public void move мин 07 05
//// и здесь же во второй части создание таймера Timer мин 15 59
//// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
//    }
//
//    public void paint (Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);
//
//        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
////            s.length++;
////            s.move();
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
////            s.length++;
////            s.move();
//            s.countApples++;
//
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        //конец условия для победы
//
//
//
//        //Условие, что происходит после съедения яблока.
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//            //Конец условия, что происходит после съедения яблока.
//
//
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 19 КККККККККККККККК






////        Пример 18 ППППППППППППППППППППППППППППППППППП  //сделать сдвиг на одно яблоко, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
////        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 18 КККККККККККККККК






////        Пример 17 ППППППППППППППППППППППППППППППППППП  //сделать сдвиг на одно яблоко, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 2;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 17 КККККККККККККККК








////        Пример 16 ППППППППППППППППППППППППППППППППППП  //сделать сдвиг на одно яблоко, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 3;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples.");
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 16 КККККККККККККККК






////        Пример 15 ППППППППППППППППППППППППППППППППППП  //делаем победу после шести яблок, второе яблоко сделал, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 3;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
//        //пишем условие для победы (съедено 4 яблока)
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
////            apple.setRandomPosition();
////            s.length++;
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
////            apple2.setRandomPosition2();
////            s.length++;
//            s.countApples++;
//            if (s.countApples == 4) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You win. Snake ate 4 apples."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
//            }
//        }
//        //конец условия для победы
//
//
//
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//
//            //Snake crossed itself
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//
//        }
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 15 КККККККККККККККК






////        Пример 14 ППППППППППППППППППППППППППППППППППП  //второе яблоко сделал, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 3;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
//            apple2.setRandomPosition2();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//
//            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
//                apple2.setRandomPosition2();
//            }
//
//
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//
//        }
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 14 КККККККККККККККК






////        Пример 13 ППППППППППППППППППППППППППППППППППП  //переходим к созданию второго яблока, четвертая часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 3;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake crossed itself."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//            //Snake collided into wall.
//            if (s.sX[0] > Draft_Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] > Draft_Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//            if (s.sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You lost. Snake collided into wall."/* + "Start again?"*/);
//                jFrame.setVisible(false);
//                System.exit(0);
////                s.length = 2;
////                s.direction = 0;
////                apple.setRandomPosition();
////                jFrame.setVisible(true);
////                timer.start();
//            }
//
//
//        }
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 13 КККККККККККККККК






////        Пример 12 ППППППППППППППППППППППППППППППППППП  /правильно до мин __ четвертая
////        часть закончена https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 3;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l])) {
////                System.out.println("crash");
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "You've lost. Start again?");
//                jFrame.setVisible(false);
//                s.length = 2;
//                s.direction = 0;
//                apple.setRandomPosition();
//                jFrame.setVisible(true);
//                timer.start();
//            }
//        }
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 12 КККККККККККККККК






////        Пример 11 ППППППППППППППППППППППППППППППППППП  /правильно до мин 13 41 из четвертой
////        части https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
//            apple.setRandomPosition();
//            s.length++;
//        }
//
//        for (int l = 1; l < s.length; l++) {
//            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
//                apple.setRandomPosition();
//            }
//        }
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 11 КККККККККККККККК






////        Пример 10 ППППППППППППППППППППППППППППППППППП  /правильно до мин 10 26 из четвертой
////        части https://youtu.be/BtEekB1u3t8
//
//public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {
//
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    Snake_3 s = new Snake_3(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
//    Timer timer = new Timer(1000/speed, this);
//
//    public Draft_Task1_3_10_4() {
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
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(x,0, x, HEIGHT*SCALE);
//        }
//        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
////            g.setColor(Color.white);
//            g.setColor(Color.black);
//            g.drawLine(0, y,WIDTH*SCALE, y);
//        }
//
//        g.setColor(Color.red);
//        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
//
//        for (int l = 1; l < s.length; l++) {
//            g.setColor(Color.green);
//            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
//            g.setColor(Color.white);
//            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
//                   она растет. Если съела все фрукты - игрок победил.
//
//                Решение:\s""");
//
//        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new Draft_Task1_3_10_4());
//
//        jFrame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        s.move();
//
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
///*class SnakeGame extends JPanel {
//
//}*/
//
////        Конец Примера 10 КККККККККККККККК






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
