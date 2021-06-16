package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose_layout_practice_140621.model.HotelDetails
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter

class StateWiseHotelList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainStateLayout()
                }
            }
        }
    }
}

@Composable
fun MainStateLayout() {

    val hotelDetailsList = listOf(
        HotelDetails(
            "Emirates Palace, Abu Dhabi",
            "$2000",
            "Best",
            "9.6",
            "5",
            "500000",
            R.drawable.emirates_palace
        ),
        HotelDetails(
            "DoubleTree By Hilton Hotel",
            "$400",
            "Better",
            "8.6",
            "5",
            "585",
            R.drawable.double_tree_by_hilton
        ),
        HotelDetails(
            "Hyatt Regency Hotel",
            "$1000",
            "Best",
            "8.5",
            "5",
            "901",
            R.drawable.hyatt_regency
        ),
        HotelDetails(
            "Crowne Plaza Hotel",
            "$600",
            "Good",
            "8.5",
            "5",
            "204",
            R.drawable.crowne_plaze
        ),
        HotelDetails(
            "Renaissance Hotel",
            "$300",
            "Very Good",
            "8.7",
            "5",
            "166",
            R.drawable.renaissance_hotel
        ),
        HotelDetails("Novotel Hotel", "$400", "Good", "8.3", "5", "934", R.drawable.novotel_hotel),
        HotelDetails(
            "Radisson Blu Hotel",
            "$700",
            "Best",
            "8",
            "5",
            "554",
            R.drawable.radisson_blu_hotel
        ),
        HotelDetails(
            "Fortune Landmark Hotel ",
            "$400",
            "Average",
            "8.4",
            "5",
            "403",
            R.drawable.fortune_landmark_hotel
        ),
        HotelDetails(
            "Courtyard By Marriott Hotel",
            "$600",
            "Good",
            "8.7",
            "5",
            "18",
            R.drawable.courtyard_by_marriott_hotel
        ),
    )

    val rowCategoryList = listOf<String>(
        "Restaurants", "Hotels", "Spa", "Favorite", "Map", "5 star", "4 star", "Famous"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        backgroundColor = Color.DarkGray
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .layoutId("lazy_column_hotel_list")
        ) {
            item {

                BoxWithConstraints(
                    modifier = Modifier.fillParentMaxWidth()
                        .fillMaxHeight()
                ) {
                    val constraints = TopConstraints()
                    ConstraintLayout(constraints) {

                        Image(
                            painter = rememberGlidePainter(request = R.drawable.ahmedabad_image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .layoutId("iv_city"),
                            contentScale = ContentScale.Crop
                        )

                        Row(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillParentMaxWidth().layoutId("row_city"),
                            horizontalArrangement = Arrangement.SpaceEvenly,
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

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Ahmedabad City",
                                    modifier = Modifier.fillMaxWidth(),
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        textAlign = TextAlign.Center
                                    )
                                )

                                Text(
                                    text = "18 - 22 June | 2 Adults",
                                    modifier = Modifier.fillMaxWidth(),
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                )

                            }

                            Image(
                                imageVector = Icons.Rounded.Home,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.White),
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp)
                                    .align(Alignment.CenterVertically),
                            )

                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .fillParentMaxHeight(),
                    backgroundColor = Color.White,
                    elevation = 10.dp,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                ) {

                    LazyRow(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                    ) {
                        items(items = rowCategoryList , itemContent = { category ->
                            RowCategoryListLayout(category = category )
                            Spacer(modifier = Modifier.width(10.dp))
                        })
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    LazyColumn(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .fillParentMaxHeight()
                            .padding(top = 80.dp, start = 10.dp, end = 10.dp)
                    ) {
                        items(items = hotelDetailsList, itemContent = { hotelDetails ->
//                        val index = placeDetailsList.indexOf(placeDetails)
                            HotelLayout(hotel = hotelDetails)
                            Spacer(modifier = Modifier.height(10.dp))

                        })
                    }
                }

            }
        }
    }


}

