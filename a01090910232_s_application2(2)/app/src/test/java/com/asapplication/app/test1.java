package com.asapplication.app;

/*
class MainActivity : AppCompatActivity() {
    var alarmManager: AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//알람관리자 소환
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
    }

    fun clickBtn(view: View?) {
//10초 후에 알람 설정.. (10초 후에 AlarmActivity를 실행!)

//먼저 알람에 설정한 PendingIntent생성
        val intent = Intent(this, AlarmActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        //requestCode [10]는 내가 임의로 식별할 번호, flags 는 중복된거 오면 어떡할 건지 FLAG_UPDATE_CURRENT : 같은게 중복되면 현재껄로 바꾼다.[해당 클래스이름을 쓰고 .FLAG 여러개가 나온다.]

//알람 매니저에게 알람 설정
//Marshmallow 버전부터 Doz(낮잠)모드가 생김
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager!!.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 10000,
                pendingIntent
            )
        } else {
            alarmManager!!.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 10000,
                pendingIntent
            ) //AlarmManager.RTC랑 ELAPSED는 동작안함.
        }
    }

    fun clickBtn2(view: View?) {
//반복 알람 : 10초 후에 처음 알람, 20초마다 반복 알람

//20초마다 발동할 Broadcast Receiver를
//PendingIntent로 생성
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(this, 20, intent, PendingIntent.FLAG_UPDATE_CURRENT)

//애석하게KitKet이후 버전부터는 Repeat 기능이 없음.
//그래서 알람을 하려면 행운의 편지 기법을 도입할 겁니다.
//첫 알람 설정(10초 후에)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager!!.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 10000,
                pendingIntent
            )
        } else {
            alarmManager!!.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 10000,
                pendingIntent
            )
        }
    }

    fun clickBtn3(view: View?) {
//반복 알람 종료

//알람매니저에 보류되어 있는
//PendingIntent를 cancel하면 됨
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(this, 20, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager!!.cancel(pendingIntent)
    }

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
    var timeSetListener =
        OnTimeSetListener { timePicker, hour, minute -> //Toast.makeText(MainActivity.this, hour+":"+minute, Toast.LENGTH_SHORT).show();
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
        }
}

*/