package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose_layout_practice_140621.model.BedRoomDetails
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter

class UserProfileActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    UserProfileLayout()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun UserProfileLayout() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val bedRoomList = listOf(
            BedRoomDetails("Mahor", "India", "5.0", R.drawable.bedroom1),
            BedRoomDetails("Kothasana", "India", "4.0", R.drawable.bedroom2),
            BedRoomDetails("Deesa", "India", "5.0", R.drawable.bedroom3),
            BedRoomDetails("Vajapur", "India", "4.2", R.drawable.bedroom4),
            BedRoomDetails("Navavas", "India", "4.6", R.drawable.bedroom5),
            BedRoomDetails("Bapsar", "India", "4.3", R.drawable.bedroom6),
            BedRoomDetails("Visnagar", "India", "5.0", R.drawable.bedroom7),
            BedRoomDetails("Patan", "India", "4.8", R.drawable.bedroom8),
            BedRoomDetails("Vadodara", "India", "5.0", R.drawable.bedroom9),
            BedRoomDetails("Ahmedabad", "India", "5.0", R.drawable.bedroom10),
        )

        UserProfileSingle()
        ReviewRow()
        Spacer(modifier = Modifier.height(10.dp))
        BedRoomLazyGridView(list = bedRoomList)

    }

}

@ExperimentalFoundationApi
@Composable
fun BedRoomLazyGridView(list: List<BedRoomDetails>) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        items(count = list.size ) {
            GridItemLayout(bedroom = list[it] , modifier = Modifier.padding(5.dp))
        }
    }

}

@Composable
fun GridItemLayout(bedroom: BedRoomDetails, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
        ) {
            val constraints = GridItemLayoutConstraints()

            ConstraintLayout(constraints) {
                Image(
                    painter = rememberGlidePainter(request = bedroom.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .layoutId("iv_hotel_image"),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = bedroom.countryName,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                        .layoutId("tv_country_name"),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Text(
                    text = bedroom.hotelName,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                        .layoutId("tv_hotel_name"),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Card(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .layoutId("card_review"),
                    shape = CircleShape,
                    backgroundColor = Color.Blue,
                ) {
                    Text(
                        text = bedroom.reviewCount,
                        modifier = Modifier
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)
                            .layoutId("tv_hotel_review_count"),
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    )
                }

            }

        }
    }
}

private fun GridItemLayoutConstraints(): ConstraintSet {
    return ConstraintSet {
        val ivHotelImage = createRefFor("iv_hotel_image")
        val tvCountryName = createRefFor("tv_country_name")
        val tvHotelName = createRefFor("tv_hotel_name")
        val cardReview = createRefFor("card_review")

        constrain(ivHotelImage) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }

        constrain(tvCountryName) {
            start.linkTo(ivHotelImage.start, margin = 20.dp)
            bottom.linkTo(ivHotelImage.bottom, margin = 10.dp)
        }

        constrain(tvHotelName) {
            start.linkTo(tvCountryName.start)
            bottom.linkTo(tvCountryName.top)
        }

        constrain(cardReview) {
            start.linkTo(tvHotelName.start)
            bottom.linkTo(tvHotelName.top)
        }

    }
}

@Composable
fun ReviewRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(horizontal = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Reviews",
            modifier = Modifier.wrapContentWidth(Alignment.Start),
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif
            )
        )

        Text(
            text = "10 total",
            modifier = Modifier.wrapContentWidth(Alignment.Start),
            style = TextStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}

@Composable
fun UserProfileSingle() {
    BoxWithConstraints {
        val constraints = UserProfileSingleConstraints()

        ConstraintLayout(constraints) {
            Image(
                painter = rememberGlidePainter(request = R.drawable.background_profile),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 25.dp))
                    .layoutId("iv_background"),
                contentScale = ContentScale.Crop,
            )

            Card(
                modifier = Modifier.layoutId("card_profile_image"),
                elevation = 10.dp,
                shape = CircleShape,
                border = BorderStroke(3.dp, Color.White),
                backgroundColor = Color.White
            ) {
                Image(
                    painter = rememberGlidePainter(request = R.drawable.uru),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxSize()
                        .layoutId("iv_profile_image"),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .layoutId("column_user_name")
            ) {
                Text(
                    text = "Urvashi Prajapati",
                    modifier = Modifier.wrapContentWidth(Alignment.Start),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Text(
                    text = "Student of Bachelor of Science",
                    modifier = Modifier.wrapContentWidth(Alignment.Start),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }


            Image(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.layoutId("iv_back")
            )

            Image(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.layoutId("iv_menu")
            )

        }

    }
}


private fun UserProfileSingleConstraints(): ConstraintSet {
    return ConstraintSet {
        val ivBackground = createRefFor("iv_background")
        val cardProfileImage = createRefFor("card_profile_image")
        val columnUsername = createRefFor("column_user_name")
        val ivBack = createRefFor("iv_back")
        val ivMenu = createRefFor("iv_menu")

        constrain(ivBackground) {
            start.linkTo(parent.start)
            end.linkTo(parent.start)
            top.linkTo(parent.top)
            width = Dimension.preferredWrapContent
            height = Dimension.value(200.dp)
        }

        constrain(cardProfileImage) {
            start.linkTo(parent.start, margin = 40.dp)
            top.linkTo(parent.top, margin = 150.dp)
            height = Dimension.value(120.dp)
            width = Dimension.value(120.dp)
        }

        constrain(columnUsername) {
            start.linkTo(cardProfileImage.end, margin = 20.dp)
            top.linkTo(ivBackground.bottom, margin = 10.dp)
        }

        constrain(ivBack) {
            start.linkTo(ivBackground.start, margin = 10.dp)
            top.linkTo(ivBackground.top, margin = 20.dp)
        }

        constrain(ivMenu) {
            end.linkTo(ivBackground.end, margin = 10.dp)
            top.linkTo(ivBackground.top, margin = 20.dp)
        }

    }
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    Compose_layout_practice_140621Theme {
        UserProfileLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileSinglePreview() {
    Compose_layout_practice_140621Theme {
        UserProfileSingle()
    }
}

@Preview(showBackground = true)
@Composable
fun GridItemLayoutPreview() {
    Compose_layout_practice_140621Theme {
        val bedroom = BedRoomDetails(
            "Hyatt Regency",
            countryName = "India",
            reviewCount = "8.5/10",
            R.drawable.hyatt_regency
        )
        GridItemLayout(bedroom)
    }
}