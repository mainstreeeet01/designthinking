package com.asapplication.app.modules.dhi2.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi2Binding
import com.asapplication.app.modules.dhi2.`data`.viewmodel.Dhi2VM
import com.asapplication.app.modules.dhi3.ui.Dhi3Activity
import kotlin.String
import kotlin.Unit

class Dhi2Activity : BaseActivity<ActivityDhi2Binding>(R.layout.activity_dhi_2) {
  private val viewModel: Dhi2VM by viewModels<Dhi2VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dhi2VM = viewModel
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
  }

  companion object {
    const val TAG: String = "DHI2ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Dhi2Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