private fun TopConstraints() : ConstraintSet{
    return ConstraintSet {
        val ivCity = createRefFor("iv_city")
        val rowCity = createRefFor("row_city")

        constrain(ivCity) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(rowCity) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }
}

@Composable
fun RowCategoryListLayout(category: String) {
    Card(
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = category,
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(10.dp)
        )
    }
}


@Composable
fun HotelLayout(hotel: HotelDetails) {
    BoxWithConstraints {

        val constraints = HotelItemConstraints()

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberGlidePainter(request = hotel.hotelImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .layoutId("iv_hotel"),
                    contentScale = ContentScale.Crop
                )

                Image(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.layoutId("iv_favorite"),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Text(
                    text = hotel.hotelName,
                    modifier = Modifier.layoutId("tv_hotel_name"),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = hotel.hotelRent,
                    modifier = Modifier.layoutId("tv_hotel_rent"),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.End
                )

                Row(
                    modifier = Modifier.layoutId("row_rating_review")
                ) {
                    Text(
                        text = hotel.hotelReview,
                        modifier = Modifier.layoutId("tv_hotel_review"),
                        style = TextStyle(
                            color = Color.Cyan,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = hotel.hotelRating,
                        modifier = Modifier.layoutId("tv_hotel_rating"),
                        style = TextStyle(
                            color = Color.Cyan,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "(${hotel.hotelReviewerCount})",
                        modifier = Modifier.layoutId("tv_hotel_reviewer_count"),
                        style = TextStyle(
                            color = Color.Cyan,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        textAlign = TextAlign.Start
                    )
                }

            }
        }


    }
}

private fun HotelItemConstraints(): ConstraintSet {
    return ConstraintSet {
        val ivHotel = createRefFor("iv_hotel")
        val ivFavorite = createRefFor("iv_favorite")
        val tvHotelName = createRefFor("tv_hotel_name")
        val tvHotelRent = createRefFor("tv_hotel_rent")
        val rowRatingReview = createRefFor("row_rating_review")

        constrain(ivHotel) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            height = Dimension.value(200.dp)
        }

        constrain(ivFavorite) {
            end.linkTo(ivHotel.end, margin = 20.dp)
            top.linkTo(ivHotel.top, margin = 20.dp)
        }

        constrain(tvHotelName) {
            start.linkTo(ivHotel.start, margin = 20.dp)
            top.linkTo(ivHotel.top, margin = 20.dp)
        }

        constrain(tvHotelRent) {
            end.linkTo(ivHotel.end, margin = 20.dp)
            bottom.linkTo(ivHotel.bottom, margin = 40.dp)
        }

        constrain(rowRatingReview) {
            top.linkTo(tvHotelRent.bottom, margin = 5.dp)
            end.linkTo(tvHotelRent.end)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Compose_layout_practice_140621Theme {
        MainStateLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun HotelLayoutPreview() {
    Compose_layout_practice_140621Theme {
        val hotel = HotelDetails(
            "Hotel Taj",
            "$500",
            "Best",
            "4.6",
            "5",
            "3600",
            R.drawable.image8
        )
        HotelLayout(hotel)
    }
}

/*
        val value  = remember { mutableStateOf(3.2f) }

                RatingBar(
                    value = value.value,
                    modifier = Modifier
                        .background(Brush.horizontalGradient(listOf(Color.Transparent, Color.Black)) , alpha = 0.0f)
                        .layoutId("hotel_rating_bar"),
                    activeColor = Color.Red,
                    inactiveColor = Color.LightGray,
                    numStars = 5,
                    size = 30.dp,
                    onRatingChanged = {
                        value.value = it
                    },
                    ratingBarStyle = RatingBarStyle.Normal,
                    stepSize = StepSize.HALF,
                    isIndicator = false
                )
 */