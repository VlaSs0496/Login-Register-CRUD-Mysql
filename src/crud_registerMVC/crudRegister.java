package crud_registerMVC;

import controler.Controller;
import model.SQLUser;
import model.User;
import view.viewRegister;

public class crudRegister {

    public static void main(String[] args) {
        
        viewRegister viewR = new view.viewRegister();
        User user = new User();
        SQLUser sqlUser = new SQLUser();
        Controller controller = new Controller(viewR,user,sqlUser);
        
        controller.star();
        viewR.setVisible(true);
    }
    
}
