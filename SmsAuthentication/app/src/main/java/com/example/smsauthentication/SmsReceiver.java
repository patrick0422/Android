package com.example.smsauthentication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;

public class SmsReceiver extends BroadcastReceiver {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd : HH-mm");
    private static String TAG = "SMSReceiver";
    private static String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static String KEYWORD = "태웅투자증권";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Log.d(TAG, "onReceive 호출");

            Bundle bundle = intent.getExtras();
            SmsMessage[] messages = parseSmsMessage(bundle);


            String content = messages[0].getMessageBody();
            Log.d(TAG, "Content = " + content);
            if (content.contains(KEYWORD)) {
                String authCode = content.substring(content.indexOf("[") + 1, content.lastIndexOf("]"));
                Log.d(TAG, "AuthCode = " + authCode);

                sendToActivity(context, authCode);
            }
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for (int i = 0; i < objs.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[])objs[i]);
        }


        return messages;
    }
    private void sendToActivity(Context context, String authCode) {
        Intent intent = new Intent(context, MainActivity.class);

        intent.addFlags(
                 Intent.FLAG_ACTIVITY_NEW_TASK
                |Intent.FLAG_ACTIVITY_SINGLE_TOP
                |Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("authCode", authCode);
        context.startActivity(intent);
    }
}