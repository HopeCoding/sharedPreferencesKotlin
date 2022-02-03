package com.hopecoding.usernamestorage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var findusername: String? = null

    //Şimdi hata verme sonradan tanımlıycak demektir.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences

        sharedPreferences = this.getSharedPreferences(
            "com.hopecoding.usernamestorage",
            Context.MODE_PRIVATE
        )


        findusername = sharedPreferences.getString("username", "")

        if(findusername!=""){
            textView.text="Kaydedilen Kullanıcı Adı:${findusername}"
        }else{
            textView.text="Kayıtlı kullanıcı adı yoktur."

        }

    }

    fun kaydet(view: View) {

        val username = editText.text.toString()
        if (username == "") {
            Toast.makeText(this, "Lütfen Bir Değer Giriniz", Toast.LENGTH_LONG).show()

        } else {
            sharedPreferences.edit().putString("username", username).apply()
            textView.text = "Kaydedilen Kullanıcı Adı:${username}"
        }

    }

    fun sil(view: View) {

        findusername=sharedPreferences.getString("username","")

        if(findusername!=""){
            sharedPreferences.edit().remove("username").apply()
            textView.text="Kaydedilen Kullanıcı Adı Silindi."
        }

    }
}