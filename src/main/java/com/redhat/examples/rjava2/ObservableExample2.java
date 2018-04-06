package com.redhat.examples.rjava2;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableExample2 {

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

        System.out.println("Use the fromIterable operator to iterate over the List<String> an print individual values.");

        Observable.fromIterable(words).subscribe(System.out::println);

    }

}
