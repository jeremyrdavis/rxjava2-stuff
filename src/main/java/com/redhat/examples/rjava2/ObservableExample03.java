package com.redhat.examples.rjava2;

import io.reactivex.Observable;

public class ObservableExample03 {

    public static void main(String[] args) {

        System.out.println("Use the range operator to print sequential numbers.  This will be useful in the next example.");

        Observable.range(1, 5).subscribe(System.out::println);

    }
}
