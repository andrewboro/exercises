package com.example.exercises.java8.lambda;

public class Lambda {

    public static void main(String... args) {
        Greeter greetingLambda = str -> "Hello " + str + "!" + " Nice to see you :)";
        System.out.println(greetingLambda.greet("Andrew"));
    }

}