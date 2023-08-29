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

//        Пример _ ППППППППППППППППППППППППППППППППППП  //Условие победы, 4 яблока, сделал, теперь надо создать
// стенки ( стенку ), препятствия,
// во второй части переменная sX[] = new int[300] создаётся, а надо вроде 400 мин 05 32 https://youtu.be/EwuooLH6N94 ,
// здесь же при создании объекта класса Snake указываются 4 координаты, x1, y1 и т.д.
// и здесь же создать движение public void move мин 07 05
// и здесь же во второй части создание таймера Timer мин 15 59
// и здесь же описание все действия, происходящие в игре , змейка врезается в себя, змейка встречается с яблоком
public class Draft_Task1_3_10_4 extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 2;

    static Snake_4 s = new Snake_4(5, 6, 5, 5, 5, 4);
    Apple apple = new Apple(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
    Apple2 apple2 = new Apple2(Math.abs((int) (Math.random()*Draft_Task1_3_10_4.WIDTH-1)), Math.abs((int) (Math.random()*Draft_Task1_3_10_4.HEIGHT-1)));
    Timer timer = new Timer(1000/speed, this);

    public Draft_Task1_3_10_4() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true); //Это чтобы находилось в центре экрана, 3 часть 08 57 , https://youtu.be/UEjMMnBGmgw
    }

    public void paint (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);

        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
//            g.setColor(Color.white);
            g.setColor(Color.black);
            g.drawLine(x,0, x, HEIGHT*SCALE);
        }
        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
//            g.setColor(Color.white);
            g.setColor(Color.black);
            g.drawLine(0, y,WIDTH*SCALE, y);
        }

        g.setColor(Color.red);
        g.fillOval(apple.posX*SCALE+4, apple.posY*SCALE+4, SCALE-8, SCALE-8);
        g.fillOval(apple2.posX2*SCALE+4, apple2.posY2*SCALE+4, SCALE-8, SCALE-8);
        for (int l = 1; l < s.length; l++) {
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*SCALE+3, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0]*SCALE+3, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
        }
    }

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                4. Доработайте змейку, что б на поле были фрукты. Если змейка их съедает -
                   она растет. Если съела все фрукты - игрок победил.

                Решение:\s
                Мною добавлено уточняющее условие: победа наступает, если змейка съедает 4 яблока.""");

        jFrame = new JFrame("Title");
//        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
        jFrame.setSize(WIDTH*SCALE+14,HEIGHT*SCALE+37);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new Draft_Task1_3_10_4());

        jFrame.setVisible(true);

        JOptionPane.showMessageDialog(null, "To win, snake must eat 4 apples.");
//        s.move();
//        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
//        timer.stop();

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



        //Условие, что происходит после съедения яблока.
        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY)) {
            apple.setRandomPosition();
            s.length++;
        }

        if ((s.sX[0] == apple2.posX2) && (s.sY[0] == apple2.posY2)) {
            apple2.setRandomPosition2();
            s.length++;
        }

        for (int l = 1; l < s.length; l++) {
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }

            if ((s.sX[l] == apple2.posX2) && (s.sY[l] == apple2.posY2)) {
                apple2.setRandomPosition2();
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
        }
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
