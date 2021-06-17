package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme

open class MainActivity(title : String , route : String) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    BoxWithConstraints {

        val constraints = if (minWidth < 600.dp) {
            decoupledLayout(16.dp)
        } else {
            decoupledLayout(32.dp)
        }

        ConstraintLayout(constraints) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background Image",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.8f)
                    .layoutId("background_image"),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
            )

            Text(
                text = "Ahmedabad , India",
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId("city_name"),
                fontStyle = androidx.compose.ui.text.font.FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            )

            Text(
                text = "Explore It!",
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId("tv_explore"),
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = FontFamily.Serif,
                fontWeight = Bold
            )

            Text(
                text = "This is a window of old Village House and we explore it here.",
                modifier = Modifier
                    .width(250.dp)
                    .layoutId("tv_details"),
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontWeight = Light
            )

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                modifier = Modifier
                    .width(300.dp)
                    .layoutId("btn_get_started"),
                shape = RoundedCornerShape(5.dp),
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    fontWeight = Normal
                )
            }

            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = Medium,
                modifier = Modifier.layoutId("tv_already_register")
            )

            Text(
                text = "SignIn",
                fontSize = 16.sp,
                color = Color.Cyan,
                fontWeight = Bold,
                modifier = Modifier.layoutId("tv_signin")
            )

        }
    }


}

private fun decoupledLayout(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("background_image")
        val cityName = createRefFor("city_name")
        val tvExplore = createRefFor("tv_explore")
        val tvDetails = createRefFor("tv_details")
        val btnGetStarted = createRefFor("btn_get_started")
        val alreadyRegiter = createRefFor("tv_already_register")
        val tvSignIn = createRefFor("tv_signin")

        constrain(image) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }

        constrain(cityName) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }

        constrain(tvExplore) {
            top.linkTo(cityName.bottom, margin = 50.dp)
            start.linkTo(cityName.start)
        }

        constrain(tvDetails) {
            top.linkTo(tvExplore.bottom, margin = 10.dp)
            start.linkTo(tvExplore.start)
        }

        constrain(btnGetStarted) {
            bottom.linkTo(parent.bottom, margin = 100.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(alreadyRegiter){
            start.linkTo(btnGetStarted.start, margin = 20.dp)
            top.linkTo(btnGetStarted.bottom)
            bottom.linkTo(parent.bottom)
        }

        constrain(tvSignIn) {
            start.linkTo(alreadyRegiter.end)
            end.linkTo(btnGetStarted.end,margin = 20.dp)
            bottom.linkTo(alreadyRegiter.bottom)
            top.linkTo(alreadyRegiter.top)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_layout_practice_140621Theme {
        HomePage()
    }
}