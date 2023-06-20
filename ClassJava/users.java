package src.Manager_Score.ClassJava;

public class users {
    private int users_id ;
    private String users_name ;
    private String users_password;
    private int users_age ;
    private String users_gender;
    private String users_fullname;

    public users(int users_id, String users_name, String users_password, int users_age, String users_gender, String users_fullname) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.users_password = users_password;
        this.users_age = users_age;
        this.users_gender = users_gender;
        this.users_fullname = users_fullname;
    }

    public int getUsers_id() {
        return users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public String getUsers_password() {
        return users_password;
    }

    public int getUsers_age() {
        return users_age;
    }

    public String getUsers_gender() {
        return users_gender;
    }

    public String getUsers_fullname() {
        return users_fullname;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public void setUsers_password(String users_password) {
        this.users_password = users_password;
    }

    public void setUsers_age(int users_age) {
        this.users_age = users_age;
    }

    public void setUsers_gender(String users_gender) {
        this.users_gender = users_gender;
    }

    public void setUsers_fullname(String users_fullname) {
        this.users_fullname = users_fullname;
    }
}
