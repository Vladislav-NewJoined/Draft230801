package com.draft_task1_3_10_Combining;

import com.draft_task1_3_10.Snake_3;

import javax.swing.*;

//пример взят отсюда: https://www.youtube.com/@user-kn1dy2bl7i/videos Змейка, все части_Ирина Галкина - YouTube

//        Пример _ ППППППППППППППППППППППППППППППППППП  Увеличение игрового поля
// теперь совместить с другой инструкцией, третья часть закончена https://github.com/irinamore/snake_part3-final-/tree/master/src
public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320,345);
//        setSize(640,640);
        setLocation(400,400);
        add(new GameField());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
//        Конец Примера _ КККККККККККККККК






////        Пример 4 ППППППППППППППППППППППППППППППППППП  теперь совместить с другой инструкцией, третья часть закончена https://github.com/irinamore/snake_part3-final-/tree/master/src
//public class MainWindow extends JFrame {
//    public MainWindow(){
//        setTitle("Змейка");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(320,345);
//        setLocation(400,400);
//        add(new GameField());
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//    }
//}
////        Конец Примера 4 КККККККККККККККК






////        Пример 3 ППППППППППППППППППППППППППППППППППП третья часть закончена https://github.com/irinamore/snake_part3-final-/tree/master/src
//public class MainWindow extends JFrame {
//    public MainWindow(){
//        setTitle("Змейка");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(320,345);
//        setLocation(400,400);
//        add(new GameField());
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//    }
//}
////        Конец Примера 3 КККККККККККККККК






////        Пример 2 ППППППППППППППППППППППППППППППППППП прервался на видео мин __, вторая часть закончена https://youtu.be/VnogOoOQZIE
// этот фрагмент взять для задания 2,
// здесь встреча с яблоком вторая часть видео мин 12 36
//public class MainWindow extends JFrame {
//    public MainWindow(){
//        setTitle("Змейка");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(320,345);
//        setLocation(400,400);
//        add(new GameField());
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//    }
//}
////        Конец Примера 2 КККККККККККККККК






////        Пример 1 ППППППППППППППППППППППППППППППППППП первая часть закончена, https://youtu.be/TJvcYxfQ3J0
//public class MainWindow  extends JFrame {
//    public MainWindow(){
//        setTitle("Змейка");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(320,345);
//        setLocation(400,400);
//        add(new GameField());
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//    }
//
//}
////        Конец Примера 1 КККККККККККККККК






