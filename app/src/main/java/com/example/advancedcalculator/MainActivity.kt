package com.example.advancedcalculator

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var display:TextView
    private lateinit var btn0:Button
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btnplus:Button
    private lateinit var btnminus:Button
    private lateinit var btndivide:Button
    private lateinit var btnmult:Button
    private lateinit var btnequile:Button
    private lateinit var btnC:Button
    private lateinit var btnDel:Button
    private lateinit var btnpirod:Button
    private lateinit var btnsign:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        display = findViewById(R.id.tvNumber)
        display.text = viewModel.displayText


        btn1 = findViewById(R.id.b1)
        btn1.setOnClickListener { viewModel.setNum('1'); display.text = viewModel.displayText }

        btn2 = findViewById(R.id.b2)
        btn2.setOnClickListener { viewModel.setNum('2'); display.text = viewModel.displayText }

        btn3 = findViewById(R.id.b3)
        btn3.setOnClickListener { viewModel.setNum('3'); display.text = viewModel.displayText }

        btn4 = findViewById(R.id.b4)
        btn4.setOnClickListener { viewModel.setNum('4'); display.text = viewModel.displayText }

        btn5 = findViewById(R.id.b5)
        btn5.setOnClickListener { viewModel.setNum('5'); display.text = viewModel.displayText }

        btn6 = findViewById(R.id.b6)
        btn6.setOnClickListener { viewModel.setNum('6'); display.text = viewModel.displayText }

        btn7 = findViewById(R.id.b7)
        btn7.setOnClickListener { viewModel.setNum('7'); display.text = viewModel.displayText }

        btn8 = findViewById(R.id.b8)
        btn8.setOnClickListener { viewModel.setNum('8'); display.text = viewModel.displayText }

        btn9 = findViewById(R.id.b9)
        btn9.setOnClickListener { viewModel.setNum('9'); display.text = viewModel.displayText }

        btn0 = findViewById(R.id.b0)
        btn0.setOnClickListener { viewModel.setNum('0'); display.text = viewModel.displayText }

        btnC = findViewById(R.id.bc)
        btnC.setOnClickListener { viewModel.clearAll(); display.text = viewModel.displayText }

        btnequile = findViewById(R.id.bEq)
        btnequile.setOnClickListener { viewModel.calculate(); display.text = viewModel.displayText }

        btnDel = findViewById(R.id.del)
        btnDel.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.displayText }

        btnminus = findViewById(R.id.bMin)
        btnminus.setOnClickListener {
            viewModel.handleOperator('-'); display.text = viewModel.displayText
        }

        btnpirod = findViewById(R.id.bPeriod)
        btnpirod.setOnClickListener {
            viewModel.onClickDecimal(); display.text = viewModel.displayText
        }

        btnsign = findViewById(R.id.plusMin)
        btnsign.setOnClickListener {
            viewModel.onClickPlusMinus(); display.text = viewModel.displayText
        }

        btndivide = findViewById(R.id.bDivide)
        btndivide.setOnClickListener {
            viewModel.handleOperator('/'); display.text = viewModel.displayText
        }

        btnmult = findViewById(R.id.bMul)
        btnmult.setOnClickListener {
            viewModel.handleOperator('*'); display.text = viewModel.displayText
        }

        btnplus = findViewById(R.id.bPlus)
        btnplus.setOnClickListener {
            viewModel.handleOperator('+'); display.text = viewModel.displayText
        }


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            display.setPadding(0,0,24,0)
            display.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            display.setPadding(0,24,24,0)
            display.textSize = 32f
        }
    }
}