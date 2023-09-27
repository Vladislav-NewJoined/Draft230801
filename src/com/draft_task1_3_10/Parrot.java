package com.draft_task1_3_10;

// отсюда: https://ru.stackoverflow.com/questions/720307/%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D1%8C-%D0%BD%D0%BE%D0%BC%D0%B5%D1%80-%D0%B4%D0%BB%D1%8F-%D0%BA%D0%B0%D0%B6%D0%B4%D0%BE%D0%B3%D0%BE-%D0%B2%D1%8B%D0%B7%D0%BE%D0%B2%D0%B0-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0

public class Parrot extends Draft_Task1_3_10_4{

    /**
     * Счетчик
     */
    public int callCounter = 0;

    /**
     * Увеличивает и выводит счетчик
     */
    public void countCall() {
        callCounter++;
        System.out.println(callCounter);
    }
}
