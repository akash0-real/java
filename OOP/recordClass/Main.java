package OOP.recordClass;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("akash",18,"F1");
        System.out.println(player.name() + player.age() + player.game());
    }
}

record Player(String name,int age,String game){
}
