package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val numberDisplay = findViewById<TextView>(R.id.number_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text?.toString()?.trim() ?: ""
            val numberInput = findViewById<TextInputEditText>(R.id.number_input)
                ?.text?.toString()?.trim() ?: ""

            if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                return@setOnClickListener
            }

            if (numberInput.length != 11) {
                Toast.makeText(this, "Student number has to be 11 digits long", Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                return@setOnClickListener
            }

            nameDisplay.text = "${getString(R.string.name_greet)} $nameInput"
            numberDisplay.text = "${getString(R.string.number_value)} $numberInput"
            numberDisplay.visibility = View.VISIBLE
        }
    }
}