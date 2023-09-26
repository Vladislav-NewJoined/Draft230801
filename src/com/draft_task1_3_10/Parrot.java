package com.draft_task1_3_10;

public class Parrot extends Draft_Task1_3_10_4{

    /**
     * Счетчик
     */
    private int callCounter = 0;

    /**
     * Увеличивает и выводит счетчик
     */
    private void countCall() {
        callCounter++;
        System.out.println(callCounter);
    }
}
