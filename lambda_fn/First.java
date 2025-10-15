package lambda_fn;

public class First {
    public static void main(String[] args) {
        String name = "Akash";
        int age = 19;
        MyInterface one = (a,b) -> {
            System.out.println("My name is " + a);
            System.out.println("My age is " + age);
        };
        one.msg(name, age);
    }
}

@FunctionalInterface
interface MyInterface{
    public void msg(String name, int age);
}
