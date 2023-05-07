package com.yaindustries.cloudplay.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaindustries.cloudplay.R
import com.yaindustries.cloudplay.ui.commons.CPIconButton
import com.yaindustries.cloudplay.ui.models.DataItemRecord
import com.yaindustries.cloudplay.ui.theme.lessRoundShape
import com.yaindustries.cloudplay.utils.Constants
import com.yaindustries.cloudplay.utils.TimeUtils

val tempContentList = listOf(
    DataItemRecord("dasdsa", "Music 1", "Author 1"),
    DataItemRecord("dasdsa", "Music 2", "Author 2"),
    DataItemRecord("dasdsa", "Music 3", "Author 3")
)

@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        HomeScreenContent()

    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(Constants.Ui.BASE_PADDING)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TopRow()
        ContentBlock(
            heading = stringResource(id = R.string.recently_played),
            contentList = tempContentList
        )
    }
}


@Composable
private fun TopRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 0.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = getGreeting()),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            CPIconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = stringResource(id = R.string.settings)
                )
            }
        }
    }
}

@Composable
private fun ContentBlock(heading: String, contentList: List<DataItemRecord>) {
    Text(
        text = heading,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(4.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(contentList) {
            Column {
                Card(shape = lessRoundShape.small) {
                    Image(
                        painter = painterResource(id = R.drawable.album_placeholder),
                        contentDescription = stringResource(id = R.string.photo),
                        modifier = Modifier.size(height = 130.dp, width = 130.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = it.itemName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = it.author,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(4.dp))
}

private fun getGreeting(): Int {
    val currentHour = TimeUtils.currentHourIn24

    if (currentHour in 5..12)
        return R.string.good_morning

    if (currentHour in 12..17)
        return R.string.good_afternoon

    return R.string.good_evening
}