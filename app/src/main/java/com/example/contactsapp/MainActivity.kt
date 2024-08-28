package com.example.contactsapp

import android.content.Intent
import android.net.Uri.parse
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsapp.ui.theme.ContactsAppTheme


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.White,
                                titleContentColor = Color.Black,
                            ),
                            title = {
                                Text("Contacts App")
                            },
                            actions = {
                                val context = LocalContext.current
                                IconButton(onClick = {
                                    val intent = Intent(Intent.ACTION_DIAL)
                                    intent.setData(parse("tel:01222149098"))
                                    context.startActivity(intent)
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_home_24),
                                        contentDescription = "Localized description",
                                        tint = Color.Black
                                    )
                                }
                            },

                            )
                    },
                ) { innerPadding ->
                    ContactsListItems(
                        contacts = DataSource.getContactList(), Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}


@Composable
fun ContactItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

            .clickable(onClick = {

                val intent = Intent(Intent.ACTION_DIAL)
                intent.setData(parse("tel:${contact.number}"))
                context.startActivity(intent)

            })

    ) {
        Image(
            painter = painterResource(id = contact.pictureDrawable),
            contentDescription = "auntie",
            modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                //.width(159.dp)
                .fillMaxSize()
        ) {
            SelectionContainer() {
                Text(
                    text = contact.name,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            SelectionContainer() {
                Text(
                    text = contact.number,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun ContactsListItems(contacts: List<Contact>, modifier: Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 105.dp),
    ) {
        items(contacts) {
            ContactItem(contact = it)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ContactsListItemsPreview() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Small Top App Bar")
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "Localized description"
                        )
                    }
                },

                )
        },
    ) { innerPadding ->
        ContactsListItems(
            contacts = DataSource.getContactList(), Modifier.padding(innerPadding)
        )
    }
}