package com.vmbeshenov.bank.TempData

class UserAccounts private constructor(val login: String, val password: String) {

    companion object {
        var user_account = arrayOf(
                UserAccounts("admin", "admin"),
                UserAccounts("user", "user"),
                UserAccounts("", ""))
    }
}