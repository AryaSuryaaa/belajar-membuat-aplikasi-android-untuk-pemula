package com.surya.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private var btnSetValue: Button? = null
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetValue =findViewById(R.id.btn_set_value)
        tvText = findViewById(R.id.tv_text)
//        btnSetValue!!.setOnClickListener(this)
        btnSetValue.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_set_value) {
            tvText.text ="19"
        }
    }
}