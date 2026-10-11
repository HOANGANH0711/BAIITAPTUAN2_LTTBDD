package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Student
fun Diemtrungbinh(studens: List<Student>): Double{
    var tongdiem = 0.0
    var sohocsinhcodiem = 0
    for(Student in studens){
        if(Student.score != null){
            tongdiem += Student.score
            sohocsinhcodiem++
        }
    }
    return if (sohocsinhcodiem > 0){
        tongdiem / sohocsinhcodiem
    }else{
        0.0
    }
}
fun sosinhviengioi(students: List<Student>): Int{
    var sosinhviengioi = 0
    for(Student in students){
        if(Student.score != null && Student.score>=8.0){
            sosinhviengioi++
        }
    }
    return sosinhviengioi
}
fun diemcaonhat(students : List<Student>): Double{
    var max = 0
    for(Student in students){
        if(Student.score != null && Student.score >max){
            max = Student.score.toInt()
        }
    }
    return max.toDouble()
}
fun chuacodiem(students: List<Student>): Int{
    var sosinhvienchuacodiem = 0
    for(Student in students){
        if(Student.score == null){
            sosinhvienchuacodiem++
        }
    }
    return sosinhvienchuacodiem
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreClassScreen(students: List<Student>){
    val diemtrungbinh = Diemtrungbinh(students)
    val sosinhvien = students.size
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bảng điểm lớp",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00004D)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ){
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF00004D)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ){
                Column(
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(text = "Điểm trung bình lớp",
                        color = Color(0xFFB7B7B7)
                    )

                    Text(text = "%.2f".format(diemtrungbinh),
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .height(1.dp)
                            .background(Color(0xFFA2A2A2))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column {
                            Text(
                                text = "Giỏi",
                                color = Color.White
                            )
                            Text(
                                text = sosinhviengioi(students).toString(),
                                color = Color.White,
                                fontSize = 20.sp,

                                )
                        }
                        Column {
                            Text(
                                text = "Chưa có điểm",
                                color = Color.White
                            )
                            Text(
                                text = chuacodiem(students).toString(),
                                color = Color.White,
                                fontSize = 20.sp,

                                )
                        }
                        Column {
                            Text(
                                text = "Cao nhất",
                                color = Color.White
                            )
                            Text(
                                text = diemcaonhat(students).toString(),
                                color = Color.White,
                                fontSize = 20.sp,

                                )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "DANH SÁCH $sosinhvien SINH VIÊN",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            for(Student in students){
                CardScoreStudent(Student)
                Spacer(modifier = Modifier.height(12.dp))
            }

        }
    }
}
@Composable
fun CardScoreStudent(student: Student){
    val ketqua = if(student.score != null){
        xeploai(student.score)
    }else{
        "Chưa có điểm"
    }
    val mau = if(student.score != null){
        mauxeploai(student.score)
    }else{
        Color.Gray
    }
    Card(
        modifier = Modifier.fillMaxWidth().height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Column{
                Text(text = student.name,
                    fontWeight = FontWeight.Bold)
                Text(text = ketqua,
                    color = mau,
                    fontWeight = FontWeight.Bold)
            }
            Column{
                if(student.score != null) {
                    Text(
                        text = student.score.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }else{
                    Text(
                        text = "—",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}