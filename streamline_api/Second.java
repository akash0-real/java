package streamline_api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Second {
    public static void main(String[] args) {
        List<Integer> result = Arrays.asList(1,4,5,6,3);
        
        List<Integer> sum = result.stream()
            .filter(n -> n>5)
            .collect(Collectors.toList());            

        System.out.println(sum);

        Optional <Integer> one = result.stream().findFirst();
        System.out.println(one);
        Optional <Integer> two = result.stream().findAny();
        System.out.println(two);

        long count = result.stream().count();
        System.out.println(count);

        int third = result.stream().reduce(0, (a,b) -> a+b);
        System.out.println(third);
    }
}
