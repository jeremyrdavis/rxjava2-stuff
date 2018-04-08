package com.redhat.examples.rjava2;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableExample04 {

    public static void main(String[] args){

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

        Observable.fromIterable(words)
                .zipWith(Observable.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);

    }
}
