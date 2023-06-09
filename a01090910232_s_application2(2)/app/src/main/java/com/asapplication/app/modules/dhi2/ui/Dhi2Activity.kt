package com.asapplication.app.modules.dhi2.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi2Binding
import com.asapplication.app.modules.EditActivity
import com.asapplication.app.modules.MainActivity
import com.asapplication.app.modules.dhi2.data.viewmodel.Dhi2VM
import com.asapplication.app.modules.dhi3.ui.Dhi3Activity
import com.github.tlaabs.timetableview.Schedule

class Dhi2Activity : BaseActivity<ActivityDhi2Binding>(R.layout.activity_dhi_2) {
    private val viewModel: Dhi2VM by viewModels()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.dhi2VM = viewModel
        binding.timetable.setHeaderHighlight(2)
        binding.timetable.setHeaderHighlight(1)
        binding.timetable.setHeaderHighlight(3)
        binding.timetable.setHeaderHighlight(4)
        binding.timetable.setHeaderHighlight(5)
    }

    override fun setUpClicks(): Unit {
        binding.linearColumnonehundredtwo.setOnClickListener {
            val destIntent = Dhi3Activity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.imageMail.setOnClickListener {
            val destIntent = Dhi3Activity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.imageArrowleft.setOnClickListener {
            finish()
        }

        binding.linearColumnonehundredtwoOne.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.txtAdd.setOnClickListener {
            startActivityForResult(Intent(this, EditActivity::class.java).apply {
                putExtra("mode", REQUEST_ADD)
            }, REQUEST_ADD)
        }

        binding.timetable.setOnStickerSelectEventListener { idx, schedules ->
            startActivityForResult(
                Intent(this, EditActivity::class.java).apply {
                    putExtra("mode", REQUEST_EDIT)
                    putExtra("idx", idx)
                    putExtra("schedules", schedules)
                }, REQUEST_EDIT
            )
        }

        binding.txtAlarm.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_ADD -> {
                val item = data?.getSerializableExtra("schedules")
                (item as? ArrayList<Schedule>)?.let {
                    binding.timetable.add(it)
                }
            }
            REQUEST_EDIT -> {
                if (resultCode == EditActivity.RESULT_OK_EDIT) {
                    val idx = data?.getIntExtra("idx", -1) ?: -1
                    val item = data?.getSerializableExtra("schedules")
                    if (idx >= 0 && (item as? ArrayList<Schedule>) != null) {
                        binding.timetable.edit(idx, item)
                    }
                } else {
                    val idx = data?.getIntExtra("idx", -1) ?: -1
                    binding.timetable.remove(idx)
                }
            }
        }
    }

    companion object {
        const val REQUEST_ADD = 1
        const val REQUEST_EDIT = 2

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, Dhi2Activity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
