import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;

class first {
    JFrame jframe;
    JTextField name, email;
    JPasswordField password;
    JButton button;

    public first() {
        jframe = new JFrame();
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setSize(500, 500);
        jframe.setLocationRelativeTo(null);
        jframe.setTitle("REGISTRATION FORM");
        jframe.setVisible(true);

        JLabel namelabel = new JLabel("NAME:");
        namelabel.setBounds(20, 20, 40, 30);
        jframe.add(namelabel);

        name = new JTextField();
        name.setBounds(110, 20, 150, 30);
        jframe.add(name);

        JLabel emaillabel = new JLabel("EMAIL:");
        emaillabel.setBounds(20, 70, 40, 30);
        jframe.add(emaillabel);

        email = new JTextField();
        email.setBounds(110, 70, 150, 30);
        jframe.add(email);

        JLabel passlabel = new JLabel("PASSWORD:");
        passlabel.setBounds(20, 120, 80, 30);
        jframe.add(passlabel);

        password = new JPasswordField();
        password.setBounds(110, 120, 150, 30);
        jframe.add(password);

        button = new JButton("SUBMIT");
        button.setBounds(110, 170, 100, 30);
        jframe.add(button);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

    }

    void registerUser() {
        String Name = name.getText();
        String Email = email.getText();
        String Password = new String(password.getPassword());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "shubham@1510");
            PreparedStatement ps = con.prepareStatement("insert into uesr (name,email,password) values (?,?,?)");

            ps.setString(1, Name);
            ps.setString(2, Email);
            ps.setString(3, Password);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(jframe, "Register Successful");
            } else {
                JOptionPane.showMessageDialog(jframe, "Try Again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args) {
        first f = new first();
    }
}
