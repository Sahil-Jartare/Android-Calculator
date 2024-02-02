package com.example.androidcalculator

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcalculator.ui.theme.AndroidCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidCalculatorLayoutAndPreview()
                }
            }
        }
    }
}




@Composable
fun AndroidCalculatorLayout(modifier: Modifier = Modifier)
{
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var sign by remember { mutableStateOf("") }
    var input by remember { mutableStateOf("") }

    var number1 = num1.toDoubleOrNull() ?: 0.0
    var number2 = num2.toDoubleOrNull() ?: 0.0


    val answer = calculateAnswer(number1, number2, sign)


    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(id = R.string.Sentence),
            modifier = Modifier
                .padding(bottom = 15.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .size(48.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            TextField(
                value = num1,
                onValueChange = { num1 = it},
                singleLine = true,
                label = { Text(stringResource(id = R.string.number1))},
                leadingIcon = null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done),
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = sign,
                onValueChange = { sign = it},
                singleLine = true,
                label = { Text(stringResource(id = R.string.sign))},
                leadingIcon = null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done),
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = num2,
                onValueChange = { num2 = it},
                singleLine = true,
                label = { Text(stringResource(id = R.string.number2))},
                leadingIcon = null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done),
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth()
            )
        }

        TextField(
            value = num1,
            onValueChange = { num1 = it},
            singleLine = true,
            label = null,
            leadingIcon = null,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = R.string.answer, answer),
            style = MaterialTheme.typography.displaySmall
        )



        }
    }




@Preview(showBackground = true)
@Composable
fun AndroidCalculatorLayoutAndPreview(){
    AndroidCalculatorLayout()
}

private fun calculateAnswer(num1 : Double, num2: Double, sign : String): String
{
    if(sign.equals("+"))
    {
        var num11 = num1 + num2
        return (num11.toString())
    }
    else if(sign.equals("-"))
    {
        var num11 = num1 - num2
        return (num11.toString())
    }
    else
    {
        return "Error"
    }

}