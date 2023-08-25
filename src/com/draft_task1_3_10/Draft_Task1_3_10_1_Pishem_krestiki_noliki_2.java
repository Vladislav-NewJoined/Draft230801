//правильно до мин 37 46 нолик победил, игра закончена

package com.draft_task1_3_10;

import java.util.Scanner;

//        Пример _ ППППППППППППППППППППППППППППППППППП  //Получилось рэндзю 9х9
public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
    public static void main(String[] args) {
        X0Game game = new X0Game();
        game.play();
    }
}

class FieldXO {
    char[][] field;
    int size = 9;
    int countToWin = 5;

    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = ' ';

            }
        }
        System.out.println("Field initialized");
        this.printField();
    }

    void printField() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            int rowNumber = row + 1;
            System.out.print(rowNumber + " ");
            for (int col = 0; col < size; col++) {
                System.out.print("[" + this.field[row][col] + "]");
            }
            System.out.println();
        }
    }

    boolean isPlaceFree(int rowIndex, int colIndex) {
        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
            return false;
        } else if (this.field[rowIndex][colIndex] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    void setValue(int rowIndex, int colIndex, char value) {
        this.field[rowIndex][colIndex] = value;
    }

    boolean isGameOver(char player) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (checkRightDirection(row, col, player)) {
                    return true;
                } else if (checkDownDirection(row, col, player)) {
                    return true;
                } else if (checkRightDiagonal(row, col, player)) {
                    return true;
                } else if (checkLeftDiagonal(row, col, player)) {
                    return true;
                }
            }
        }
        return  false;
    }

    boolean checkRightDirection(int row, int col, char player) {
        if (col > this.size - this.countToWin) {
            return false;
        }
            for (int i=col; i<col+this.countToWin; i++) {
                if (this.field[row][i] != player) {
                    return false;
                }
            }
        return true;
    }

    boolean checkDownDirection(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
            for (int i=row; i<row+this.countToWin; i++) {
                if (this.field[i][col] != player) {
                    return false;
                }
            }
        return true;
    }

    boolean checkRightDiagonal(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
        if (col > this.size - this.countToWin) {
            return false;
        }

        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
            int rowToCheck = row + sdvig;
            int colToCheck = col + sdvig;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }
    boolean checkLeftDiagonal(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
        if (col < this.countToWin - 1) {
            return false;
        }

        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
            int rowToCheck = row + sdvig;
            int colToCheck = col - sdvig;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }

        }
        return true;
    }
}

class X0Game {
    FieldXO gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;

    void setupNewGame() {
        System.out.println("Will play new X0 game");
        this.gameField = new FieldXO();
        this.gameField.initField();
    }

    void play() {
        this.setupNewGame();
        System.out.println("Who will make first turn: ");
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == '0') {
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("I recognizing only X or 0 (zero). So first will be X");
            this.whoMakeNextTurn = 'X';
        }

        while (!gameOver) {
            turn();
            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
            if (this.gameOver) {
                System.out.println(this.whoMakeNextTurn + " win!");
            }
            if (this.whoMakeNextTurn == 'X') {
                this.whoMakeNextTurn = '0';
            } else {
                this.whoMakeNextTurn = 'X';
            }
        }
        System.out.println("Game over.");
    }

    void turn() {
        System.out.println(this.whoMakeNextTurn + ", your turn.");
        System.out.print("Chose row: ");
        int rowNumber = this.scanner.nextInt();
        System.out.print("Chose column: ");
        int colNumber = this.scanner.nextInt();
        int rowIndex = rowNumber - 1;
        int colIndex = colNumber - 1;
        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
            this.gameField.printField();
        } else {
            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
            turn();
        }
    }


}
//        Конец Примера _ КККККККККККККККК





