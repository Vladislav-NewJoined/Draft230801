//закончил видео мин: 02 19

package com.draft_task1_3_10;
import java.util.Scanner;
public class Draft_Task1_3_10_1_Pishem_krestiki_noliki {
    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                1. Напишите сами крестики-нолики, не подглядывая в наш код.

                Решение:\s""");

        FieldX0 fieldX0 = new FieldX0();
        fieldX0.initField();
        fieldX0.printField();



        }
}

/*pablic */class FieldX0 {
    /*public */char[][] field;
    int size = 3;

    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < (size); row++) {
            for (int col = 0; col < (size); col++) {
                field[row][col] = ' ';
            }
        }
        System.out.println("Field initialized");
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
}