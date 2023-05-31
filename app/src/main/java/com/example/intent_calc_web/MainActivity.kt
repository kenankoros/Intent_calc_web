package com.example.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Buttoncalc:Button
    lateinit var buttonint:Button
    lateinit var buttonweb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Buttoncalc=findViewById(R.id.btn_calculator)
        Buttoncalc.setOnClickListener {
            val calc=Intent(this,CalculatorActivity::class.java)
            startActivity(calc)
        }
        buttonint=findViewById(R.id.btn_intent)
        buttonint.setOnClickListener {
            val int=Intent(this,IntentActivity::class.java)
            startActivity(int)
        }
        buttonweb=findViewById(R.id.btn_web)
        buttonweb.setOnClickListener {
            val web=Intent(this,WebActivity::class.java)
            startActivity(web)
        }
    }
}