////закончил видео мин: 25 43 строка 78
////проверять с мин сначала 35 52 потом 37 06
////когда заново начал с мин 16 39
//
//
//package com.draft_task1_3_10;
//
//public class Draft_Task1_3_10_1_Pishem_krestiki_noliki {
//    public static void main(String[] args) {
//        System.out.println("""
//                Задание:\s
//                1. Напишите сами крестики-нолики, не подглядывая в наш код.
//
//                Решение:\s""");
//
////        FieldXO fieldX0 = new FieldXO();
////        fieldX0.initField();
////        fieldX0.printField();
//
////        FieldXO game = new FieldXO();
//        X0Game_old game = new X0Game_old();
////        game.setupNewGame();
//        game.play();
//
//
//        }
//}
//
///*pablic */class FieldXO {
//    /*public */char[][] field;
//    int size = 3;
//    int countToWin = 3;
//
//    void initField() {
//        this.field = new char[size][size];
//        for (int row = 0; row < (size); row++) {
//            for (int col = 0; col < (size); col++) {
//                field[row][col] = ' ';
//            }
//        }
//        System.out.println("Field initialized");
//        this.printField();
//    }
//    void printField(){
//        System.out.print("   ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println();
//        for (int row = 0; row < (size); row++) {
//            int rowNum = row + 1;
//            System.out.print(rowNum + " ");
//            for (int col = 0; col < (size); col++) {
//                System.out.print("[" + field[row][col] + "]");
//            }
//            System.out.println();
//        }
//    }
//
//    boolean isPlaceFree(int rowIndex, int colIndex) {
//        if (rowIndex < 0 || rowIndex >= size || colIndex < 0 || colIndex >= size) {
//            return false;
//        } else if (this.field[rowIndex][colIndex] == ' ') {
////            return this.field[rowIndex][colIndex] == ' ';
//            return true;
//        } else {
//            return false;
//
//        }
//        }
////    }
//
//    void setValue(int rowIndex, int colIndex, char value) {
//        this.field[rowIndex][colIndex] = value;
//    }
//
//    boolean isGameOver(char player) {
//        for (int row = 0; row < this.size/* - this.countToWin*/; row++) {
//            for (int col = 0; col < this.size - this.countToWin; col++) {
////                checkRightDirection(row, col, player);
//                if (checkRightDirection(row, col, player)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    boolean checkRightDirection(int row, int col, char player) {
//        if (col > this.size - this.countToWin) {
//            return false;
//        }
//        for (int i = col; i < col + this.countToWin; i++) {
//                if (this.field[row][i] != player) {
//                    return false;
//                }
//            }
//        return true;
//        }
//    }
//
//
