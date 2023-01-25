import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {


    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPassField = new JPasswordField();

    JLabel userIdLabel = new JLabel("userID:");
    JLabel userPasswrdLabel = new JLabel("Password:");
    JLabel messageLabel  = new JLabel();




    HashMap<String,String> logininfo  = new HashMap<String,String>();

    //Constructor
   Login(HashMap<String,String> loginInfoOriginal){

       //login Hasmap  = loginInfoOriginal : composition
    logininfo = loginInfoOriginal;


    userIdLabel.setBounds(50,100,75,25);
    userPasswrdLabel.setBounds(50,150,75,25);

    messageLabel.setBounds(125,250,250,35);
    messageLabel.setFont(new Font(null, Font.PLAIN,25));

    loginButton.setBounds(125,200,100,25);
    loginButton.setFocusable(false);
    loginButton.addActionListener(this);

    resetButton.setBounds(225,200,100,25);
    loginButton.setFocusable(false);
    resetButton.addActionListener(this);


    userIDField.setBounds(125,100,200,25);
    userPassField.setBounds(125,150,200,25);

    frame.add(loginButton);
    frame.add(resetButton);
    frame.add(userPassField);
    frame.add(userIDField);
    frame.add(userIdLabel);
    frame.add(userPasswrdLabel);
    frame.add(messageLabel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420,420);
    frame.setLayout(null);
    frame.setVisible(true);

   }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()== resetButton){
           userIDField.setText("");
           userPassField.setText("");
       }
       if(e.getSource()==loginButton){
           String userID = userIDField.getText();
           String password = String.valueOf(userPassField.getPassword());  // since use empty field, we use String.valueof(arguement)

           if(logininfo.containsKey(userID)){ // iduser
               if(logininfo.get(userID).equals(password)){
                   messageLabel.setForeground(Color.green);
                   messageLabel.setText("Login successful");
                   frame.dispose();
                   WelcomePage welcomePage = new WelcomePage(userID);  // pass in userID arguments
               }else {
                   messageLabel.setForeground(Color.red);
                   messageLabel.setText("Wrong password");
               }
           }

       }


    }
}
