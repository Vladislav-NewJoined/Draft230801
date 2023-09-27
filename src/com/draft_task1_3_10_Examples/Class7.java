package com.draft_task1_3_10_Examples;
//источник: https://ru.hexlet.io/qna/java/questions/kak-obratitsya-k-peremennoy-klassa-java


public class Class7 {
    public String name = "Sasha";
    private String mail = "Sasha@mail.ru";

    public Class7() {
        this.name = name;
        this.mail = mail;
    }

    public String getMail() {
        return mail;

    }
}
