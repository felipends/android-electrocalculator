package com.example.felipe.rescalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var resList  = arrayListOf(0.0)
    var resEqui : Double = 0.0
    var resEquiP : Double = 0.0
    var ind : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resVal.setOnClickListener {
            resVal.text.clear()
        }

        addResBt.setOnClickListener {
            val newRes = resVal.text.toString()
            val res = newRes.toDouble()
            resList.add(res)
            resVal.text.clear()
            println(resList)
        }

        resEquiBt.setOnClickListener {
            resEqui = resList.sum()
            resEqs.text = resEqui.toString() + "ohms"
            println(resEqui)

            val df = DecimalFormat("#.##")

            for (i in resList) {
                if (i == 0.0) {
                    resEquiP = 0.0
                }else{
                    resEquiP += (1 / i.toDouble())
                }
            }

            resEquiP = 1/resEquiP

            val textRes = df.format(resEquiP).toString()
            resEqp.text = textRes + "ohms"
            println(resEquiP)
            resList.clear()
            resEquiP = 0.0
        }
    }
}

