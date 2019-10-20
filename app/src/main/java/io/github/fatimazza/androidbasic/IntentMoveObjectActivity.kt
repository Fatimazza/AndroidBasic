package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.fatimazza.androidbasic.model.Person

class IntentMoveObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_object)

        val tvObjectReceived = findViewById<TextView>(R.id.tv_object_received)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)

        val text =
            "Name ${person.name}, \nAge ${person.age}, \nEmail ${person.email} \nCity ${person.city}"
        tvObjectReceived.text = text
    }
}
