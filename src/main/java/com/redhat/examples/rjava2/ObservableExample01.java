package com.redhat.examples.rjava2;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableExample01 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dogs"
        );

        System.out.println("Use the Just operator to print out only the words");

        Observable.just(words).subscribe(System.out::println);

    }
}
