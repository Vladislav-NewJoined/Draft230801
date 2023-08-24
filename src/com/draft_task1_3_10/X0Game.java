package com.draft_task1_3_10;

import java.util.Scanner;

//закончил видео мин 00
public class X0Game {
    FieldX0 gameField;
    Scanner scanner = new Scanner (System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;

    void setupNewGame() {
        System.out.println("Will play new game");
        this.gameField = new FieldX0();
        this.gameField.initField();
    }
    void play() {
        this.setupNewGame();
        System.out.println("Who will make first turn: ");
//        String next = this.scanner.next();
//        char first = next.charAt(0);
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == '0') {
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("I recognizing only X or 0 (zero). So first will be X");
            this.whoMakeNextTurn = 'X';
        }


        while (!gameOver) {
            turn();
            this.gameOver = this.gameField.isGameOver(this.whoMakeNextTurn);
            if (this.whoMakeNextTurn == 'X') {
                this.whoMakeNextTurn = '0';
            } else {
                this.whoMakeNextTurn = 'X';
            }
        }
    }

    void turn() {
        System.out.println(this.whoMakeNextTurn + ", your turn. ");
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

