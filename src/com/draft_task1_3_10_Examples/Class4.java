package com.draft_task1_3_10_Examples;
//источник: https://ru.hexlet.io/qna/java/questions/kak-ispolzovat-peremennuyu-iz-drugogo-klassa-java

public class Class4 {
    public static void main(String[] args) {
        Class3_from_Hexlet class3 = new Class3_from_Hexlet("Ivan", "Ivan@mail.ru");
        System.out.println(class3.name);
        System.out.println(class3.getMail());

    }
}
