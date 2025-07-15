package com.jin.jnidemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.jin.jnidemo.demo.NativeCrashHandler
import com.jin.jnidemo.demo2.JNIExample
import com.jin.jnidemo.demo3.TestService
import com.jin.jnidemo.ui.theme.JNIdemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JNIdemoTheme { // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        JNIExample().nativeMethod("Hello World!")
                         //NativeCrashHandler.init()
                        Thread(Runnable {
                            Thread.sleep(5000)
                            ContextCompat.startForegroundService(this,
                                Intent(this,
                                    TestService::class.java))
                        }).start()
                    }, color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JNIdemoTheme {
        Greeting("Android")
    }
}