package com.draft_task1_3_10;

import java.util.Scanner;

//закончил видео мин 11 54
public class X0Game {
    FieldX0 gameField;
    Scanner scanner = new Scanner (System.in);
    char whoMakeNextTurn;

    void setupNewGame() {
        System.out.println("Will play new game");
        this.gameField = new FieldX0();
        this.gameField.initField();
    }
    void play() {
        this.setupNewGame();
        System.out.print("Who will make first turn: ");
//        String next = this.scanner.next();
//        char first = next.charAt(0);
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == '0') {
            this.whoMakeNextTurn = first;
        }

    }
}
