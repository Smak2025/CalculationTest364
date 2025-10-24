package ru.smak.calculationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.smak.calculationtest.ui.TestCard
import ru.smak.calculationtest.ui.theme.CalculationTestTheme
import ru.smak.calculationtest.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculationTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestCard(
                        viewModel.card,
                        viewModel.userValue,
                        modifier = Modifier.padding(innerPadding),
                        viewModel.bgColor,
                        onUserInput = {
                            viewModel.userValue = it
                        },
                        onCheckResult = {
                            viewModel.checkResult()
                        }
                    )
                }
            }
        }
    }
}
