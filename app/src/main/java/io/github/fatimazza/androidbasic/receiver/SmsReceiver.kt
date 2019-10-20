package io.github.fatimazza.androidbasic.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import io.github.fatimazza.androidbasic.SMSReceiverActivity

class SmsReceiver : BroadcastReceiver() {

    private val TAG = SmsReceiver::class.java.simpleName

    //Receiver processing incoming SMS metadata
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras
        try {
            if (bundle != null) {
                //PDU is packet data unit, encoded SMS messages that sent over the GSM Network
                val pdusObj = bundle.get("pdus") as Array<Any>
                for (pdu in pdusObj) {
                    val currentMessage = getIncomingSMS(pdu, bundle)
                    val smsSenderNo = currentMessage.displayOriginatingAddress
                    val smsMessage = currentMessage.displayMessageBody
                    Log.d(TAG, "SMS Receiver senderNum: $smsSenderNo; message: $smsMessage")

                    //send data to SMS Receiver Activity
                    val showSmsIntent = Intent(context, SMSReceiverActivity::class.java)
                    //start the Activity in a new task
                    // OR if the Activity already exists bring its task to the foreground
                    showSmsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    showSmsIntent.putExtra(SMSReceiverActivity.EXTRA_SMS_NO, smsSenderNo)
                    showSmsIntent.putExtra(SMSReceiverActivity.EXTRA_SMS_MESSAGE, smsMessage)
                    context.startActivity(showSmsIntent)
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "SMS Receiver Exception $e")
        }
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
