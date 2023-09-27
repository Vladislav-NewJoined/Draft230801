package com.draft_task1_3_10_Examples;
//источник: https://ru.hexlet.io/qna/java/questions/kak-ispolzovat-peremennuyu-iz-drugogo-klassa-java

public class Class6 {
    public static void main(String[] args) {
        Class5 class5 = new Class5();
        System.out.println(class5.name);
        System.out.println(class5.getMail());

    }
}
