package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_smsreceiver.*

class SMSReceiverActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    lateinit var smsSenderNo: String
    lateinit var smsMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smsreceiver)

        getExtra()
        initListener()
        showSms()
    }

    private fun getExtra() {
        smsSenderNo = intent.getStringExtra(EXTRA_SMS_NO)
        smsMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
    }

    private fun initListener() {
        btn_sms_close.setOnClickListener(this)
    }

    private fun showSms() {
        title = getString(R.string.broadcast_receiver_sms_dialog_title)
        tv_sms_from.text = getString(R.string.broadcast_receiver_sms_from, smsSenderNo)
        tv_sms_message.text = getString(R.string.broadcast_receiver_sms_message, smsMessage)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_sms_close) {
            finish()
        }
    }
}
