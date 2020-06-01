package com.diploma.bank.TempData;

public class UserAccounts {

    private String login;
    private String password;

    public static UserAccounts[] user_account = {
            new UserAccounts("admin", "admin"),
            new UserAccounts("user", "user"),
            new UserAccounts("", "")};

    private UserAccounts(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
