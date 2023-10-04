package com.example.emploisetudiants.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.emploisetudiants.Message
import com.example.emploisetudiants.Offer
import com.example.emploisetudiants.OfferDetailsSample
import com.example.emploisetudiants.OfferList
import com.example.emploisetudiants.component.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferDetails(offerID: String?, navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Back", true)
        }, content = { padding ->
            val offers = OfferList.offerListSample
            val offer = offers.find { offer: Offer ->  offer.title == offerID}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Titre: ${offer?.title}", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 20.dp))
                Text(text = "Lieu: ${offer?.location}")
                Text(text = "Salaire: ${offer?.salary}")
                Text(text = "Type de contrat: ${offer?.contractType}")
                Text(text = "Détails du poste: ${OfferDetailsSample.details}", modifier = Modifier.padding(top = 10.dp))
            }
        }
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferDetailsPreview() {
    Scaffold(
        topBar = {
            val navController = rememberNavController()
            CustomTopAppBar(navController, "Back", true)
        }, content = { padding ->
            val offers = OfferList.offerListSample
            val offer = offers.find { offer: Offer ->  offer.title == "Dev C++"}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Titre: ${offer?.title}", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 50.dp))
                Text(text = "Lieu: ${offer?.location}")
                Text(text = "Salaire: ${offer?.salary}")
                Text(text = "Type de contrat: ${offer?.contractType}")
                Text(text = "Détails du poste: ${OfferDetailsSample.details}", modifier = Modifier.padding(top = 10.dp))
            }
        }
    )
}

