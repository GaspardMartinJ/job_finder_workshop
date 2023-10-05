package com.example.emploisetudiants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.emploisetudiants.entities.USERS
import com.example.emploisetudiants.repository.JobRepository
import com.example.emploisetudiants.repository.MsSQLRepository
import com.example.emploisetudiants.screen.ScreenMain
import com.example.emploisetudiants.ui.theme.EmploisEtudiantsTheme
import androidx.compose.runtime.mutableStateOf

data class Message(val author: String, val body: String, val logo: String)
data class Offer(val title: String, val location: String, val salary: String, val contractType: String)

val repository: JobRepository = MsSQLRepository()
val data = repository.getAllUsers()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmploisEtudiantsTheme {
                ScreenMain()
            }
        }
    }
}

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            dbTest(repository = repository)
        }
    }
}
 */

@Composable
fun dbTest(repository: JobRepository) {
    // Observe the data using LiveData or State
    val users by observeUsers(repository)

    // Display the data in your Composable
    for (user in users) {
        Text(text = user.username)
    }
}

@Composable
fun observeUsers(repository: JobRepository): State<List<USERS>> {
    val users = remember { mutableStateOf(emptyList<USERS>()) }
    // Perform the database query and update the State when data changes
    LaunchedEffect(repository) {
        val data = repository.getAllUsers()
        users.value = data
    }
    return users
}

