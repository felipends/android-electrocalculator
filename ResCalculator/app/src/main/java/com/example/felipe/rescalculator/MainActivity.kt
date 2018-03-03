package com.example.felipe.rescalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var resList  = arrayListOf(0.0)
    var resEqui : Double = 0.0
    var resEquiP : Double = 0.0

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

        clearBt.setOnClickListener {
            resList.clear()
            resVal.text.clear()
            resEqs.text = "0.0oms"
            resEqp.text = "0.0oms"
            println(resList)
        }

        resEquiBt.setOnClickListener {
            val df = DecimalFormat("#.##")

            resEqui = resList.sum()
            if(resEqui%1000 == 0.0) {
                resEqs.text = df.format(resEqui/1000).toString() + "Kohms"
                println(resEqui)
            }else{
                resEqs.text = df.format(resEqui).toString() + "ohms"
                println(resEqui)
            }

            for (i in resList) {
                if (i == 0.0) {
                    resEquiP = 0.0
                }else{
                    resEquiP += (1 / i)
                }
            }

            resEquiP = 1/resEquiP

            var textRes = df.format(resEquiP).toString()

            if(resEquiP%1000 == 0.0) {
                textRes = df.format(resEquiP/1000).toString()
                resEqp.text = textRes + "Kohms"
                println(resEquiP)
                resList.clear()
                resEquiP = 0.0
            }else{
                resEqp.text = textRes + "ohms"
                println(resEquiP)
                resList.clear()
                resEquiP = 0.0
            }
        }
    }
}

