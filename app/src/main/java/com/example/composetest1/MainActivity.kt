package com.example.composetest1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest1.ui.theme.ComposeTest1Theme
import java.util.concurrent.atomic.AtomicInteger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    testButton()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTest1Theme {
        Greeting("Android")
    }
}
@Composable
fun testButton() {
    val str = "Android"
    val strList : List<String> = listOf(str,str,str,str,str )

    val maxCount = 1000
    val cnt = AtomicInteger(0)

    //1번
    LazyColumn {
        items(maxCount) { index ->
            LazyRow {
                items(count = strList.size, key = {
                    it
                }, itemContent =  {str ->
                    Text(text = "$index:$str, ")
                })
            }
        }
    }


    //2번
//    val scrollState = rememberScrollState()
//    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
//        for(index in 1..maxCount) {
//            LazyRow {
//                items(items = strList) { str ->
//                    Text(text = "$index:$str, ")
//                }
//            }
//        }
//    }

//    //3번
//    LazyColumn {
//        items(maxCount) { index1 ->
//            val scrollState = rememberScrollState()
//            Row(modifier = Modifier.horizontalScroll(scrollState)) {
//                for (index2 in 1..3) {
//                    Text(text = "$index1:$str, ")
//                }
//            }
//        }
//    }
}