package com.android.starwarscatapp.database

import androidx.lifecycle.LiveData

class UserRepository(private val dao: Dao) {
    val  readAllData: LiveData<List<User>> = dao.readAllData()
    suspend fun addUser(user: User){
        dao.addUser(user)
    }
}