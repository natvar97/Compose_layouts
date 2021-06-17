package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme

open class DescriptionActivity(title : String , route : String) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DescriptionPage()
                }
            }
        }
    }
}

@Composable
fun DescriptionPage() {
    BoxWithConstraints {

        val constraints = MainConstraints()

        ConstraintLayout(constraints) {
            Image(
                painter = painterResource(id = R.drawable.nature_girl),
                contentDescription = null,
                modifier = Modifier
                    .layoutId("image_main"),
                contentScale = ContentScale.FillHeight
            )
            Card(
                backgroundColor = Color.White,
                elevation = 10.dp,
                border = BorderStroke(2.dp, color = Color.Cyan),
                shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .layoutId("card")
            ) {
                BoxWithConstraints {
                    val cardConstraints = CardConstraints()

                    ConstraintLayout(cardConstraints) {
                        Text(
                            text = "Widen your World",
                            modifier = Modifier
                                .fillMaxWidth()
                                .layoutId("tv_widen_world"),
                            color = Color.DarkGray,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "It is all about the Nature and Environment fill with us and meditate your self with your soul.",
                            modifier = Modifier
                                .width(300.dp)
                                .layoutId("tv_description"),
                            color = Color.Gray,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = {},
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .layoutId("fab"),
                backgroundColor = Color.Magenta,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_clock),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = null,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }

        }
    }

}


private fun CardConstraints(): ConstraintSet {
    return ConstraintSet {
        val tvWidenWorld = createRefFor("tv_widen_world")
        val tvDescription = createRefFor("tv_description")

        constrain(tvWidenWorld) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = 40.dp)
            height = Dimension.wrapContent
        }

        constrain(tvDescription) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(tvWidenWorld.bottom, margin = 30.dp)
            height = Dimension.wrapContent
        }

    }
}

private fun MainConstraints(): ConstraintSet {


    return ConstraintSet {
        val imageMain = createRefFor("image_main")
        val card = createRefFor("card")
        val fab = createRefFor("fab")

        constrain(imageMain) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            this.width = Dimension.wrapContent
            this.height = Dimension.value(400.dp)
        }

        constrain(card) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = 350.dp)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.value(400.dp)
        }

        constrain(fab) {
            end.linkTo(parent.end, margin = 10.dp)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Compose_layout_practice_140621Theme {
        DescriptionPage()
    }
}