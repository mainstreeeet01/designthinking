package com.asapplication.app.modules.dhi4.ui

import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi4Binding
import com.asapplication.app.modules.dhi4.`data`.viewmodel.Dhi4VM
import kotlin.String
import kotlin.Unit

class Dhi4Activity : BaseActivity<ActivityDhi4Binding>(R.layout.activity_dhi_4) {
  private val viewModel: Dhi4VM by viewModels<Dhi4VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dhi4VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageFreeiconfist.setOnClickListener {
//      val destIntent = Two1Activity.getIntent(this, null)
//      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "DHI4ACTIVITY"

  }
}
