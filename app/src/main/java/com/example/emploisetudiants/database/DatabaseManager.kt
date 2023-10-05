package com.example.emploisetudiants.database

import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {

    // config
    private val hostname = "217.128.62.147"
    private val databaseName = "Job_finder"
    private val username = "sa"
    private val password = "Azerty1+"

    // database
    private val ktormDatabase: Database

    init {
        val jdbcUrl = "jdbc:sqlserver://$hostname:1433/$databaseName?user=$username&password=$password&useSSL=false"
        //ktormDatabase = Database.connect(jdbcUrl)
        ktormDatabase = Database.connect(
            url = "jdbc:sqlserver://$hostname:1433;databaseName=$databaseName",
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            user = username,
            password = password,
        )
    }

    fun getAllUsers(): List<DBUsersEntity> {
        return ktormDatabase.sequenceOf(DBUsersTable).toList()
    }

    fun getUser(id: Int): DBUsersEntity? {
        return ktormDatabase.sequenceOf(DBUsersTable).toList()
            .firstOrNull { it.id == id }
    }


}