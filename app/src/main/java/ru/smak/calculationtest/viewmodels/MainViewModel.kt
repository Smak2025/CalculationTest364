package ru.smak.calculationtest.viewmodels

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ru.smak.calculationtest.CardModel

class MainViewModel : ViewModel() {

    val card: CardModel = CardModel()

    var bgColor by mutableStateOf(Color.Unspecified)

    private var _userValue: String by mutableStateOf("")

    var userValue: String
        get() = _userValue
        set(value) {
            if (
                value.isEmpty()
                || value == "-"
                || (value.toIntOrNull() != null
                        && (value.toIntOrNull() ?: 0) in -100..101)
            )
                _userValue = value
        }

    fun checkResult(){
        bgColor = if (card.isCorrect(userValue.toIntOrNull())){
            Color.Green
        } else {
            Color.Red
        }
        Log.d("ViewModel", bgColor.toString())
    }

}