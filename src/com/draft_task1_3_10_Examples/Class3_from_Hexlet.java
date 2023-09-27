package com.draft_task1_3_10_Examples;
//источник: https://ru.hexlet.io/qna/java/questions/kak-ispolzovat-peremennuyu-iz-drugogo-klassa-java


public class Class3_from_Hexlet {
    //    public static void main(String[] args) {
    public String name;
    private String mail;

    public Class3_from_Hexlet(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getMail() {
        return mail;

    }
}
