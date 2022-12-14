package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNum = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOp)
            editText.setText("")
        isNewOp = false
        var buclick = editText.text.toString()
        var buselect = view as Button
        when (buselect.id){
            bu9.id ->  {buclick += "9"}
            bu8.id ->  {buclick += "8"}
            bu7.id ->  {buclick += "7"}
            bu6.id ->  {buclick += "6"}
            bu5.id ->  {buclick += "5"}
            bu4.id ->  {buclick += "4"}
            bu3.id ->  {buclick += "3"}
            bu2.id ->  {buclick += "2"}
            bu1.id ->  {buclick += "1"}
            bu0.id ->  {buclick += "0"}
            bu00.id ->  {buclick += "00"}
            buDecimal.id ->  {buclick += "."}
            buLeftBracket.id ->  {buclick += "("}
            buRightBracket.id ->  {buclick += ")"}
            buSign.id ->  {buclick = "-$buclick"}



        }
        editText.setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOp= true
        oldNum=editText.text.toString()
        var buselect = view as Button
        when(buselect.id){
            buDivide.id -> {op = "/"}
            buMultiply.id -> {op = "*"}
            buAdd.id -> {op = "+"}
            buSubtract.id -> {op = "-"}

        }
    }

    fun equaltoEvent(view: View) {
        var newNum = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNum.toDouble() + newNum.toDouble()}
            "-" -> {result = oldNum.toDouble() - newNum.toDouble()}
            "*" -> {result = oldNum.toDouble() * newNum.toDouble()}
            "/" -> {result = oldNum.toDouble() / newNum.toDouble()}
            "^" -> {result = oldNum.toDouble().pow(newNum.toDouble())}
        }
        editText.setText(result.toString())
    }

    fun clearEvent(view: View) {
        editText.setText("0")
        isNewOp=true
    }

    fun percentageEvent(view: View) {
        var no = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp= true
    }

    fun backspaceEvent(view: View) {
        var bksp = editText.text.toString().drop(1)
        editText.setText(bksp)
    }

}