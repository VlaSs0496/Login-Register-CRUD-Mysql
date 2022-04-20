package crud_registerMVC;

import controler.Controller;
import model.SQLUser;
import model.User;
import view.Main;
import view.Login;
import view.viewRegister;

public class crudRegister {

    public static void main(String[] args) {
        
       
        Main mainL = new view.Main();
        Login loginR = new view.Login();
        viewRegister viewR = new view.viewRegister();
        User user = new User();
        SQLUser sqlUser = new SQLUser();
        Controller controller = new Controller(loginR,mainL,viewR,user,sqlUser);
        
        
        controller.star();
        mainL.setVisible(true);
    }
    
}
