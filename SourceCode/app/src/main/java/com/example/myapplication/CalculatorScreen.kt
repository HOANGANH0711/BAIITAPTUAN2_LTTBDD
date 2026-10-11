package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(){
    var so1 by remember{mutableStateOf("")}
    var so2 by remember{mutableStateOf("")}
    var pheptoan by remember{mutableStateOf("")}

    val a = so1.toDoubleOrNull()
    var b = so2.toDoubleOrNull()

    val ketqua = if(a != null && b != null){
        if(pheptoan == "+"){
            a+b
        }else if(pheptoan == "-"){
            a-b
        }else if(pheptoan == "*"){
            a*b
        }else if(pheptoan == "/"){
            if(b != 0.0){
                a/b
            }else{
                null
            }
        }else{
            null
        }
    }else{
        null
    }

    Column(
        modifier =Modifier
            .fillMaxSize()
            .padding(24.dp)
            .offset(y = (-60).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = "Thực Hành 03",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = so1,
            onValueChange = {
                so1 = it
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {
                    pheptoan = "+"
                },
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9F2A2A),
                    contentColor = Color.White

                )
            ){
                Text("+")
            }
            Button(
                onClick = {
                    pheptoan = "-"
                },
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB98039),
                    contentColor = Color.White
                )
            ){
                Text("-")
            }
            Button(
                onClick = {
                    pheptoan = "*"
                },
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4B1C80),
                    contentColor = Color.White
                )
            ){
                Text("*")
            }
            Button(
                onClick = {
                    pheptoan = "/"
                },
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF01010A),
                    contentColor = Color.White
                )
            ){
                Text("/")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = so2,
            onValueChange = {
                so2 = it
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if(ketqua == null){
                "kết quả: "
            }else{
                "kết quả: $ketqua"

            },
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
        )

    }
}