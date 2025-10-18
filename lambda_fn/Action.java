package lambda_fn;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Action {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

    }
}

class MyFrame extends JFrame{
    JButton button = new JButton("my button");
    JButton button1 = new JButton("my button2");
    MyFrame(){
        button.setBounds(200,200,200,200);
        this.add(button);
        button.addActionListener(
            
            (e) -> System.out.println("you clicked a button one!")     
        );

        button1.setBounds(300,300,300,300);
        button1.addActionListener(
            
            (e) -> System.out.println("you clicked a button second!")     
        );
        this.add(button1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);

    }
    
}

interface ActionListener extends EventListener{
    void acionPerformed(ActionEvent e);
}