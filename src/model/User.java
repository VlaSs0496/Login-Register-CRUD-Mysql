package model;

public class User {
    
    private int id;
    private String nameUser;
    private String password;
    private String name;
    private String email;
    private String last_Sesion;
    private int idType_user;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_Sesion() {
        return last_Sesion;
    }

    public void setLast_Sesion(String last_Sesion) {
        this.last_Sesion = last_Sesion;
    }

    public int getIdType_user() {
        return idType_user;
    }

    public void setIdType_user(int idType_user) {
        this.idType_user = idType_user;
    }

    
}
