package com.asapplication.app.modules.dhi8.ui

import android.view.View
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi8Binding
import com.asapplication.app.modules.dhi6.ui.Dhi6Activity
import com.asapplication.app.modules.dhi8.`data`.model.Dhi3RowModel
import com.asapplication.app.modules.dhi8.`data`.viewmodel.Dhi8VM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class Dhi8Activity : BaseActivity<ActivityDhi8Binding>(R.layout.activity_dhi_8) {
  private val viewModel: Dhi8VM by viewModels<Dhi8VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val adapter = Adapter(viewModel.List.value?:mutableListOf())
    binding.recycler.adapter = adapter
    adapter.setOnItemClickListener(
    object : Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Dhi3RowModel) {
        onClickRecycler(view, position, item)
      }
    }
    )
    viewModel.List.observe(this) {
      adapter.updateData(it)
    }
    binding.dhi8VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtFortyThree.setOnClickListener {
      val destIntent = Dhi6Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecycler(
    view: View,
    position: Int,
    item: Dhi3RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DHI8ACTIVITY"

  }
}
