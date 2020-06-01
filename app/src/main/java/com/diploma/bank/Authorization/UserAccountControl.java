package com.diploma.bank.Authorization;

import com.diploma.bank.TempData.UserAccounts;

public class UserAccountControl {
    public static boolean CheckUser(String login, String password){
        String[] login_accounts = new String[UserAccounts.user_account.length];
        for (int i = 0; i < login_accounts.length; i++) {
            login_accounts[i] = UserAccounts.user_account[i].getLogin();
            if (login.equals(login_accounts[i])){
                if (password.equals(UserAccounts.user_account[i].getPassword())){
                    return true;
                }
                else break;
            }
        }
        return false;
    }
}
