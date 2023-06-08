package com.asapplication.app.modules.dhi11.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi11Binding
import com.asapplication.app.modules.MainActivity
import com.asapplication.app.modules.dhi11.`data`.viewmodel.Dhi11VM
import com.asapplication.app.modules.two.ui.TwoActivity
import kotlin.String
import kotlin.Unit

class Dhi11Activity : BaseActivity<ActivityDhi11Binding>(R.layout.activity_dhi_11) {
    private val viewModel: Dhi11VM by viewModels<Dhi11VM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.dhi11VM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
        binding.imageHome.setOnClickListener {
            finish()
        }
        binding.btnAlarm.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    companion object {
        const val TAG: String = "DHI11ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, Dhi11Activity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
