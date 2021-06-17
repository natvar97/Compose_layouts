package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.compose_layout_practice_140621.drawer.DrawerScreens
import com.example.compose_layout_practice_140621.model.DrawerItem
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter
import kotlinx.coroutines.launch

class HomeComposeDrawerLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppDrawerLayout()
                }
            }
        }
    }
}

@Composable
fun AppDrawerLayout() {


    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            /*
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp),
                onClick = { scope.launch { drawerState.close() } },
                content = { Text("Close Drawer") }
            )
            */

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                elevation = 10.dp,
                backgroundColor = Color.DarkGray,
                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        painter = rememberGlidePainter(request = R.drawable.uru),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Urvashi Prajapati",
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "prajapatinatavar21197@gmail.com",
                            style = MaterialTheme.typography.body2,
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            text = "+91 6352517474",
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif
                        )

                    }


                }


            }


            LazyColumn(
                modifier = Modifier.background(colorResource(id = R.color.light_orange))
            ) {
                val drawerItemsList = listOf(
                    DrawerItem(R.drawable.icon_home_white, "Home"),
                    DrawerItem(R.drawable.icon_mail_white, "Mail"),
                    DrawerItem(R.drawable.icon_lock_white, "Security"),
                    DrawerItem(R.drawable.icon_notifications_none_white_, "Notifications"),
                    DrawerItem(R.drawable.icon_info_white, "About"),
                    DrawerItem(R.drawable.icon_settings_white, "Settings"),
                    DrawerItem(R.drawable.icon_facebook_white, "Social")
                )

                items(drawerItemsList) { item ->
                    DrawerItemLayout(image = item.image, name = item.name , modifier = Modifier.padding(10.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }


        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { drawerState.open() } }) {
                    Text("Click to open")
                }
            }
        }
    )

}

@Composable
fun DrawerItemLayout(image: Int, name: String , modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
        backgroundColor = colorResource(id = R.color.blue_new)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = rememberGlidePainter(image),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
            )

        }
    }
}


@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier = modifier
            .requiredWidth(200.dp)
            .fillMaxHeight()
            .background(color = Color.Cyan)
    ) {


        Image(
            painter = rememberGlidePainter(request = R.drawable.uru),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))

        )

        TextColumn("Home")
        TextColumn("Hotels")
        TextColumn("Top Destinations")
        TextColumn("Profile")
        TextColumn("Movies")
        TextColumn("About")
        TextColumn("Register")


    }
}

@Composable
fun TextColumn(title: String) {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = title,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        ),
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
    )
    Spacer(modifier = Modifier.height(20.dp))
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    Compose_layout_practice_140621Theme {
        AppDrawerLayout()
    }
}