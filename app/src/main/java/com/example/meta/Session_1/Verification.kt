package com.example.meta.Session_1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.meta.R

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verrif)
        val n1 : EditText = findViewById(R.id.editText1)
        val n2 : EditText = findViewById(R.id.editText2)
        val n3 : EditText = findViewById(R.id.editText3)
        val n4 : EditText = findViewById(R.id.editText4)
        val n5 : EditText = findViewById(R.id.editText5)
        val n6 : EditText = findViewById(R.id.editText6)
        val DROPDATABASE : Button = findViewById(R.id.enterButton)
        val fckGoBack : Button = findViewById(R.id.createButton)
        val countdown : TextView = findViewById(R.id.TimeToCode)
        var _count : Int = 60
        var handler: Handler = Handler()
        val resend : TextView = findViewById(R.id.SandCode)
        lateinit var editor: SharedPreferences.Editor

        DROPDATABASE.setOnClickListener{
            if(n1.text.isNotEmpty()&&n2.text.isNotEmpty()&&n3.text.isNotEmpty()&&n4.text.isNotEmpty()&&n5.text.isNotEmpty()&&n6.text.isNotEmpty()){
                goToNewPass()
            }
        }

        fckGoBack.setOnClickListener{
            fuckGoBack()
        }


        n1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    n2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        n2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    n3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        n3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    n4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        n4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    n5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        n5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    n6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        fun bombUkraineCountdown() {
            handler.postDelayed({
                if(_count == 0){

                    resend.isVisible = true
                    countdown.isVisible = false
                    resend.setOnClickListener{
                        resend.isVisible = false
                        countdown.isVisible = true
                        _count = 60
                    }
                }
                _count -=1
                countdown.text = "Получить код повторно через " + _count.toString() + "c."
                bombUkraineCountdown()

            }, 1000)
        }
        bombUkraineCountdown()
    }
    fun goToNewPass(){
        val intent = Intent(this, New_Password::class.java)
        startActivity(intent)
    }

    fun fuckGoBack(){
        val intent = Intent(this, Registration::class.java)
        startActivity(intent)
    }


}