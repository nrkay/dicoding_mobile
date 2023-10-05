package com.example.dicoding_project

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class moveWithParcelable : AppCompatActivity() {

    private lateinit var textViewparcalabe: TextView

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_parcelable)
        textViewparcalabe = findViewById(R.id.text_parcelable)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECETION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val textResult = "Name : ${person.name.toString()},\n Email : ${person.email},\n Age : ${person.age},\n Location : ${person.city}"
            textViewparcalabe.text = textResult
        }
    }
}