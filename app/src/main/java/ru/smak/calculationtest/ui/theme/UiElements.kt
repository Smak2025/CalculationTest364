package ru.smak.calculationtest.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.smak.calculationtest.R

@Composable
fun TestCard(
    modifier: Modifier = Modifier,

){
    ElevatedCard(
        modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Text(
                    "99 - 88 = ",
                    modifier = Modifier.weight(6f),
                    color = Color.Blue,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                OutlinedTextField(
                    value = "11",
                    onValueChange = {

                    },
                    modifier = Modifier.weight(3f),
                    colors = TextFieldDefaults.colors(focusedTextColor = Color.Blue),
                    textStyle = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)
                )
            }
            FilledIconButton(
                onClick = {},
                modifier = Modifier
                    .size(64.dp),
            ) {
                Icon(Icons.Default.Done, stringResource(R.string.answer_button))
            }
        }
    }
}

@Preview
@Composable
fun TestCardPreview(){
    CalculationTestTheme {
        TestCard()
    }
}