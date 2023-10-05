package com.example.dicoding_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputWidth: EditText
    private lateinit var inputHeight: EditText
    private lateinit var inputLength: EditText
    private lateinit var result: TextView
    private lateinit var btn: Button
companion object{
    private const val STATE_RESULT = "state_result"
}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputWidth = findViewById(R.id.edt_width)
        inputHeight = findViewById(R.id.edt_height)
        inputLength = findViewById(R.id.edt_length)
        btn = findViewById(R.id.btn_result)
        result = findViewById(R.id.result)
        btn.setOnClickListener(this)

//        menampilkan value yg ada di bundle
        if (savedInstanceState != null) {
            val hasil = savedInstanceState.getString(STATE_RESULT)
            result.text = hasil
        }
    }

//    method pertama yg akan dibuat agar result tetap muncul bila hp rotation
//    hasil perhitungan yang ditampilkan pada tvResult dimasukkan pada bundle kemudian disimpan isinya.
//    Dalam konteks Android, Bundle adalah bagian dari Android's android.os package, dan Anda dapat menggunakannya untuk mengirim dan menerima data antara komponen aplikasi Anda.
//    Untuk menyimpan data disini menggunakan konsep Key-Value, dengan STATE_RESULT sebagai key dan isi dari tvResult sebagai value.
//    Fungsi onSaveInstanceState akan dipanggil secara otomatis sebelum sebuah Activity hancur.
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(STATE_RESULT, result.text.toString())
//    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }


    override fun onClick(view: View?) {
        if (view?.id==R.id.btn_result){
            val width = inputWidth.text.toString().trim()
            val height = inputHeight.text.toString().trim()
            val length = inputLength.text.toString().trim()
            var isEmpaty = false
            if (width.isEmpty()){
                isEmpaty = true
                inputWidth.error = "Wajib diisi"
            }
            if (height.isEmpty()) {
                isEmpaty = true
                inputHeight.error = "Wajib diisi"
            }
            if (length.isEmpty()) {
                isEmpaty = true
                inputLength.error = "Wajib diisi"
            }
            if (!isEmpaty){
                val volume = height.toDouble() * width.toDouble() * length.toDouble()
                result.text = volume.toString()
            }
        }
    }
}