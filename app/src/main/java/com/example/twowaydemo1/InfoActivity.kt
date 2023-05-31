package com.example.twowaydemo1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow
import com.example.twowaydemo1.ui.theme.TwoWayDemo1Theme

class InfoActivity : ComponentActivity() {
    companion object {
        private const val tvShowId = "tvShowId"
        fun intent(tvShow: TvShow, context: Context) =
            Intent(context, InfoActivity::class.java).apply {
                putExtra(tvShowId, tvShow)
            }
    }

    private val tvShow: TvShow by lazy {
        intent?.getSerializableExtra(tvShowId) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwoWayDemo1Theme {
                ViewMoreInfo(tvShow = tvShow)
            }
        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow) {
    var scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = tvShow.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Original release one ${tvShow.year}",
                style = MaterialTheme.typography.titleLarge
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TwoWayDemo1Theme {
    }
}