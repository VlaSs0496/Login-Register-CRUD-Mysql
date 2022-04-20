package model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import view.viewRegister;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SQLUser {

    public boolean register(User user) {
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

    public int verificationUser(String user) {
        Conectar con = new Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("select count(id) from usuario where nombreUsuario=?");
            ps.setString(1, user);
            rs = ps.executeQuery();
            
            if (rs.next()){
                return rs.getInt(1);
            }else{
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
    
    public boolean verificacionEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();
    }
    
    
    public boolean loginSesion(User user) {
        Conectar con = new Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("select id,nombreUsuario,contraseña,nombre,idTipo_usuario from usuario where nombreUsuario=?");
            ps.setString(1, user.getNameUser());
            rs = ps.executeQuery();
            
            if (rs.next()){
                if(user.getPassword().equals(rs.getString("contraseña"))){
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("nombre"));
                    user.setIdType_user(rs.getInt("idTipo_usuario"));
                    return true;
                }
            }else{
                JOptionPane.showConfirmDialog(null, "Password error");
                return false;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
