package com.example.vk_services_olympiad_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.vk_services_olympiad_app.R
import com.example.vk_services_olympiad_app.view_model.ServicesViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Проекты VK"
        supportActionBar?.subtitle = "Узоров Кирилл 2023"




    }
}