////        Пример 10 ППППППППППППППППППППППППППППППППППП  //ГОТОВО, мин 49 17 но есть продолжение видео, посмотреть что там
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                if (checkRightDirection(row, col, player)) {
//                    return true;
//                } else if (checkDownDirection(row, col, player)) {
//                    return true;
//                } else if (checkRightDiagonal(row, col, player)) {
//                    return true;
//                } else if (checkLeftDiagonal(row, col, player)) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//
//    boolean checkRightDirection(int row, int col, char player) {
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=col; i<col+this.countToWin; i++) {
//                if (this.field[row][i] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//
//    boolean checkDownDirection(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=row; i<row+this.countToWin; i++) {
//                if (this.field[i][col] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//
//    boolean checkRightDiagonal(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//
//        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
//            int rowToCheck = row + sdvig;
//            int colToCheck = col + sdvig;
//            if (this.field[rowToCheck][colToCheck] != player) {
//                return false;
//            }
//        }
//        return true;
//    }
//    boolean checkLeftDiagonal(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//        if (col < this.countToWin - 1) {
//            return false;
//        }
//
//        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
//            int rowToCheck = row + sdvig;
//            int colToCheck = col - sdvig;
//            if (this.field[rowToCheck][colToCheck] != player) {
//                return false;
//            }
//
//        }
//        return true;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 10 КККККККККККККККК





////        Пример 9 ППППППППППППППППППППППППППППППППППП  //правильно? до мин 47 57 давайте...
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                if (checkRightDirection(row, col, player)) {
//                    return true;
//                } else if (checkDownDirection(row, col, player)) {
//                    return true;
//                } else if (checkRightDiagonal(row, col, player)) {
//                    return true;
//                } else if (checkLeftDiagonal(row, col, player)) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//
//    boolean checkRightDirection(int row, int col, char player) {
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=col; i<col+this.countToWin; i++) {
//                if (this.field[row][i] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//
//    boolean checkDownDirection(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=row; i<row+this.countToWin; i++) {
//                if (this.field[i][col] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//
//    boolean checkRightDiagonal(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=row; i<row+this.countToWin; i++) {
//                for (int j=col; j<col+this.countToWin; i++) {
//                    if (this.field[i][j] != player) {
//                        return false;
//                    }
//                }
//            }
//        return true;
//    }
//    boolean checkLeftDiagonal(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//        if (col < this.countToWin - 1) {
//            return false;
//        }
//            for (int i=row; i<row+this.countToWin; i++) {
//                for (int j=col; j>=col-this.countToWin+1; i--) {
//                    if (this.field[i][j] != player) {
//                        return false;
//                    }
//                }
//            }
//        return true;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 9 КККККККККККККККК





////        Пример 8 ППППППППППППППППППППППППППППППППППП  //правильно до мин 39 25 сделали условие для победы в столбик
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                if (checkRightDirection(row, col, player)) {
//                    return true;
//                } else if (checkDownDirection(row, col, player)) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//
//    boolean checkRightDirection(int row, int col, char player) {
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=col; i<col+this.countToWin; i++) {
//                if (this.field[row][i] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//    boolean checkDownDirection(int row, int col, char player) {
//        if (row > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=row; i<row+this.countToWin; i++) {
//                if (this.field[i][col] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 8 КККККККККККККККК





////        Пример 7 ППППППППППППППППППППППППППППППППППП  //правильно до мин 37 46 нолик победил, игра закончена
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row < this.size; row++) {
//            for (int col = 0; col < this.size; col++) {
//                if (checkRightDirection(row, col, player)) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//
//    boolean checkRightDirection(int row, int col, char player) {
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//            for (int i=col; i<col+this.countToWin; i++) {
//                if (this.field[row][i] != player) {
//                    return false;
//                }
//            }
//        return true;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 7 КККККККККККККККК





////        Пример 6 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 30 11 , тогда нам нужно немножко
////        переделать, долго переделываем каждую ячейку
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row <= this.size-this.countToWin; row++) {
//            for (int col = 0; col <= this.size-this.countToWin; col++) {
//                if (this.field[row][col] == player && this.field[row][col+1] == player && this.field[row][col+2] == player) {
//                    return true;
//                } else if (this.field[row][col] == player && this.field[row+1][col] == player && this.field[row+2][col] == player) {
//                    return true;
//                } else if (this.field[row][col] == player && this.field[row+1][col+1] == player && this.field[row+2][col+2] == player) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 6 КККККККККККККККК





////        Пример 5 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 28 13 , что-то не сработало , перед долгими
////        объяснениями и долгой переделкой
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row <= this.size-this.countToWin; row++) {
//            for (int col = 0; col <= this.size-this.countToWin; col++) {
//                if (this.field[row][col] == player && this.field[row][col+1] == player && this.field[row][col+2] == player) {
//                    return true;
//                } else if (this.field[row][col] == player && this.field[row+1][col] == player && this.field[row+2][col] == player) {
//                    return true;
//                } else if (this.field[row][col] == player && this.field[row+1][col+1] == player && this.field[row+2][col+2] == player) {
//                    return true;
//                }
//            }
//        }
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            this.gameOver = this.gameField.isGameOver(whoMakeNextTurn);
//            if (this.gameOver) {
//                System.out.println(this.whoMakeNextTurn + " win!");
//            }
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//        System.out.println("Game over.");
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 5 КККККККККККККККК





////        Пример 4 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 22 08
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        X0Game game = new X0Game();
//        game.play();
//
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char whoMakeLastTurn) {
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//            this.gameField.printField();
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 4 КККККККККККККККК





////        Пример 3 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 21 19
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
////        FieldXO fieldXO = new FieldXO();
////        fieldXO.initField();
////        fieldXO.printField();
//
//        X0Game game = new X0Game();
//        game.play();
//
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char whoMakeLastTurn) {
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 3 КККККККККККККККК





////        Пример 2 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 20 58
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
////        FieldXO fieldXO = new FieldXO();
////        fieldXO.initField();
////        fieldXO.printField();
//
//        X0Game game = new X0Game();
//        game.play();
//
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex>=size || colIndex<0 || colIndex>=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char whoMakeLastTurn) {
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 2 КККККККККККККККК





////        Пример 1 ППППППППППППППППППППППППППППППППППП  //вроде правильно до мин 19 37
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki_2 {
//    public static void main(String[] args) {
//        FieldXO fieldXO = new FieldXO();
//        fieldXO.initField();
//        fieldXO.printField();
//
//    }
//}
//
//class FieldXO {
//    char[][] field;
//    int size = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                field[row][col] = ' ';
//
//            }
//        }
//        System.out.println("Field initialized");
//    }
//
//    void printField() {
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            int rowNumber = row + 1;
//            System.out.print(rowNumber + " ");
//            for (int col = 0; col < size; col++) {
//                System.out.print("[" + this.field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex<0 || rowIndex<=size || colIndex<0 || colIndex<=size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char whoMakeLastTurn) {
//        return  false;
//    }
//}
//
//class X0Game {
//    FieldXO gameField;
//    Scanner scanner = new Scanner(System.in);
//    char whoMakeNextTurn;
//    boolean gameOver = false;
//
//    void setupNewGame() {
//        System.out.println("Will play new X0 game");
//        this.gameField = new FieldXO();
//        this.gameField.initField();
//    }
//
//    void play() {
//        this.setupNewGame();
//        System.out.println("Who will make first turn: ");
//        char first = this.scanner.next().charAt(0);
//        if (first == 'X' || first == '0') {
//            this.whoMakeNextTurn = first;
//        } else {
//            System.out.println("I recognizing only X or 0 (zero). So first will be X");
//            this.whoMakeNextTurn = 'X';
//        }
//
//        while (!gameOver) {
//            turn();
//            if (this.whoMakeNextTurn == 'X') {
//                this.whoMakeNextTurn = '0';
//            } else {
//                this.whoMakeNextTurn = 'X';
//            }
//        }
//    }
//
//    void turn() {
//        System.out.println(this.whoMakeNextTurn + ", your turn.");
//        System.out.print("Chose row: ");
//        int rowNumber = this.scanner.nextInt();
//        System.out.print("Chose column: ");
//        int colNumber = this.scanner.nextInt();
//        int rowIndex = rowNumber - 1;
//        int colIndex = colNumber - 1;
//        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
//            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
//
//        } else {
//            System.out.println("Wrong number (maybe this place is not free?). Make turn again.");
//            turn();
//        }
//    }
//
//
//}
////        Конец Примера 1 КККККККККККККККК





