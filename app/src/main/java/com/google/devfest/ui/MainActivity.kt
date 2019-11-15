package com.google.devfest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.devfest.R
import com.google.devfest.repo.CustomerRepo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val customerRepo by lazy {
        CustomerRepo.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_random.setOnClickListener {
            val name = customerRepo.formattedName
            tv_name.text = name
        }

    }

}
