package com.draft_task1_3_10_Examples;

public class Class15_Parrot {
    /**
     * Счетчик
     */
    public int callCounter = 0;

    /**
     * Увеличивает и выводит счетчик
     */
    public void countCall() {
        for (int i = 0; i < 4; i++) {
            System.out.println(callCounter);
            callCounter++;
        }

    }
}
