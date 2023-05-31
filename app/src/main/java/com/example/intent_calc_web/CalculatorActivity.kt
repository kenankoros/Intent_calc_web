package com.example.intent_calc_web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var txansewr:TextView
    lateinit var edtfnum:EditText
    lateinit var edtsnum:EditText
    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttonmult:Button
    lateinit var buttondiv:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        txansewr=findViewById(R.id.Tv_answer)
        edtfnum=findViewById(R.id.Edt_fnumber)
        edtsnum=findViewById(R.id.Edt_snumber)
        buttonadd=findViewById(R.id.btn_add)
        buttonsub=findViewById(R.id.btn_sub)
        buttonmult=findViewById(R.id.btn_mult)
        buttondiv=findViewById(R.id.btn_div)


        buttonadd.setOnClickListener {
            var fnum=edtfnum.text.toString()
            val snum=edtsnum.text.toString()
            if (fnum.isEmpty()&&snum.isEmpty()){
                txansewr.text="please fill details"
            }else{
                var answer=fnum.toDouble()+snum.toDouble()
                txansewr.text=answer.toString()
            }
        }
        buttonmult.setOnClickListener {
            var fnum=edtfnum.text.toString()
            val snum=edtsnum.text.toString()
            if (fnum.isEmpty()&&snum.isEmpty()){
                txansewr.text="please fill details"
            }else{
                var answer=fnum.toDouble()*snum.toDouble()
                txansewr.text=answer.toString()
            }
        }
        buttonsub.setOnClickListener {
            var fnum=edtfnum.text.toString()
            val snum=edtsnum.text.toString()
            if (fnum.isEmpty()&&snum.isEmpty()){
                txansewr.text="please fill details"
            }else{
                var answer=fnum.toDouble()-snum.toDouble()
                txansewr.text=answer.toString()
            }
        }
        buttondiv.setOnClickListener {
            var fnum=edtfnum.text.toString()
            val snum=edtsnum.text.toString()
            if (fnum.isEmpty()&&snum.isEmpty()){
                txansewr.text="please fill details"
            }else{
                var answer=fnum.toDouble()/snum.toDouble()
                txansewr.text=answer.toString()
            }
        }

    }
}