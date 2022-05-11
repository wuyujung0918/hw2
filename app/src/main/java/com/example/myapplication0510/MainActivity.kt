package com.example.myapplication0510

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication0510.ui.theme.MyApplication0510Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyApplication0510Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(this::myClick)
                //}
            }
        }
    }

    fun myClick(){
        requestPermissionLauncher.launch( CAMERA )
        Toast.makeText(applicationContext, "Click", Toast.LENGTH_SHORT).show()

    }

    val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            permit->
        if (permit){
            Toast.makeText(applicationContext,"同意", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, ScanActivity::class.java))

            //startLauncher.launch(Intent( MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

}

@Composable
fun Greeting(myClick: ()->Unit) {
    Column() {
        Text(text = "按下Scan barcode!", fontSize = 30.sp)
        Button(onClick = myClick) {
            Text(text = "Scan")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication0510Theme {
        Greeting(myClick = {})
    }
}