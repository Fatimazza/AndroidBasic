package io.github.fatimazza.androidbasic.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage

class SmsReceiver : BroadcastReceiver() {

    private val TAG = SmsReceiver::class.java.simpleName

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("SmsReceiver.onReceive() is not implemented")
    }

    private fun getIncomingSMS(aObject: Any, bundle: Bundle): SmsMessage {
        //get object currentSMS from SmsMessage
        val currentSms: SmsMessage
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val format = bundle.getString("format")
            currentSms = SmsMessage.createFromPdu(aObject as ByteArray, format)
        } else currentSms = SmsMessage.createFromPdu(aObject as ByteArray)
        return currentSms
    }

}
