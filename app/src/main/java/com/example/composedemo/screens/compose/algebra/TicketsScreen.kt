package com.example.composedemo.screens.compose.algebra

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composedemo.Navigation
import com.example.composedemo.R

/*
 * @author Yana Glad
 */
typealias TicketImage = R.drawable

@Composable
fun TicketsScreen(navController: NavController) {
    Column {
        Row(modifier = Modifier.align(Alignment.Start)) {
            Column {
                Text(
                    text = "Билеты",
                    modifier = Modifier.offset(y = 50.dp, x = 50.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                )
                Text(
                    text = "Нажми на билет, чтобы посмотреть решение. Так же можно отфильтровать решения по номеру задачи",
                    modifier = Modifier
                        .offset(y = 50.dp, x = 20.dp)
                        .width(200.dp),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_telescope),
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(top = 50.dp),
                contentDescription = "App theme",
            )
        }

        Row(modifier = Modifier
            .padding(top = 8.dp)
            .horizontalScroll(rememberScrollState())
        ) {
            SimpleButton("Список билетов")
            SimpleButton("Номер 1")
            SimpleButton("Номер 2")
            SimpleButton("Номер 3")
            SimpleButton("Номер 4")
        }

        val images = listOf(
            TicketImage.first_algebra, TicketImage.second_algebra, TicketImage.third_algebra,
            TicketImage.fouth_algebra, TicketImage.fifth_algebra, TicketImage.sixth_algebra, TicketImage.seventh_algebra,
            TicketImage.eighth_algebra, TicketImage.nineth_algebra, TicketImage.tenth_algebra, TicketImage.eleventh_algebra,
            TicketImage.twelvth_alebra, TicketImage.thirteenth_algebra, TicketImage.fourteenth_algebra,
            TicketImage.fifteenth_algebra, TicketImage.sixteenth_algebra, TicketImage.seventeenth_algebra,
            TicketImage.eighteenth_algebra, TicketImage.nineteenth_algebra, TicketImage.twentieth_algebra,
            TicketImage.twentyfifth_algebra, TicketImage.twentysecond_algebra, TicketImage.twentythird_algebra,
            TicketImage.twentyfouth_algebra, TicketImage.twentyfifth_algebra, TicketImage.twentysixth_algebra,
            TicketImage.twentyseventh_algebra, TicketImage.twentyeighth_algebra, TicketImage.twentynineth_algebra,
        )

        var i = 1
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            images.forEach {
                TicketView(navController = navController, image = it, number = i++)
            }
        }
    }
}

@Composable
private fun TicketView(navController: NavController, image: Int, number: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Билет $number",
            modifier = Modifier.padding(top = 20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(image),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = 50.dp),
                contentDescription = "ticket $number",
            )
            Card(
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(60.dp)
                    .height(60.dp),
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_magnifier),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .clickable(
                            enabled = true,
                            onClick = {
                                navController.navigate("${Navigation.IMAGE_VIEWER}/$image/${Navigation.ALGEBRA_TICKETS}")
                            }
                        ),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Magnifier",
                    alignment = Alignment.TopEnd,
                )
            }
        }
    }
}

@Composable
private fun SimpleButton(text: String) {
    Button(
        modifier = Modifier.padding(start = 8.dp),
        onClick = { }
    ) {
        Text(text = text)
    }
}
