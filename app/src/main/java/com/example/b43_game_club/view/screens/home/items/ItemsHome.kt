package com.example.b43_game_club.view.screens.home.items

import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.b43_game_club.model.supabase.Game
import com.example.b43_game_club.model.supabase.GamePackage
import com.example.b43_game_club.model.supabase.Genre
import com.example.b43_game_club.model.supabase.TypePackage
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.SpacerWidth
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.Blue20
import com.example.b43_game_club.view.ui.theme.gradientButtonBluePink

@Composable
fun ItemsGamePackages(gamePackages: Map<Int, List<GamePackage>>, types: List<TypePackage>) {
    Log.d("types", types.toString())
    Log.d("types", gamePackages.toString())
    if(gamePackages.getOrDefault(1, -1) != -1) {
        Column (modifier = Modifier.fillMaxWidth().background(B43Theme.colors.primaryContainer, RoundedCornerShape(15.dp)).padding(20.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                //тут я создаю первую строку таблицы
                Column(modifier = Modifier.weight(1f)) {
                    TextDesc("ЧАСЫ")
                }
                for (type in gamePackages.keys) {
                    Column(modifier = Modifier.weight(1f)) {
                        types.find { it.id == type }?.name?.let { TextDesc(it.toUpperCase()) }
                    }
                }
            }
            SpacerHeight(12.dp)
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                //тут я заполняю первую колонку с часами
                Column(modifier = Modifier.weight(1f).padding(horizontal = 4.dp)) {
                    for (gPackage in gamePackages.getValue(1)) {
                        Column (modifier = Modifier.fillMaxWidth().background(color = B43Theme.colors.primary, shape = RoundedCornerShape(5.dp))
                            .padding(vertical = 8.dp, horizontal = 12.dp)) {
                            TextDesc(gPackage.time.toString())
                        }
                        //BlueBoxText(gPackage.time.toString() + "ч.")
                        SpacerHeight(12.dp)
                    }
                }
                //тут я заполняю остальные колонки с ценами
                for (type in gamePackages.keys) {
                    Column(modifier = Modifier.weight(1f).padding(horizontal = 4.dp)) {
                        for (gPackage in gamePackages.getValue(type)) {
                            GradientBoxBoxText(gPackage.price.toString() + " Р")
                            SpacerHeight(12.dp)
                        }
                    }
                }
                SpacerHeight(12.dp)
            }
        }

    }
}

@Composable
fun GradientBoxBoxText(text: String){
    Box(modifier = Modifier.fillMaxWidth().border(brush = gradientButtonBluePink, shape = RoundedCornerShape(5.dp), width = 2.dp
    )) {
        Box(modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)) {
            TextDesc(text)
        }
    }
}

@Composable
fun TextDesc(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold, fontSize = 2.5.em),
        color = B43Theme.colors.onPrimary,
        textAlign = TextAlign.Center
    )
}

@Composable
fun GamesColumn(games: MutableList<Game>, genres: MutableList<Genre>){
    if(games.isNotEmpty()) {
        games.forEach { game -> GameInfoItem(game, genres) }
        //Есть вопросы по этой штуке ->
        /*LazyColumn(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            items(games, key = { game -> game.id }) {
                    game -> GameInfoItem(game)
            }
        }*/
    }
}

@Composable
fun GameInfoItem(game: Game, genres: MutableList<Genre>) {
    Card(shape = RoundedCornerShape(15.dp), colors = CardDefaults.cardColors(
        containerColor = B43Theme.colors.primaryContainer,
        disabledContentColor = B43Theme.colors.primaryContainer),
        onClick = {  },
        modifier = Modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            val imgState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current).data(game.image).size(Size.ORIGINAL).build()
            ).state
            if (imgState is AsyncImagePainter.State.Error) {
                Box(modifier = Modifier.fillMaxWidth(0.3f).background(Color(Blue20.value)))
            }
            if (imgState is AsyncImagePainter.State.Success) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .clip(RoundedCornerShape(15.dp))
                        .height(150.dp),
                    painter = imgState.painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            SpacerWidth(12.dp)
            Box(modifier = Modifier.fillMaxHeight().weight(0.7f)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            TextTitleGame(game.name)
                            TextDeveloper(game.developer)
                        }
                        SpacerWidth(8.dp)
                        Column {
                            SpacerHeight(4.dp)
                            TextRelease(game.releaseYear.toString())
                        }
                    }
                    GradientDivider(modifier = Modifier.padding(vertical = 4.dp),
                        thickness = 1.dp, gradientButtonBluePink)
                    TextDescription(game.description)
                    SpacerHeight(12.dp)
                    Row {
                        Column() {
                            TextSmallTitle("Metacritic")
                            SpacerHeight(4.dp)
                            TextRating(game.rating.toInt().toString())
                        }
                        SpacerWidth(24.dp)
                        Column(modifier = Modifier.weight(1f)) {
                            TextSmallTitle("Жанр")
                            SpacerHeight(4.dp)
                            genres.find { it.id == game.idGenre }?.let { TextGenre(it.name) }
                        }
                    }
                }
            }
        }
    }
    SpacerHeight(8.dp)
}

@Composable
fun TextTitleGame(text: String){
    Text(
        modifier = Modifier,
        text = text.toUpperCase(),
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp),
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun TextGenre(text: String){
    Text(
        modifier = Modifier,
        text = text.toUpperCase(),
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Medium, fontSize = 12.sp),
        color = B43Theme.colors.secondary
    )
}

@Composable
fun TextSmallTitle(text: String){
    Text(
        modifier = Modifier,
        text = text,
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold, fontSize = 10.sp),
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun TextDeveloper(text: String){
    Text(
        text = buildAnnotatedString {
            withStyle(SpanStyle(color = B43Theme.colors.onPrimary, fontWeight = FontWeight.Normal)) {
                append("by ")
            }
            withStyle(SpanStyle(color = B43Theme.colors.primary, fontWeight = FontWeight.Medium)) {
                append(text)
            }
        },
        textAlign = TextAlign.Center,
        style = B43Theme.typography.titleTextField.copy(fontSize = 10.sp)
    )
}

@Composable
fun TextRating(text: String){
    Text(
        text = buildAnnotatedString {
            withStyle(SpanStyle(color = B43Theme.colors.onPrimary)) {
                append(text)
            }
            withStyle(SpanStyle(color = B43Theme.colors.primary)) {
                append("/100")
            }
        },
        textAlign = TextAlign.Center,
        style = B43Theme.typography.titleTextField.copy(fontSize = 16.sp, fontWeight = FontWeight.Light)
    )
}

@Composable
fun TextRelease(text: String){
    Box(modifier = Modifier.background(gradientButtonBluePink, RoundedCornerShape(5.dp)).border(color = B43Theme.colors.onPrimary, shape = RoundedCornerShape(5.dp), width = 1.dp)
    ) {
        Box(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Text(
                modifier = Modifier,
                text = text,
                style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Medium, fontSize = 8.sp),
                color = B43Theme.colors.onPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TextDescription(text: String){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text.substring(0, 100) + "...",
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Light, fontSize = 12.sp),
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun GradientDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    gradient: Brush
) {
    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(thickness)) {
        drawRect(brush = gradient)
    }
}

@Composable
fun CustomProgressInd(){
    CircularProgressIndicator(color = B43Theme.colors.secondary, strokeWidth = 2.dp)
}