package com.example.emploisetudiants.repository

import com.example.emploisetudiants.database.DatabaseManager
import com.example.emploisetudiants.entities.USERS
import com.example.emploisetudiants.entities.COMPANIES
import com.example.emploisetudiants.entities.OFFERS

class MsSQLRepository : JobRepository {

    private val database = DatabaseManager()

    override fun getAllUsers(): List<USERS> {
        return database.getAllUsers()
            .map { USERS(it.id, it.username, it.password) }
    }

    override fun getUser(id: Int): USERS? {
        return database.getUser(id)
            ?.let { USERS(it.id, it.username, it.password) }
    }

    override fun getAllCompanies(): List<COMPANIES> {
        TODO("Not yet implemented")
    }

    override fun getCompany(id: Int): COMPANIES? {
        TODO("Not yet implemented")
    }

    override fun getAllOffers(): List<OFFERS> {
        TODO("Not yet implemented")
    }

    override fun getOffer(id: Int): OFFERS? {
        TODO("Not yet implemented")
    }
}