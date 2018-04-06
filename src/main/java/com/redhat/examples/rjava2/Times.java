package com.redhat.examples.rjava2;


import io.reactivex.Observable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Times {

  private static long start = System.currentTimeMillis();

  public static Boolean isSlowTickTime(){
    return(System.currentTimeMillis() - start) % 30_00 >= 15_00;
  }

  public static void main(String[] args){

    Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
    Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

    Observable<Long> clock = Observable.merge(
      slow.filter(tick -> isSlowTickTime()),
      fast.filter(tick -> !isSlowTickTime())
    );

    clock.subscribe(tick -> System.out.println(new Date()));

    try {
      Thread.sleep(60_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
