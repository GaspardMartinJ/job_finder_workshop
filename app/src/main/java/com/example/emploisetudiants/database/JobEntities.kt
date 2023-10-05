package com.example.emploisetudiants.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DBUsersTable: Table<DBUsersEntity>("USERS") {

    val id = int("id").primaryKey().bindTo { it.id }
    val title = varchar("username").bindTo { it.username }
    val done = varchar("password").bindTo { it.password }

}

interface DBUsersEntity: Entity<DBUsersEntity> {

    companion object : Entity.Factory<DBUsersEntity>()

    val id: Int
    val username: String
    val password: String

}