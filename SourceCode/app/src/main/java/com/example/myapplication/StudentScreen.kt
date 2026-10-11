package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Student

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentScreen(students: List<Student>){
    var missingEmail = 0
    for(Student in students){
        if(Student.email ==  null){
            missingEmail++
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Danh sách sinh viên", color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00004D)
                )
            )
        }
    ){
            innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ){
            for(Student in students){
                StudentCard(Student)

                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFB7DCFF)
                )

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color(0xFF00004D))
                        ) {
                            append("Tổng: ")
                        }
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append(students.size.toString())
                            append(" Sinh viên")
                        }

                    })
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color(0xFF00004D))
                        ){
                            append("Thiêus Email: ")
                        }
                        withStyle(
                            style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)
                        ){
                            append(missingEmail.toString())
                        }
                    })
                }
            }

        }
    }

}
@Composable
fun StudentCard(student: Student){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = student.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray
                    )
                ) {
                    append("Email: ")
                }
                if (student.email == null) {
                    withStyle(
                        style = SpanStyle(color = Color.Red)
                    ) {
                        append("Chưa cập nhật")
                    }
                } else {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray
                        )
                    ) {
                        append(
                            student.email
                        )
                    }
                }
            })
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = buildAnnotatedString {
                withStyle(
                    style  = SpanStyle(color = Color.Gray)
                ) {
                    append("Số điện thoại: ")
                }
                if (student.phone == null) {
                    withStyle(
                        style = SpanStyle(color = Color.Red)
                    ) {
                        append("Chưa cập nhật")
                    }
                } else {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray
                        )
                    ) {
                        append(
                            student.phone
                        )
                    }
                }
            })
        }
    }
}