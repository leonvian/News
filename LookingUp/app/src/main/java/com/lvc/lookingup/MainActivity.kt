package com.lvc.lookingup

import android.accounts.AccountManager.get
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lvc.lookingup.ui.listofnews.ListOfNewsScreen
import com.lvc.lookingup.ui.listofnews.ListOfNewsViewModel

import com.lvc.lookingup.ui.theme.LookingUpTheme
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {

    private val viewModel  by inject<ListOfNewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(ListOfNewsViewModel::class.java)

        setContent {
            LookingUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val news = viewModel.newsLiveData.observeAsState(emptyList())
                    Column {
                        Greeting("Android") {
                            viewModel.getNews()
                        }
                        ListOfNewsScreen(newsList = news.value)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 200.dp, height = 60.dp)
            .background(Color.Blue)
            .clickable {
                onClick()
            }
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Hello $name!"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LookingUpTheme {
        Greeting("Android") {

        }
    }
}