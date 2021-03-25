package com.example.weatherforecast.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.weatherforecast.HourlyTemp
import com.example.weatherforecast.R
import com.example.weatherforecast.ui.theme.DailyTemp
import com.example.weatherforecast.ui.theme.MyTheme
import java.text.SimpleDateFormat
import java.util.*

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                WeatherApp()
            }
        }
    }


    @Composable
    private fun WeatherApp() {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Magenta,
                                Color.Cyan,
                            )
                        )
                    )
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MainContent()
            }
        }
    }

    private @Composable
    fun MainContent() {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.weather),
                style = MaterialTheme.typography.h3, modifier = Modifier.padding(40.dp),
                textAlign = TextAlign.Center, color = Color.White, fontFamily = FontFamily.Cursive
            )
            topcardView()
            Spacer(modifier = Modifier.size(10.dp))
            bottomcardView()
            Spacer(modifier = Modifier.size(10.dp))
            temperatureAttributeView()

        }
    }

    @Composable
    private fun bottomcardView() {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                bottomHeaderView()
                initDailyTempView()
            }
        }
    }

    @Composable
    private fun temperatureAttributeView() {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                        .fillMaxWidth()
                ) {


                    Text(
                        text = "UV Index",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "High",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.End
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                        .fillMaxWidth()
                ) {


                    Text(
                        text = "Sunrise",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "6:30 AM",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.End
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                        .fillMaxWidth()
                ) {


                    Text(
                        text = "Sunset",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "6:45 PM",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.End
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = "Wind",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "13 km/h",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.End
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = "Humidity",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "30%",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.End
                    )
                }
            }

        }
    }

    @Composable
    private fun initDailyTempView() {
        val context = LocalContext.current
        var dailyTempList = listOf<DailyTemp>(
            DailyTemp("Today", 0, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Thursday", 1, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Friday", 1, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Saturday", 2, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Sunday", 0, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Tuesday", 1, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
            DailyTemp("Monday", 0, R.drawable.sun, R.drawable.moon, "32\u00B0/21\u00B0"),
        )
        for (tempList in dailyTempList) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(1.0f)
                    .padding(0.dp, 5.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = tempList.day,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Row(horizontalArrangement = Arrangement.End) {
                        Image(
                            painter = painterResource(id = R.drawable.humidity),
                            modifier = Modifier.size(20.dp),
                            contentDescription = ""
                        )
                        Text(
                            text = StringBuffer().append(tempList.humidity).append(" ").append("%")
                                .toString(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.subtitle2
                        )

                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Row(horizontalArrangement = Arrangement.Start) {
                        Image(
                            painter = painterResource(id = tempList.dayIcon),
                            contentDescription = "",
                            Modifier.size(20.dp)
                        )
                        Image(
                            painter = painterResource(id = tempList.nightIcon),
                            contentDescription = "",
                            Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = tempList.temp,
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }


}

@Composable
private fun bottomHeaderView() {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Yesterday",
            textAlign = TextAlign.Start,
            color = Color.LightGray,
            style = MaterialTheme.typography.body1,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "32\u00B0/21\u00B0",
            textAlign = TextAlign.End,
            color = Color.LightGray,
            style = MaterialTheme.typography.body1,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Composable
private fun topcardView() {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            currentCityView()
            hourlyTempView()
        }
    }
}

@Composable
private fun hourlyTempView() {
    initHourlyTempView()
}

@Composable
private fun initHourlyTempView() {
    val context = LocalContext.current
    var hourlyTempList = listOf<HourlyTemp>(
        HourlyTemp("3 PM", "29\u00B0", R.drawable.sun, 1),
        HourlyTemp("4 PM", "29\u00B0", R.drawable.sun, 1),
        HourlyTemp("5 PM", "28\u00B0", R.drawable.sun, 1),
        HourlyTemp("6 PM", "28\u00B0", R.drawable.sun, 1),
        HourlyTemp("7 PM", "27\u00B0", R.drawable.moon, 2),
        HourlyTemp("8 PM", "26\u00B0", R.drawable.moon, 2),
        HourlyTemp("9 PM", "26\u00B0", R.drawable.moon, 3),
        HourlyTemp("10 PM", "26\u00B0", R.drawable.moon, 3),
        HourlyTemp("11 PM", "26\u00B0", R.drawable.moon, 4),
        HourlyTemp("12 PM", "26\u00B0", R.drawable.moon, 4),
        HourlyTemp("1 AM", "25\u00B0", R.drawable.moon, 4),
        HourlyTemp("2 AM", "25\u00B0", R.drawable.moon, 2),
        HourlyTemp("3 AM", "25\u00B0", R.drawable.moon, 3),
        HourlyTemp("4 AM", "25\u00B0", R.drawable.moon, 1),
        HourlyTemp("5 AM", "24\u00B0", R.drawable.moon, 1),
        HourlyTemp("6 AM", "24\u00B0", R.drawable.moon, 6),
        HourlyTemp("7 AM", "29\u00B0", R.drawable.sun, 6),
        HourlyTemp("8 AM", "23\u00B0", R.drawable.sun, 7),
        HourlyTemp("9 AM", "23\u00B0", R.drawable.sun, 8),
        HourlyTemp("10 AM", "23\u00B0", R.drawable.sun, 7),
        HourlyTemp("11 AM", "24\u00B0", R.drawable.sun, 7),
        HourlyTemp("12 AM", "26\u00B0", R.drawable.sun, 2),
        HourlyTemp("1 PM", "29\u00B0", R.drawable.sun, 2),
        HourlyTemp("2 PM", "29\u00B0", R.drawable.sun, 2)
    )
    LazyRow() {
        items(hourlyTempList) { templist ->
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = templist.time,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.LightGray
                )
                Image(
                    painter = painterResource(id = templist.icon),
                    contentDescription = "",
                    Modifier.size(30.dp)
                )
                Text(
                    text = templist.temp,
                    style = MaterialTheme.typography.subtitle2,
                    fontFamily = FontFamily.Cursive
                )
                Row(horizontalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.humidity),
                        contentDescription = "",
                        Modifier.size(20.dp)
                    )
                    Text(
                        text = StringBuffer().append(templist.humidity).append(" ").append("%")
                            .toString(),
                        style = MaterialTheme.typography.caption,
                        color = Color.LightGray
                    )
                }
            }


        }
    }


}

@Composable
private fun currentCityView() {
    Row() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "",
                    Modifier.size(16.dp)
                )
                Text(
                    text = stringResource(R.string.karachi),
                    style = MaterialTheme.typography.h5,
                    fontFamily = FontFamily.Cursive
                )
            }
            Text(
                text = SimpleDateFormat(
                    "EEE, MMMM dd HH:mm a",
                    Locale.getDefault()
                ).format(
                    Date()
                ), style = MaterialTheme.typography.caption, color = Color.LightGray
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.haze),
                        contentDescription = "",
                        Modifier.size(40.dp)
                    )
                    Text(
                        text = "29\u00B0",
                        style = MaterialTheme.typography.h4,
                        fontFamily = FontFamily.Cursive
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Haze",
                        style = MaterialTheme.typography.caption,
                        color = Color.LightGray
                    )
                    Text(
                        text = "30\u00B0/22\u00B0",
                        style = MaterialTheme.typography.caption,
                        color = Color.LightGray
                    )
                    Text(
                        text = "Feels like 32\u00B0",
                        style = MaterialTheme.typography.caption,
                        color = Color.LightGray
                    )
                }
            }
        }

    }
}

