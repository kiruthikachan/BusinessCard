package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Kiruthika Chan",
                        email = "kiruthikachan3@gmail.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, email: String, modifier: Modifier = Modifier)
{
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        BusinessCardImage()
        Column(modifier = Modifier.padding(top = 24.dp), horizontalAlignment = Alignment.CenterHorizontally)
        { Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
            Spacer(modifier = Modifier.height(4.dp))
        Text (
            text = "Computer Science Student",
            fontSize = 20.sp
        )
            Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = email,
            fontSize = 16.sp
        )}
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Kiruthika Chan",
            email = "kiruthikachan3@gmail.com"
        )
    }
}

@Composable
fun BusinessCardImage() {
    val image = painterResource(R.drawable.profile_picture)
    Image(
        painter = image,
        contentDescription = "Picture",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(400.dp)
    )
}