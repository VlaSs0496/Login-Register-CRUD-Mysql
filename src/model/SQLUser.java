
package model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import view.viewRegister;

public class SQLUser {
    
    public boolean register(User user){
        Conectar con = new Conectar();
        PreparedStatement ps = null;
        
        try {
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("insert into usuario (nombreUsuario,contraseña,nombre,correo,idTipo_usuario) values (?,?,?,?,?)");
            ps.setString(1, user.getNameUser());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getIdType_user());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
