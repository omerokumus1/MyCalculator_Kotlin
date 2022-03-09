package com.example.mycalculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach

class MainActivity : AppCompatActivity() {

    var inputTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.inputTextView)

//        val buttons = getAllButtons()
//        addOnClickListenersTo(buttons)

    }

    fun onEqual(view: View){
        var startsWithMinus = false
        if (inputTextView?.text != null){
            if (entryContainsOperator() && isLastEntryDigit()) {
                var inputString = inputTextView?.text.toString()
                if (inputString.startsWith("-")) {
                    inputString = inputString.substring(1)
                    startsWithMinus = true
                }
                val operator = getOperator(inputString)
                val inputSplit = inputString.split(operator)
                val firstPart = getPrefix(startsWithMinus) + inputSplit[0]
                val secondPart = inputSplit[1]
                inputTextView?.text = when (operator){
                    "+" -> {
                        (firstPart.toDouble() + secondPart.toDouble()).toString()
                    }
                    "-" -> {
                        (firstPart.toDouble() - secondPart.toDouble()).toString()
                    }
                    "*" -> {
                        (firstPart.toDouble() * secondPart.toDouble()).toString()
                    }
                    "/" -> {
                        if (secondPart.toInt() == 0) "DivByZero" else (firstPart.toDouble() / secondPart.toDouble()).toString()
                    }
                    else -> {""}
                }
            }
        }

    }

    private fun getPrefix(startsWithMinus: Boolean): String {
        return if (startsWithMinus) {
            "-"
        }
        else {
            ""
        }
    }

    private fun getOperator(str: String): String {
        return if (str.contains("+")){
            "+"
        } else if (str.contains("-")){
            "-"
        } else if (str.contains("*")){
            "*"
        } else
            "/"
    }

    fun onDigit(view: View) {
        handleDivByZero()
        inputTextView?.append((view as Button).text)
    }

    fun onClear(view: View) {
        inputTextView?.text = ""
    }

    fun onDotClicked(view: View) {
        handleDivByZero()
        if (inputTextView?.text?.contains('.') == false)
            inputTextView?.append(".")
    }

    private fun handleDivByZero() {
        if(inputTextView?.text?.equals("DivByZero") == true)
            inputTextView?.text = ""
    }

    fun onOperator(view: View) {
        handleDivByZero()
        if (inputTextView?.text?.isEmpty() == true && (view as Button).text == "-")
            inputTextView?.append(view.text)

        else if (isLastEntryDigit() && !entryContainsOperator())
            inputTextView?.append((view as Button).text)
    }

    private fun entryContainsOperator(): Boolean {
        inputTextView?.text?.let {
            if (it.isEmpty())
                return false
            val substr = it.substring(1)
            return substr.contains('*') || substr.contains('/')
                    || substr.contains('+') || substr.contains('-')
        }

        return false
    }

    private fun isLastEntryDigit(): Boolean {
        inputTextView?.let {
            return it.text.last().isDigit()
        }
        return false
    }

//    private fun addOnClickListenersTo(buttons: MutableList<Button>) {
//        buttons.forEach {
//            it.setOnClickListener {
//                Toast.makeText(this, "${(it as Button).text} is clicked", Toast.LENGTH_LONG).show()
//            }
//        }
//    }

//    private fun getAllButtons(): MutableList<Button> {
//        val container: LinearLayout = findViewById(R.id.container)
//        val buttons = mutableListOf<Button>()
//        container.forEach { view ->
//            iterateThrough(view, buttons)?.let { buttons.add(it as Button) }
//        }
//        return buttons
//    }
//
//    private fun iterateThrough(view: View, buttons: MutableList<Button>): View? {
//        if (view is Button) {
//            buttons.add(view)
//            return view
//        }
//        else if (view is ViewGroup)
//            return iterateThrough(view)
//        else return null
//    }
}