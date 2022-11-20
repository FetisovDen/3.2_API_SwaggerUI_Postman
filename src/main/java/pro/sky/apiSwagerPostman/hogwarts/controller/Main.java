package pro.sky.apiSwagerPostman.hogwarts.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long sum = Stream.iterate(1L, a -> a +1) .limit(1_000_000) .reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis()-time);
        System.out.println(sum);
//        long time2 = System.currentTimeMillis();
//        long sum2 = Stream.iterate(1, a -> a +1) .limit(1_000_000) .reduce(0, Integer::sum);
//        System.out.println(System.currentTimeMillis()-time2);
//        System.out.println(sum2);
        long time3 = System.currentTimeMillis();
        long sum4 = Stream.iterate(1, a -> a +1).limit(1_000_000).mapToLong(Integer::longValue).sum();;
        System.out.println(System.currentTimeMillis()-time3);
        System.out.println(sum4);
    }
}
