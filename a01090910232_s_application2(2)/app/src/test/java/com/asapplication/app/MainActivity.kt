package com.asapplication.app

//import android.R

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale


//class MainActivity : BaseActivity<LayoutProgressDialogBinding>(R.layout.layout_progress_dialog) {

//    override fun onInitialized() {

//    }

//    override fun setUpClicks() {

//    }
//}


class MainActivity : AppCompatActivity() {
    var alarmTimePicker: TimePicker? = null
    var pendingIntent: PendingIntent? = null
    var alarmManager: AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmTimePicker = findViewById<View>(R.id.timePicker) as TimePicker
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
    }


    // OnToggleClicked() method is implemented the time functionality
    fun OnToggleClicked(view: View) {
        var time: Long
        if ((view as ToggleButton).isChecked) {
            Toast.makeText(this@MainActivity, "ALARM ON", Toast.LENGTH_SHORT).show()
            val calendar = Calendar.getInstance()

            // calendar is called to get current time in hour and minute
            calendar[Calendar.HOUR_OF_DAY] = alarmTimePicker!!.currentHour
            calendar[Calendar.MINUTE] = alarmTimePicker!!.currentMinute

            // using intent i have class AlarmReceiver class which inherits
            // BroadcastReceiver
            val intent = Intent(this, AlarmReceiver::class.java)

            // we call broadcast using pendingIntent
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
            time = calendar.timeInMillis - calendar.timeInMillis % 60000
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                time =
                    if (Calendar.AM_PM == 0) time + 1000 * 60 * 60 * 12 else time + 1000 * 60 * 60 * 24
            }
            // Alarm rings continuously until toggle button is turned off
            alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent)
            // alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (time * 1000), pendingIntent);
        } else {
            alarmManager!!.cancel(pendingIntent)
            Toast.makeText(this@MainActivity, "ALARM OFF", Toast.LENGTH_SHORT).show()
        }

        val alarmUp = PendingIntent.getBroadcast(
            this, 0,
            Intent("com.my.package.MY_UNIQUE_ACTION"),
            PendingIntent.FLAG_NO_CREATE
        ) != null

        if (alarmUp) {
            Log.d("myTag", "Alarm is already active")
        }
    }

    /*
     //멤버변수
     var Year = 0
     var Month = 0
     var Day = 0
     var Hour = 0
     var Min = 0
     fun clickBtn4(view: View?) {
 //특정 날짜에 알람 설정하기

 //날짜선택 다이얼로그 보이기
         val calendar = GregorianCalendar(Locale.KOREA)
         val dialog = DatePickerDialog(
             this, onDateSetListener,
             calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH]
         )
         dialog.show()
     }

     //날짜선택 리스너
     var onDateSetListener =
         OnDateSetListener { datePicker, year, month, day -> //Toast.makeText(MainActivity.this, year+","+(month+1)+","+day+"", Toast.LENGTH_SHORT).show();

             //선택한 날짜 저장
             Year = year
             Month = month
             Day = day

                         //시간 선택 다이얼로그 보이기
                         val calendar = GregorianCalendar(Locale.KOREA)
                         val dialog = TimePickerDialog(
                             this@MainActivity, timeSetListener,
                             calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], true
                         )
                         dialog.show()
                     }


                         //시간 선택 리스너
                 private val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                         Hour = hour
                         Min = minute

                         //선택한 날짜와 시간으로 알람 설정
                         val calendar = GregorianCalendar(Year, Month, Day, Hour, Min)

                         //알람시간에 AlarmActivity 실행되도록.
                         val intent = Intent(this@MainActivity, AlarmActivity::class.java)
                         val pendingIntent = PendingIntent.getActivity(
                             this@MainActivity,
                             30,
                             intent,
                             PendingIntent.FLAG_UPDATE_CURRENT
                         )
                         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                             alarmManager!!.setExactAndAllowWhileIdle(
                                 AlarmManager.RTC_WAKEUP,
                                 calendar.timeInMillis,
                                 pendingIntent
                             )
                         } else {
                             alarmManager!!.setExact(
                                 AlarmManager.RTC_WAKEUP,
                                 calendar.timeInMillis,
                                 pendingIntent
                             )
                         }
                         */


        }









