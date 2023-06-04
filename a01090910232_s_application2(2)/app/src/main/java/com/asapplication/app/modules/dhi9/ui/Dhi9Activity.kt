package com.asapplication.app.modules.dhi9.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi9Binding
import com.asapplication.app.modules.dhi11.ui.Dhi11Activity
import com.asapplication.app.modules.dhi9.`data`.viewmodel.Dhi9VM
import kotlin.String
import kotlin.Unit

class Dhi9Activity : BaseActivity<ActivityDhi9Binding>(R.layout.activity_dhi_9) {
  private val viewModel: Dhi9VM by viewModels<Dhi9VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dhi9VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = Dhi11Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "DHI9ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Dhi9Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
