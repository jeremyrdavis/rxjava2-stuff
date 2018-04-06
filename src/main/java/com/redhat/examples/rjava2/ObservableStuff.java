package com.redhat.examples.rjava2;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableStuff {

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

/*
    just(words);

    fromIterable(words);

    fromIterableZipWith(words);

    fromIterableFlatMapZipWith(words);

    fromIterableFlotMapZipWithDistinct(words);

*/

    fromIterableFlatMapZipWithDistinctSorted(words);


  }

  static void fromIterableFlatMapZipWithDistinctSorted(List<String> words){
    System.out.println("fromIterableFlatMapZipWithDistinctSorted");
    Observable.fromIterable(words)
      .flatMap(word -> Observable.fromArray(word.split("")))
      .distinct()
      .sorted()
      .zipWith(Observable.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string))
      .subscribe(System.out::println);
  }

  static void fromIterableFlotMapZipWithDistinct(List<String> words){
    System.out.println("fromIterableFlotMapZipWithDistinct");
    Observable.fromIterable(words)
      .flatMap(word -> Observable.fromArray(word.split("")))
      .distinct()
      .zipWith(Observable.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string))
      .subscribe(System.out::println);
  }

  static void fromIterableFlatMapZipWith(List<String> words) {
    System.out.println("fromIterableFlatMapZipWith");
    Observable.fromIterable(words)
      .flatMap(word -> Observable.fromArray(word.split("")))
      .zipWith(Observable.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string))
      .subscribe(System.out::println);
  }

  static void fromIterableZipWith(List<String> words) {
    System.out.println("fromIterableZipWith");
    Observable.fromIterable(words)
      .zipWith(Observable.range(1, Integer.MAX_VALUE), (string, count) -> String.format("%2d. %s", count, string))
      .subscribe(System.out::println);
  }

  static void range() {
    System.out.println("range()");
    Observable.range(1, 5).subscribe(System.out::println);
  }

  static void fromIterable(List<String> words) {
    System.out.println("fromIterable");
    Observable.fromIterable(words).subscribe(System.out::println);
  }

  static void just(List<String> words) {
    System.out.println("Just");
    Observable.just(words).subscribe(System.out::println);
  }


}
