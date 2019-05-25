package org.interview.preperation.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyExample {

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println(totalElements(list, Utils::isEven));
        System.out.println(totalElements(list, Utils::isOdd));
        System.out.println(totalElements(list, val -> true));
    }

    private static Integer totalElements(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .mapToInt(e -> e)
                .sum();
    }

    static class Utils {
        public static boolean isEven(Integer e) {
            return e % 2 == 0;
        }

        public static boolean isOdd(Integer e) {
            return e % 2 != 0;
        }
    }
}
