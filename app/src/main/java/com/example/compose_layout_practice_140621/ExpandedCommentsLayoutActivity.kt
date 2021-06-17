package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_layout_practice_140621.model.CommentModel
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter

class ExpandedCommentsLayoutActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CommentListLayout()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CommentListLayout() {

    val commentList = listOf<CommentModel>(
        CommentModel("Christian Bale", stringResource(id = R.string.christian_comment),R.drawable.image_christian_bale),
        CommentModel("Robert Downy Jr", stringResource(id = R.string.rdj_comment),R.drawable.image_rdj),
        CommentModel("Johny Depp", stringResource(id = R.string.dep_comment),R.drawable.image_johny_depp),
        CommentModel("Leonardo De Caprico", stringResource(id = R.string.leonardo_comment),R.drawable.image_leonardo),
        CommentModel("Allu Arjun", stringResource(id = R.string.allu_arjun_comment),R.drawable.image_allu_arjun),
        CommentModel("Akshay Kumar", stringResource(id = R.string.akshay_comment),R.drawable.image_akshay),
        CommentModel("Rashmika Mandana", stringResource(id = R.string.rashmika_comment),R.drawable.image_rashmika),
        CommentModel("Kajal Agarwal", stringResource(id = R.string.kajal_comment),R.drawable.image_kajal),
    )

    Column(
        modifier = Modifier.background(Color.White)
    ) {

        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            backgroundColor = colorResource(id = R.color.blue_new),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Text(
                text ="Comments",
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }

        LazyColumn(
            modifier = Modifier.padding(5.dp)
        ) {
            items(commentList ){ comment ->
                CommentCardLayout(comment =comment )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }



}



@ExperimentalAnimationApi
@Composable
fun CommentCardLayout(comment: CommentModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.black),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
    ) {
        var expanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .padding(10.dp)
            .clickable { expanded = !expanded }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = rememberGlidePainter(request = comment.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .clip(CircleShape)

                )
                
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = comment.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )

            }

            AnimatedVisibility(expanded) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

        }


    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    Compose_layout_practice_140621Theme {
        CommentListLayout()
    }
}