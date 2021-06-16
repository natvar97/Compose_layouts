package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_layout_practice_140621.model.PlaceDetails
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter

class TopDestinationsListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TopDestinationsList()
                }
            }
        }
    }
}

@Composable
fun TopDestinationsList() {

    val placeDetailsList = listOf<PlaceDetails>(
        PlaceDetails("Florence", "Italy", "276", (R.drawable.image1)),
        PlaceDetails("Istanbul", "Turkey", "342", R.drawable.image2),
        PlaceDetails("London", "United Kingdom", "261", R.drawable.image3),
        PlaceDetails("Venice", "Italy", "146", R.drawable.image4),
        PlaceDetails("Paris", "France", "247", R.drawable.image5),
        PlaceDetails("Washington DC", "United States", "236", R.drawable.image6),
        PlaceDetails("Miami", "United States", "243", R.drawable.image7),
        PlaceDetails("Los Angelus", "UnitedStates", "210", R.drawable.image8),
        PlaceDetails("Abudhabi", "UAE", "340", R.drawable.image10),
        PlaceDetails("Mumbai", "India", "400", R.drawable.open_hotel)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        backgroundColor = Color.Cyan
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Top Destinations",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )
                    )
                }



                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .fillParentMaxHeight(),
                    backgroundColor = Color.White,
                    elevation = 10.dp,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .fillParentMaxHeight()
                            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                    ) {
                        items(items = placeDetailsList , itemContent = { placeDetails ->
//                        val index = placeDetailsList.indexOf(placeDetails)
                            DestinationItemLayout(placeDetails = placeDetails)
                            Spacer(modifier = Modifier.height(10.dp))

                        })
                    }
                }

            }
        }

    }


}

@Composable
fun DestinationItemLayout(placeDetails: PlaceDetails) {

    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = rememberGlidePainter( placeDetails.image),
                contentDescription = null,
                modifier = Modifier
                    .width(140.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = placeDetails.state,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = placeDetails.country,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = placeDetails.hotels,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "hotels",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                }

            }

            Image(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterVertically)
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Compose_layout_practice_140621Theme {
        TopDestinationsList()
    }
}

@Preview
@Composable
fun DestinationItemLayoutPreview() {
    Compose_layout_practice_140621Theme {
        val placeDetails = PlaceDetails(
            "Mumbai",
            "India",
            "350",
            R.drawable.open_hotel
        )
        DestinationItemLayout(placeDetails)
    }
}