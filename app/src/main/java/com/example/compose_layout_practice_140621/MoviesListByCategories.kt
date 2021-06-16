package com.example.compose_layout_practice_140621

import android.graphics.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose_layout_practice_140621.model.MovieDetails
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme
import com.google.accompanist.glide.rememberGlidePainter

class MoviesListByCategories : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MoviesListLayout()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MoviesListLayout() {

    val movies = listOf<MovieDetails>(
        MovieDetails("Avatar", "7.8/10", "2 hrs", R.drawable.movie_avatar),
        MovieDetails("Birds of Prey", "6.1/10", "2.3 hrs", R.drawable.movie_birds_of_prey),
        MovieDetails("Captain Marvel", "6.8/10", "2.1 hrs", R.drawable.movie_captain_marvel),
        MovieDetails("Drakula", "6.8/10", "2 hrs", R.drawable.movie_drakula),
        MovieDetails("Inception", "8.8/10", "3 hrs", R.drawable.movie_inception),
        MovieDetails(
            "Once upon A Time In HollyWood",
            "7.6/10",
            "1.5 hrs ",
            R.drawable.movie_once_upon_a_time_in_hollywood
        ),
        MovieDetails(
            "Pirates Of Caribbean - On Stranger Tides",
            "6.6/10",
            "2.6 hrs",
            R.drawable.movie_pirates_of_carribbean
        ),
        MovieDetails("Prestige", "8.5/10", "3.2 hrs", R.drawable.movie_prestige),
        MovieDetails("Thor", "7.0/10", "2.5 hrs", R.drawable.movie_thor),
        MovieDetails("Wonder Woman", "7.4/10", "2.7 hrs", R.drawable.movie_wonder_woman)
    )


    BoxWithConstraints(
        modifier = Modifier.background(Color.White)
    ) {
        val topConstraints = TopConstraints()
        ConstraintLayout(topConstraints) {
            Image(
                painter = rememberGlidePainter(request = R.drawable.movie_pirates_avengers),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                    .layoutId("iv_main"),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Top Hollywood Movies",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId("tv_movies")
            )
        }
    }


    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 200.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        items(movies.size) {
            MovieItemLayout(movie = movies[it] , modifier = Modifier.padding(2.dp))
        }
    }

}

private fun TopConstraints(): ConstraintSet {
    return ConstraintSet {
        val ivMain = createRefFor("iv_main")
        val tvMovies = createRefFor("tv_movies")

        constrain(ivMain) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            height = Dimension.value(200.dp)
        }

        constrain(tvMovies) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = 20.dp)
            bottom.linkTo(parent.bottom)
            height = Dimension.wrapContent
        }

    }
}

@Composable
fun MovieItemLayout(movie: MovieDetails , modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp,
        border = BorderStroke(1.dp , Color.LightGray)
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = rememberGlidePainter(request = movie.poster),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )

            Text(
                text = "Movie: ${movie.name}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.fillMaxWidth()
            )

            Text(
                text = "Duration: ${movie.duration}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.fillMaxWidth()
            )

            Text(
                text = "IMDb: ${movie.rating}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    Compose_layout_practice_140621Theme {
        MoviesListLayout()
    }
}


@Preview(showBackground = true)
@Composable
fun MovieItemLayoutPreview() {
    Compose_layout_practice_140621Theme {
        val movie = MovieDetails(
            name = "Prestige",
            poster = R.drawable.movie_prestige,
            duration = "2.5 hrs",
            rating = "9.7"
        )
        MovieItemLayout(movie)
    }
}