package ru.itis;

public class Main {
    public static void main(String[] args) {
        Settings settings = new Settings();

        System.out.println(settings.getValue("baseUrl"));
        System.out.println(settings.getValue("login"));
        System.out.println(settings.getValue("password"));

//        System.out.println(settings.getBaseUrl());
    }
}
