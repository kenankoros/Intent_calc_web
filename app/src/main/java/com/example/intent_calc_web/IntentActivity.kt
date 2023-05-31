package com.example.intent_calc_web

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var buttonsms: Button
    lateinit var buttoncamera: Button
    lateinit var buttoncall: Button
    lateinit var buttondial: Button
    lateinit var buttonemail: Button
    lateinit var buttonshare: Button
    lateinit var buttonmpesa: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        buttonsms = findViewById(R.id.btn_sms)
        buttoncall = findViewById(R.id.btn_call)
        buttondial = findViewById(R.id.btn_dial)
        buttoncamera = findViewById(R.id.btn_camera)
        buttonshare = findViewById(R.id.btn_share)
        buttonmpesa = findViewById(R.id.btn_mpesa)
        buttonemail = findViewById(R.id.btn_email)

        buttonsms.setOnClickListener {
            val uri = Uri.parse("smsto:0717531599")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("good afternoon", "how are you doing today")
            startActivity(intent)
        }
        buttonemail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "kenkip654@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }


        buttondial.setOnClickListener {
            val phone = "+254 717531599"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)


        }
        buttonmpesa.setOnClickListener {

            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }



        buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }


        buttoncamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)


        }
        buttoncall.setOnClickListener {

            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254 717531599"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)

            }
        }
    }
}