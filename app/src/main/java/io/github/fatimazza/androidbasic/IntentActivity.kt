package io.github.fatimazza.androidbasic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMove: Button = findViewById(R.id.btn_move_activity)
        btnMove.setOnClickListener(this)

        val btnMoveWithDta: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDta.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this, IntentMoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveIntentWithData = Intent(this, IntentMoveDataActivity::class.java)
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_NAME, "Dicoding Academy")
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_AGE, 27)
                startActivity(moveIntentWithData)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}