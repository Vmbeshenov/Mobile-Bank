package com.vmbeshenov.bank.Authorization

import com.vmbeshenov.bank.TempData.UserAccounts

object UserAccountControl {
    fun checkUser(login: String, password: String): Boolean {
        val loginAccounts = arrayOfNulls<String>(UserAccounts.user_account.size)
        for (i in loginAccounts.indices) {
            loginAccounts[i] = UserAccounts.user_account[i].login
            if (login == loginAccounts[i]) {
                return if (password == UserAccounts.user_account[i].password) {
                    true
                } else break
            }
        }
        return false
    }
}