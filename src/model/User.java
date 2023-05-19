package model;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String fullName;
    private Integer role;
    public User(){}

    public User(int id, String userName, String passWord, String phone, String fullName, Integer role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.fullName = fullName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
