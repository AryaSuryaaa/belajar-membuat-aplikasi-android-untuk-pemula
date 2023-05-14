package com.surya.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val TAG = "MainActivity"
    }

//    private var btnSetValue: Button? = null
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetValue = findViewById(R.id.btn_set_value)
        tvText = findViewById(R.id.tv_text)
//        btnSetValue!!.setOnClickListener(this)
        btnSetValue.setOnClickListener(this)

        names.add("I Kadek Arya Surya Saputra")
        names.add("Sri Andani")
        names.add("Surya")
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_set_value) {
//            tvText.text ="19"
//            Log.d("MainActivity", names.toString())
            Log.d(TAG, "onClick: " + names.toString())
            val name = StringBuilder()
            for (i in 0..2) {
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}