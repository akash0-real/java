package streamline_api;

import java.util.Arrays;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Integer> one = Arrays.asList(1,2,3,4,5,6,7,8,9);
        one.stream()
            .filter(n -> n%2 == 1)
            .sorted()
            .map(n -> n*2)
            .forEach(n -> System.out.println(n));
       


    }
}
