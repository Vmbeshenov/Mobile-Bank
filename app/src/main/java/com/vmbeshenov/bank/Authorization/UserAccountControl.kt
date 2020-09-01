package com.vmbeshenov.bank.Authorization

import com.vmbeshenov.bank.TempData.UserAccounts

object UserAccountControl {
    fun CheckUser(login: String, password: String): Boolean {
        val login_accounts = arrayOfNulls<String>(UserAccounts.user_account.size)
        for (i in login_accounts.indices) {
            login_accounts[i] = UserAccounts.user_account[i].login
            if (login == login_accounts[i]) {
                return if (password == UserAccounts.user_account[i].password) {
                    true
                } else break
            }
        }
        return false
    }
}