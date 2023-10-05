package com.example.dicoding_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class getBackData : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn: Button;
    private lateinit var groupButton: RadioGroup;

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_back_data)
        btn= findViewById(R.id.btn_kirim)
        groupButton= findViewById(R.id.rg_group)

        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id  == R.id.btn_kirim){
            if (groupButton.checkedRadioButtonId > 0 ) {
                var value = 0;
                when(groupButton.checkedRadioButtonId) {
                    R.id.result10 -> value = 10;
                    R.id.result11 -> value = 11;
                    R.id.result9 -> value = 9;
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}