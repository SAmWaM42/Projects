import javax.swing.*;
import java.awt.*;

public class welcomepage {

    JFrame frame;
    JLabel message;

    public welcomepage() {
       frame=new JFrame();
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new GridBagLayout());
       GridBagConstraints cons=new GridBagConstraints();
       message= new JLabel("welcome");
       message.setFont(new Font("Ariel", 0, 45));
       cons.anchor=GridBagConstraints.NORTHWEST;
       frame.add(message,cons);

      
    
       frame.setSize(400,400);
       
     
        
         
       

    }

   

}
