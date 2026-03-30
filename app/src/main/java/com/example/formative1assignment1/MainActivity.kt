package com.example.formative1assignment1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtInput : EditText
    lateinit var txtOutput : TextView
    lateinit var btnSubmit : Button
    lateinit var btnClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)
        txtOutput = findViewById(R.id.txtOutput)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnClear = findViewById(R.id.btnClear)

        btnSubmit.setOnClickListener {
            val time = txtInput.text.toString()
                .trim()
                .lowercase()


            //I've implimented the logic that was provided but with a slight change

            Log.d( "SocialSpark", "User Input: $time" )


            if (time.isEmpty()){

            }else if (time.contains("morning")) {
                Log.d("APP_DEBUG","Morning Executed")
                txtOutput.setText("Send a 'Good Morning' message to your friends and family. ")

            }else if (time.contains("mid-day")) {
                Log.d("APP_DEBUG", "Mid-Day executed ")
                txtOutput.setText("Share something interesting with your friends and family. ")

            }else if (time.contains("afternoon")) {
                Log.d("APP_DEBUG", "Afternoon executed")
                txtOutput.setText("Send a 'Thinking of you' message to your spouse. ")

            }else if (time.contains("snack")&& time.contains("time") ) {
                Log.d("APP_DEBUG", "Snack Time executed")
                txtOutput.setText("Call a loved one for 5-min to catch up ")

            }else if (time.contains("dinner")){
                Log.d( "APP_DEBUG", "Dinner executed")
                txtOutput.setText("Leave a thoughtful message on a loved ones post")

            }else if (time.contains("after")&& time.contains("dinner")) {
                Log.d("APP_DEBUG", "After Dinner executed")
                txtOutput.setText("Leave a thoughtful message on a loved one ")

            }else if (time.contains("night")) {
                Log.d("APP_DEBUG", "Night executed")
                txtOutput.setText("Leave a 'Good night' message to your loved ones ")


                Log.d("SocialSpark", "Displaying suggestions : ${txtOutput.text}")

            }

            // Using Log.d to debug my code


            txtOutput.setTextColor(getColor(R.color.black))



        }
        btnClear.setOnClickListener {
            txtInput.text.clear()
            txtOutput.text = ""
            Log.d("SocialSpark", "UI has been reset")
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}