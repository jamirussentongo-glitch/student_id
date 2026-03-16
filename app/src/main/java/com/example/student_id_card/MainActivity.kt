package com.example.student_id_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.student_id_card.ui.theme.STUDENT_ID_CARDTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            STUDENT_ID_CARDTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    StudentInfo()
                }
            }
        }
    }
}

@Composable
fun StudentInfo() {
    ElevatedCard(
        modifier = Modifier
            .width(340.dp)
            .height(220.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Box {
            // Watermark logos
            Image(
                painter = painterResource(id = R.drawable.ndejje_log),
                contentDescription = "watermark",
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.CenterStart)
                    .alpha(0.08f)
            )

            Image(
                painter = painterResource(id = R.drawable.ndejje_log),
                contentDescription = "watermark",
                modifier = Modifier
                    .size(91 .dp)
                    .align(Alignment.CenterEnd)
                    .alpha(0.08f)
            )

            Column {
                // HEADER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color(0xFF8B1E1E))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // University logo
                        Image(
                            painter = painterResource(R.drawable.ndejje_log),
                            contentDescription = "Ndejje University logo",
                            modifier = Modifier
                                .background(Color.White, CircleShape)
                                .size(50.dp)
                                .clip(CircleShape)
                        )

                        // Uganda flag
                        Image(
                            painter = painterResource(R.drawable.uganda_flag),
                            contentDescription = "Uganda National Flag",
                            modifier = Modifier.size(55.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // STUDENT DETAILS
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.student_name).uppercase(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(R.string.programme).uppercase(),
                        fontSize = 11.sp
                    )

                    Text(
                        text = "Registration Number: ${stringResource(R.string.reg_number)}",
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Date of issue: ${stringResource(R.string.date_of_issue)}",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Expiry date: ${stringResource(R.string.expiry_date)}",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    // Barcode
                    Row(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .height(20.dp)
                            .fillMaxWidth(0.9f),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(85) {
                            Box(
                                modifier = Modifier
                                    .width(1.dp)
                                    .fillMaxHeight()
                                    .background(Color.Black)
                            )

                            Spacer(modifier = Modifier.width(1.dp))
                        }
                    }
                }

                // FOOTER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .background(Color(0xFF8B1E1E))
                )
            }

            // STUDENT PHOTO
            Image(
                painter = painterResource(id = R.drawable.jami),
                contentDescription = "Student photo",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF8B1E1E), CircleShape)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    STUDENT_ID_CARDTheme {
        StudentInfo()
    }
}
