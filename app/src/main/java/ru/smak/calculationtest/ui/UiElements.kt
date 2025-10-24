package ru.smak.calculationtest.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import ru.smak.calculationtest.CardModel
import ru.smak.calculationtest.R
import ru.smak.calculationtest.ui.theme.CalculationTestTheme

@Composable
fun TestCard(
    card: CardModel,
    userValue: String,
    modifier: Modifier = Modifier,
    bgColor: Color = Color.Unspecified,
    onUserInput: (String)->Unit = {},
    onCheckResult: ()->Unit = {},
){
    val task = "${card.op1} ${card.operation.symbol} ${card.op2} = "
    ElevatedCard(
        modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (bgColor == Color.Unspecified)
                MaterialTheme.colorScheme.primaryContainer
            else
                bgColor
        )
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
                    task,
                    modifier = Modifier.weight(6f),
                    color = Color.Blue,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                OutlinedTextField(
                    value = userValue,
                    onValueChange = onUserInput,
                    modifier = Modifier.weight(3f),
                    colors = TextFieldDefaults.colors(focusedTextColor = Color.Blue),
                    textStyle = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)
                )
            }
            FilledIconButton(
                onClick = onCheckResult,
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
        TestCard(CardModel(), "")
    }
}