package lambda_fn;
public class Second {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i=0;i<5;i++){
                System.out.println("hello");
                System.out.println("byee!!");
            }
        });
        thread.start();
    }
}
class first implements Runnable{
    @Override
    public void run(){
        for(int i =0;i<5;i++){
            System.out.println("akash");
            System.out.println("byee!");
        }
    }
}
