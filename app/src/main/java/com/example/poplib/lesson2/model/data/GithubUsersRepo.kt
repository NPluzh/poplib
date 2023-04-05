package com.example.poplib.lesson2.model.data

class GithubUsersRepo { // репозиторий с данными
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers() : List<GithubUser>{
        return repositories
    }
}