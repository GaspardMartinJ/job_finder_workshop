package com.example.emploisetudiants

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object SignUp : Routes("SignUp")
    object CompanyList : Routes("CompanyList")
}