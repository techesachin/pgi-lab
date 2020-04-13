package com.logical.java;

public class Demo10 {

    public static String getWishMessage(String language) {
        String message = null;
        if (language.equalsIgnoreCase("Hindi")) {
            message = "Nmaskar";
        } else if (language.equalsIgnoreCase("English")) {
            message = "Good morning";
        } else if (language.equalsIgnoreCase("Urdu")) {
            message = "Urdu me  morning";
        } else {
            message = "Good morning";
        }

        return message;
    }

    public static int add() {
        int a = 0;

        return a;
    }

    public static void main(String[] args) {

        final String hindiMessagee = getWishMessage("Hindi");
        System.out.println(hindiMessagee);

        final String english = getWishMessage("English");
        System.out.println(english);


    }
}