package com.asapplication.app.modules

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Vibrator
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.Date


class AlarmReceiver : BroadcastReceiver() {
    @RequiresApi(api = Build.VERSION_CODES.Q)  // implement onReceive() method
    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, Date().toString(), Toast.LENGTH_SHORT).show()

//반복알람을 위해 알람이 울리면
//다시 새로운 알람을 설정

//알람관리자 소환

//반복알람을 위해 알람이 울리면
//다시 새로운 알람을 설정

//알람관리자 소환
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, AlarmReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(context, 20, intent, PendingIntent.FLAG_UPDATE_CURRENT)

//알람 설정(20초 후)

//알람 설정(20초 후)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 20000,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 20000,
                pendingIntent
            )
        }

        // we will use vibrator first
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        vibrator.vibrate(4000)
        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show()
        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        // setting default ringtone
        val ringtone = RingtoneManager.getRingtone(context, alarmUri)

        // play ringtone
        ringtone.play()
    }
}