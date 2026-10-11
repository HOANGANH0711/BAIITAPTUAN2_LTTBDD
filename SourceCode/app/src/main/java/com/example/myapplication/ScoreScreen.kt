package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(score: Double){
    val ketqua = xeploai(score)
    val mau = mauxeploai(score)
    val maunen = mauNenXepLoai(score)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Xếp loại học lực",
                        color = Color.White
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
                .padding(16.dp),
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Điểm Trung Bình",
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = score.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = maunen
                        )){
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = ketqua,
                                color = mau,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Kiểm Tra Thêm",
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {
                KiemTraDiem(9.0)
                KiemTraDiem(7.0)
                KiemTraDiem(5.5)
                KiemTraDiem(3.0)
                KiemTraDiem(11.0)
            }
        }
    }
}
fun xeploai(score: Double): String{
    return if (score < 0 || score > 10){
        "Không hợp lệ"
    }else if(score >= 8.0){
        "Giỏi"
    }else if(score >= 6.5){
        "Khá"
    }else if(score >= 5.0){
        "Trung bình"
    }else{
        "Yếu"
    }
}
fun mauxeploai(score: Double): Color{
    return if (score < 0 || score > 10) {
        Color.Gray
    }else if(score >= 8.0){
        Color(0xFF067006)
    }else if(score >= 6.5){
        Color(0xFF182A80)
    }else if(score >= 5.0){
        Color(0xFF5E3C0B)
    }else{
        Color(0xFFAD0101)
    }

}
fun mauNenXepLoai(score: Double): Color {
    return if (score < 0 || score > 10) {
        Color(0xFFE0E0E0) // xám nhạt
    } else if (score >= 8.0) {
        Color(0xFFA4E7A7) // xanh lá nhạt
    } else if (score >= 6.5) {
        Color(0xFFB5D7FF) // xanh dương nhạt
    } else if (score >= 5.0) {
        Color(0xFFFFE0AF) // cam nhạt
    } else {
        Color(0xFFFD909B) // đỏ nhạt
    }
}
@Composable
fun KiemTraDiem(score: Double){
    Row(
        modifier = Modifier.fillMaxWidth().padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Điểm ${score}"
        )
        Text(
            text = xeploai(score),
            color = mauxeploai(score),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(
                    color = mauNenXepLoai(score),
                    shape = RoundedCornerShape(7.dp)
                )
                .padding(horizontal = 10.dp, vertical = 5.dp)


        )

    }
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 20.dp),
        thickness = 1.dp,
        color = Color(0xFFECECEC)
    )
}