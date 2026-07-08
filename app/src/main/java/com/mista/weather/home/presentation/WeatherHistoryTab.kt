package com.mista.weather.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mista.weather.R
import com.mista.weather.home.domain.WeatherHistoryEntry
import com.mista.weather.ui.theme.AppColors
import com.mista.weather.ui.theme.AppFonts
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WeatherHistoryTab(entries: List<WeatherHistoryEntry>, modifier: Modifier = Modifier) {
    val colors = AppColors.colors

    if (entries.isEmpty()) {
        Box(modifier = modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.home_history_empty),
                style = AppFonts.regular.copy(color = colors.textSecondary, textAlign = TextAlign.Center),
            )
        }
        return
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = entries, key = { it.id }) { entry ->
            WeatherHistoryItem(entry = entry, modifier = Modifier.animateItem())
        }
    }
}

@Composable
private fun WeatherHistoryItem(entry: WeatherHistoryEntry, modifier: Modifier = Modifier) {
    val colors = AppColors.colors
    val dateFormatter = remember { SimpleDateFormat("MMM d, yyyy • HH:mm", Locale.getDefault()) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(colors.backgroundSecondary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = weatherEmoji(entry.weather.condition), fontSize = 32.sp)
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = entry.weather.cityName,
                style = AppFonts.semiBold.copy(color = colors.textPrimary),
            )
            Text(
                text = dateFormatter.format(Date(entry.fetchedAt)),
                style = AppFonts.regular.copy(color = colors.textSecondary, fontSize = 12.sp),
            )
        }
        Text(
            text = stringResource(R.string.home_temperature, entry.weather.temperature),
            style = AppFonts.bold.copy(color = colors.textPrimary, fontSize = 20.sp),
        )
    }
}
