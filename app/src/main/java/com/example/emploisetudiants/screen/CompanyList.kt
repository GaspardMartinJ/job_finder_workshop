package com.example.emploisetudiants.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.emploisetudiants.Message
import com.example.emploisetudiants.Offer
import com.example.emploisetudiants.OfferList
import com.example.emploisetudiants.R
import com.example.emploisetudiants.SampleData
import com.example.emploisetudiants.ui.theme.EmploisEtudiantsTheme

@Composable
fun MessageCard(msg: Message, navController: NavHostController) {
    // We keep track if the message is expanded or not in this variable
    var isExpanded by remember { mutableStateOf(false) }
    // surfaceColor will be updated gradually from one color to the other
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        label = "",
    )
    Column (modifier = Modifier.padding(3.dp)) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 1.dp,
            // surfaceColor color will be changing gradually from primary to surface
            color = surfaceColor,
            // animateContentSize will change the Surface size gradually
            modifier = Modifier
                .animateContentSize()
                .padding(vertical = 3.dp)
                .fillMaxWidth()
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_picture),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = msg.author,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    val offerNumber = msg.body
                    Text(
                        text = "$offerNumber offres disponibles",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { isExpanded = !isExpanded }
                )
            }
        }
        val offers = OfferList.offerListSample
        if (isExpanded) {
            offers.forEach { offer ->
                OfferItem(offer, navController)
            }
        }
    }
}

@Composable
fun OfferItem(offer: Offer, navController: NavHostController) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 1.dp,
        // surfaceColor color will be changing gradually from primary to surface
        color = MaterialTheme.colorScheme.surface,
        // animateContentSize will change the Surface size gradually
        modifier = Modifier
            .animateContentSize()
            .padding(1.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = {
                navController.navigate("OfferDetails/${offer.title}")
            }) {
                Text(text = "Titre: ${offer.title}", fontWeight = FontWeight.Bold)
            }
            Text(text = "Lieu: ${offer.location}")
            Text(text = "Salaire: ${offer.salary}")
            Text(text = "Type de contrat: ${offer.contractType}")
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    EmploisEtudiantsTheme {
        Surface {
            MessageCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!\n test"),
                navController = rememberNavController()
            )
        }
    }
}

@Composable
fun CompanyList(messages: List<Message>, navController: NavHostController) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message, navController)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    EmploisEtudiantsTheme {
        CompanyList(SampleData.conversationSample, navController = rememberNavController())
    }
}