package com.example.vk_services_olympiad_app.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.vk_services_olympiad_app.R

class ServiceMenuActivity : AppCompatActivity() {


    lateinit var imageView: ImageView
    lateinit var nameView: TextView
    lateinit var descriptionView: TextView
    lateinit var urlView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_menu)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);





        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("desc")
        val servIcon = intent.getStringExtra("servIc")
        val servUrl = intent.getStringExtra("servUrl")

        supportActionBar?.title = name
        supportActionBar?.subtitle = "Узоров Кирилл"

            imageView = findViewById(R.id.logo_image)
        nameView = findViewById(R.id.service_name)
        descriptionView = findViewById(R.id.description)
        urlView = findViewById(R.id.link)

        servIcon?.let {
            val imgUri = servIcon.toUri().buildUpon().scheme("https").build()
            imageView.load(imgUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }

        nameView.text = name
        descriptionView.text = description
        urlView.text = servUrl




    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}