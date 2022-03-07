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

    fun onDigit(view: View){
        inputTextView?.append((view as Button).text)
    }

    fun onClear(view: View){
        inputTextView?.text = ""
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