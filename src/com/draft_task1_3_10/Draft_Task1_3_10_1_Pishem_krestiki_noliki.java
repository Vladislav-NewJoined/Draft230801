//закончил видео мин: 22 56 строка 75

package com.draft_task1_3_10;
import java.util.Scanner;
public class Draft_Task1_3_10_1_Pishem_krestiki_noliki {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                1. Напишите сами крестики-нолики, не подглядывая в наш код.

                Решение:\s""");

//        FieldX0 fieldX0 = new FieldX0();
//        fieldX0.initField();
//        fieldX0.printField();

//        FieldX0 game = new FieldX0();
        X0Game game = new X0Game();
//        game.setupNewGame();
        game.play();


        }
}

/*pablic */class FieldX0 {
    /*public */char[][] field;
    int size = 3;
    int countToWin = 3;

    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < (size); row++) {
            for (int col = 0; col < (size); col++) {
                field[row][col] = ' ';
            }
        }
        System.out.println("Field initialized");
        this.printField();
    }
    void printField(){
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int row = 0; row < (size); row++) {
            int rowNum = row + 1;
            System.out.print(rowNum + " ");
            for (int col = 0; col < (size); col++) {
                System.out.print("[" + field[row][col] + "]");
            }
            System.out.println();
        }
    }

    boolean isPlaceFree(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= size || colIndex < 0 || colIndex >= size) {
            return false;
        } else {
//            return this.field[rowIndex][colIndex] == ' ';
        if (this.field[rowIndex][colIndex] == ' ') {
            return true;
        } else {
            return false;

        }
        }
    }

    void setValue(int rowIndex, int colIndex, char value) {
        this.field[rowIndex][colIndex] = value;
    }

    boolean isGameOver(char whoMakeNextTurn) {
        for (int row = 0; row <= this.size - this.countToWin; row++) {
            for (int col = 0; col <= this.size - this.countToWin; col++) {
                if (this.field[row][col] == player && this.field[row][col+1] == player && this.field[row][col+2] == player)
            }
        }
        return false;
    }

}