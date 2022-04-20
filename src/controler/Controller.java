package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.SQLUser;
import model.User;
import view.Main;
import view.Login;
import view.viewRegister;

public class Controller implements ActionListener {

    private viewRegister viewR;
    private Login loginR;
    private Main mainL;
    private User user;
    private SQLUser sqlUser;

    public Controller(Login loginR,Main mainL,viewRegister viewR, User user, SQLUser sqlUser) {
        this.viewR = viewR;
        this.user = user;
        this.sqlUser = sqlUser;
        viewR.btnRegister.addActionListener(this);
    }

    public void star() {
        viewR.setTitle("REGISTER");
        viewR.setLocationRelativeTo(null);
        
    }

    public void clearBox() {
        viewR.jEmail.setText(null);
        viewR.jName2.setText(null);
        viewR.jUser1.setText(null);
        viewR.jPassword.setText(null);
        viewR.jPassword2.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pass = new String(viewR.jPassword.getPassword());
        String pass2 = new String(viewR.jPassword2.getPassword());
        if (e.getSource() == viewR.btnRegister) {
            if (viewR.jUser1.getText().equals("") || pass.equals("") || pass2.equals("") || viewR.jName2.getText().equals("") || viewR.jEmail.getText().equals("")) {
                JOptionPane.showInputDialog(null, "MISS");
            } else {
                if (pass.equals(pass2)) {
                    if (sqlUser.verificationUser(viewR.jUser1.getText()) == 0) {
                        if (sqlUser.verificacionEmail(viewR.jEmail.getText())) {
                            user.setNameUser(viewR.jUser1.getText());
                            user.setPassword(pass);
                            user.setName(viewR.jName2.getText());
                            user.setEmail(viewR.jEmail.getText());
                            user.setIdType_user(2);

                            if (sqlUser.register(user)) {
                                JOptionPane.showConfirmDialog(null, "Successful registration");
                                clearBox();
                            } else {
                                JOptionPane.showConfirmDialog(null, "Error");
                            }
                        }else{
                            JOptionPane.showConfirmDialog(null, "Email error");
                        }
                        
                    } else {
                        JOptionPane.showConfirmDialog(null, "User already exists");
                    }

                } else {
                    JOptionPane.showConfirmDialog(null, "Passwords do not match");
                }
            }
        }
    }
}
