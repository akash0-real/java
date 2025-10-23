package streamline_api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Begin {
    public static void main(String[] args) {
        List<Integer> one = Arrays.asList(1,5,6,7,2,3,2,1,10,23,434,12,34,78);

        List <String> two = Arrays.asList("Akash","Ayush","Max","Lewis","Carlos","Lando","Oscar");

        //Printing even numbers!!
        List<Integer> even = one.stream().filter(n -> n%2==0)
                                .collect(Collectors.toList());
        System.out.println(even);
        
        //numbers greater than 10!!
        List<Integer> greater = one.stream()
                                    .filter(n-> n>10)
                                    .collect(Collectors.toList());
        System.out.println(greater);

        //String starting with A!!

        List<String> A = two.stream().filter(n -> n.startsWith("A"))
                            .collect(Collectors.toList());
        System.out.println(A);

        //printing all in upper case!!
        List<String> upper = two.stream().map(String::toUpperCase)
                                .collect(Collectors.toList());
        System.out.println(upper);

        //Sorting the list alphabetically!!
        List <String> sort = two.stream().sorted()
                                .collect(Collectors.toList());
        System.out.println(sort);

        //sum of all using reduce!!

        int sum = one.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);

        //maximum value in the string!!
        Optional<Integer> max = one.stream().max(Integer::compare);
        System.out.println(max);

        //Minimum value in the string!!

        Optional <Integer> min = one.stream().min(Integer::compare);
        System.out.println(min);

        //Finding first element in the String!!

        Optional<Integer> first = one.stream().findFirst();
        System.out.println(first);

        //checking if an element is greater than 100!!

        boolean check = one.stream().anyMatch(n -> n>100);
        System.out.println(check);
    }
}
