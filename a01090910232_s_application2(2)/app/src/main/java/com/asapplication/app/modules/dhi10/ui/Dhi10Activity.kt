package com.asapplication.app.modules.dhi10.ui

import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi10Binding
import com.asapplication.app.modules.dhi10.`data`.viewmodel.Dhi10VM
import com.asapplication.app.modules.dhi9.ui.Dhi9Activity
import kotlin.String
import kotlin.Unit

class Dhi10Activity : BaseActivity<ActivityDhi10Binding>(R.layout.activity_dhi_10) {
  private val viewModel: Dhi10VM by viewModels<Dhi10VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dhi10VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = Dhi9Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "DHI10ACTIVITY"

  }
}
