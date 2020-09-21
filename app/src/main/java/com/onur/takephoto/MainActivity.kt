package com.onur.takephoto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePicBtn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(takePictureIntent.resolveActivity(this.packageManager) != null){
                startActivityForResult(takePictureIntent, 1)
            }
            else{
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            val takenImage = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(takenImage)

        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }


    }
}