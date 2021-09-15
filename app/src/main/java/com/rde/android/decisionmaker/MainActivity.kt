package com.rde.android.decisionmaker

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.security.SecureRandom


class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        btnAnswer.setOnClickListener { updateTextBox() }
        tvAnswer.text =""


    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        Thread.sleep(150)
        val random = SecureRandom()
        random.setSeed(random.generateSeed(120))

        return random.nextInt(end - start + 1) + start
    }

    fun updateTextBox()
    {

        handler.postDelayed({tvAnswer.text = ""}, 0)
        tvAnswer.invalidate()
        val dodo = arrayOf("Yes", "No", "Maybe", "\nAsk me\n  later")
        val anIndex = rand(0, 3)

        handler.postDelayed({tvAnswer.text = dodo[anIndex]}, 300)
        handler.postDelayed({tvAnswer.text = ""}, 3000)


    }
}