package com.example.day2

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private companion object {
        const val URL = "https://edge.app/wp-content/uploads/2018/10/BartSimpsonOpenSource.png"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.image)

//        val netImage = NetImage(URL, object : ImageCallBack {
//            override fun failed() = runOnUiThread { Snackbar.make(imageView, "failed", Snackbar.LENGTH_SHORT).show() }
//
//            override fun success(bitmap: Bitmap) = runOnUiThread { imageView.setImageBitmap(bitmap) }
//        })
//        netImage.start();


        Picasso.get().load(URL)
            .placeholder(android.R.drawable.ic_media_pause)
            .error(android.R.drawable.ic_dialog_alert)
            .into(imageView)

    }
}