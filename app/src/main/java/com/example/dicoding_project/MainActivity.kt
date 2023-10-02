package com.example.dicoding_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_switch: Button
    private lateinit var btn_data: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_switch = findViewById(R.id.btn_switch)
        btn_data= findViewById(R.id.btn_move_data)
        btn_switch.setOnClickListener(this)
        btn_data.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_switch->{
                val moveIn = Intent(this@MainActivity, moveActivity::class.java)
                startActivity(moveIn)
            }
            R.id.btn_move_data->{
                val intentData = Intent(this@MainActivity, moveWithData::class.java)
                intentData.putExtra(moveWithData.EXTRA_NAME, "Nur Khairiyah")
                intentData.putExtra(moveWithData.EXTRA_AGE, 20)

                startActivity(intentData)
            }
        }
    }

}