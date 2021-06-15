package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginMainLayout()
                }
            }
        }
    }
}

@Composable
fun LoginMainLayout() {
    LazyColumn {
        item {
            BoxWithConstraints {

                val constraints = MainConstraints()
                ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.open_hotel),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(
                                    bottomStart = 10.dp,
                                    bottomEnd = 10.dp
                                )
                            )
                            .fillMaxWidth()
                            .layoutId("image_hotel"),
                        colorFilter = ColorFilter.tint(
                            color = Color.DarkGray,
                            blendMode = BlendMode.Difference
                        ),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "SantNagri, Sabarkantha, Gujarat",
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("image_location"),
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )

                    Text(
                        text = "Welcome to...",
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("tv_welcome"),
                        textAlign = TextAlign.Start,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "In this hotel your find the Nature most of and there are lots of trees all over the world. You can find peace here and enjoy the facility of hotel",
                        modifier = Modifier
                            .layoutId("tv_hotel_details"),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Card(
                        modifier = Modifier
                            .layoutId("login_card"),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(20.dp),
                        elevation = 5.dp,
                        border = BorderStroke(1.dp, Color.LightGray)
                    ) {
                        BoxWithConstraints {
                            val cardConstraints = CardConstraints()

                            ConstraintLayout(cardConstraints) {
                                TextEditField(
                                    hintText = "Email",
                                    Icons.Default.Email,
                                    VisualTransformation.None
                                )
                                TextEditField(
                                    hintText = "Password",
                                    imageVector = Icons.Default.Lock,
                                    PasswordVisualTransformation()
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(50.dp)
                            .layoutId("btn_login"),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Cyan,
                        )
                    ) {
                        Text(
                            text = "Log in",
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Text(
                        text = "or sign up with",
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("tv_signup"),
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = Medium,
                            shadow = Shadow(
                                color = Color.LightGray,
                                Offset.Zero,
                                blurRadius = 1.0f
                            ),
                            fontStyle = FontStyle.Normal
                        )
                    )

                    Card(
                        modifier = Modifier.layoutId("iv_facebook"),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        elevation = 5.dp
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = null
                        )
                    }

                    Card(
                        modifier = Modifier
                            .layoutId("iv_google"),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        elevation = 5.dp
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = null
                        )
                    }

                }

            }
        }
    }


}

private fun CardConstraints(): ConstraintSet {

    return ConstraintSet {
        val email = createRefFor("et_Email")
        val password = createRefFor("et_Password")

        constrain(email) {
            start.linkTo(parent.start, margin = 50.dp)
            top.linkTo(parent.top, margin = 50.dp)
            end.linkTo(parent.end, margin = 50.dp)
            bottom.linkTo(password.top)
        }

        constrain(password) {
            start.linkTo(email.start)
            end.linkTo(email.end)
            top.linkTo(email.bottom)
            bottom.linkTo(parent.bottom, margin = 50.dp)
        }

        createVerticalChain(
            email, password,
            chainStyle = ChainStyle.Packed
        )

    }
}

@Composable
private fun TextEditField(
    hintText: String,
    imageVector: ImageVector,
    visualTransformation: VisualTransformation
) {

    val text = remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = text.value,
        onValueChange = { newValue -> text.value = newValue },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .layoutId("et_$hintText"),
        label = { Text(text = hintText) },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = "Your $hintText"
            )
        },
        enabled = true,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true
    )
}


private fun MainConstraints(): ConstraintSet {
    return ConstraintSet {
        val imageHotel = createRefFor("image_hotel")
        val loginCard = createRefFor("login_card")
        val imageLocation = createRefFor("image_location")
        val tvWelcome = createRefFor("tv_welcome")
        val tvHotelDetails = createRefFor("tv_hotel_details")
        val btnLogin = createRefFor("btn_login")
        val tvSignup = createRefFor("tv_signup")
        val ivFacebook = createRefFor("iv_facebook")
        val ivGoogle = createRefFor("iv_google")

        constrain(imageHotel) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            width = Dimension.wrapContent
            height = Dimension.value(450.dp)
        }

        constrain(loginCard) {
            start.linkTo(parent.start, margin = 20.dp)
            top.linkTo(imageHotel.top , margin = 350.dp)
            end.linkTo(parent.end, margin = 20.dp)
            height = Dimension.value(170.dp)
            width = Dimension.fillToConstraints
        }

        constrain(imageLocation) {
            start.linkTo(parent.start, margin = 20.dp)
            top.linkTo(parent.top, margin = 20.dp)
        }

        constrain(tvWelcome) {
            start.linkTo(imageLocation.start)
            top.linkTo(imageLocation.bottom, margin = 50.dp)
        }

        constrain(tvHotelDetails) {
            start.linkTo(tvWelcome.start)
            top.linkTo(tvWelcome.bottom, margin = 20.dp)
            end.linkTo(parent.end, margin = 20.dp)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(btnLogin) {
            start.linkTo(loginCard.start)
            end.linkTo(loginCard.end)
            top.linkTo(loginCard.bottom, margin = 20.dp)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(tvSignup) {
            start.linkTo(btnLogin.start)
            end.linkTo(btnLogin.end)
            top.linkTo(btnLogin.bottom , margin = 150.dp)
            width = Dimension.wrapContent
        }

        constrain(ivFacebook) {
            start.linkTo(parent.start)
            top.linkTo(tvSignup.bottom, margin = 20.dp)
            end.linkTo(ivGoogle.start )
            bottom.linkTo(parent.bottom , margin = 50.dp)
            width = Dimension.value(50.dp)
            height = Dimension.value(50.dp)
        }

        constrain(ivGoogle) {
            start.linkTo(ivFacebook.end)
            top.linkTo(ivFacebook.top)
            bottom.linkTo(ivFacebook.bottom)
            end.linkTo(parent.end)
            width = Dimension.value(50.dp)
            height = Dimension.value(50.dp)
        }

//        createHorizontalChain(
//            ivFacebook , ivGoogle,
//            chainStyle = ChainStyle.Packed
//        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Compose_layout_practice_140621Theme {
        LoginMainLayout()
    }
}