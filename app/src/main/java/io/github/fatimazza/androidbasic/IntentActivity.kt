package io.github.fatimazza.androidbasic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.fatimazza.androidbasic.model.Person

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val REQUEST_CODE = 110;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMove: Button = findViewById(R.id.btn_move_activity)
        btnMove.setOnClickListener(this)

        val btnMoveWithDta: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDta.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
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
            R.id.btn_move_activity_object -> {
                val person = Person("Izza", 27, "mail@gmail.com", "Yogya")
                val moveIntentWithObject = Intent(this, IntentMoveObjectActivity::class.java)
                    .apply { putExtra(IntentMoveObjectActivity.EXTRA_PERSON, person) }
                startActivity(moveIntentWithObject)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveIntentForResult = Intent(this, IntentMoveForResultActivity::class.java)
                startActivityForResult(moveIntentForResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == IntentMoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(IntentMoveForResultActivity.EXTRA_VALUE, 0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }
}
