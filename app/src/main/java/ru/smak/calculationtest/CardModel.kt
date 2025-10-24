package ru.smak.calculationtest

import kotlin.math.absoluteValue
import kotlin.random.Random

class CardModel {
    val op1: Int
    val op2: Int
    val operation: Operation
    val coorectResulut: Int
        get() = when (operation){
            Operation.PLUS -> op1 + op2
            Operation.MINUS -> op1 - op2
            Operation.TIMES -> op1 * op2
            Operation.DIV -> op1 / op2
        }

    init{
        operation = Operation.entries[Random.nextInt(4)]
        when(operation){
            Operation.PLUS -> {
                op1 = Random.nextInt(-100, 101)
                op2 = Random.nextInt(
                    -100 + op1.absoluteValue,
                    100 - op1.absoluteValue,
                )
            }
            Operation.MINUS -> {
                op1 = Random.nextInt(-100, 101)
                op2 = Random.nextInt(
                    -100 - op1.absoluteValue,
                    100 + op1.absoluteValue,
                )
            }
            Operation.TIMES -> {
                op1 = Random.nextInt(-10, 11)
                op2 = Random.nextInt(-10, 11)
            }
            Operation.DIV -> {
                val res = Random.nextInt(-10, 11)
                op2 = Random.nextInt(1, 11) * if (Random.nextBoolean()) 1 else -1
                op1 = res * op2
            }
        }
    }

    fun isCorrect(userValue: Int?) =
        userValue!= null && userValue == coorectResulut

}