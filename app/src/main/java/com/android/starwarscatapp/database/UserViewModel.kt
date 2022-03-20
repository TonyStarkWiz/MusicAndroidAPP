package com.android.starwarscatapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val dao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(dao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        val launch = viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}