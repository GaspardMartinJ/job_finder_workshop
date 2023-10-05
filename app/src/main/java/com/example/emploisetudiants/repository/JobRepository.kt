package com.example.emploisetudiants.repository

import com.example.emploisetudiants.entities.USERS
import com.example.emploisetudiants.entities.COMPANIES
import com.example.emploisetudiants.entities.OFFERS

interface JobRepository {
    fun getAllUsers(): List<USERS>
    fun getUser(id: Int): USERS?
    fun getAllCompanies(): List<COMPANIES>
    fun getCompany(id: Int): COMPANIES?
    fun getAllOffers(): List<OFFERS>
    fun getOffer(id: Int): OFFERS?
}