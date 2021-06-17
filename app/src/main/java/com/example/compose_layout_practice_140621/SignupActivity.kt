package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme

open class SignupActivity(title : String , route : String) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SignupLayout()
                }
            }
        }
    }
}

@Composable
fun SignupLayout() {
    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxHeight(),
            ) {


                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Sign up",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))

                TextEditField(
                    hintText = "Email",
                    imageVector = Icons.Default.Email,
                    visualTransformation = VisualTransformation.None
                )

                TextEditField(
                    hintText = "Username",
                    imageVector = Icons.Default.Person,
                    visualTransformation = VisualTransformation.None
                )

                TextEditField(
                    hintText = "Password",
                    imageVector = Icons.Default.Lock,
                    visualTransformation = PasswordVisualTransformation()
                )

                TextEditField(
                    hintText = "Confirm Password",
                    imageVector = Icons.Default.Lock,
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row() {

                    Spacer(modifier = Modifier.width(10.dp))

                    Checkbox(
                        checked = false,
                        enabled = true,
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            checkedColor = Color.Cyan
                        ),
                        onCheckedChange = {
                            check(true)
                        }
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Subscribe for news-letters",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

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
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(100.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already a member?",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Log in",
                        style = TextStyle(
                            color = Color.Blue,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .layoutId("iv_facebook"),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        elevation = 5.dp
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = null,
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Card(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .layoutId("iv_google"),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        elevation = 5.dp
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = null,
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                        )
                    }
                }


            }
        }
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

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Compose_layout_practice_140621Theme {
        SignupLayout()
    }
}