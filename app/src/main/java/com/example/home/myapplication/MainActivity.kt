package com.example.home.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score1 = 0
    var score2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateScore1()
        updateScore2()

        addOneScore1_Button.setOnClickListener {
            score1++
            updateScore1()
        }

        addOneScore2_Button.setOnClickListener {
            score2++
            updateScore2()
        }


        addFoul1Button.setOnClickListener {
            if (checkScore(score1)) {
                score1--
                updateScore1()
            }
        }

        addFoul2_Button.setOnClickListener {
            if (checkScore(score2)) {
                score2--
                updateScore2()
            }
        }

        reset_Button.setOnClickListener {
            score1 = 0
            score2 = 0
            updateScore1()
            updateScore2()
        }
    }

    fun checkScore(score: Int): Boolean {
        if ((score - 1) >= 0) {
            return true
        }
        return false
    }

    fun updateScore1() {
        val score1Stringify  = if(score1==1) "$score1 Point" else "$score1 Points"
        Score1_Text_View.text = score1Stringify
    }

    fun updateScore2() {
        val score2Stringify  = if(score2==1) "$score2 Point" else "$score2 Points"
        Score2_Text_View.text = score2Stringify
    }
}
