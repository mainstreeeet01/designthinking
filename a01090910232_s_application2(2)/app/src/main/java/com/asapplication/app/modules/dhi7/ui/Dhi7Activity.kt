package com.asapplication.app.modules.dhi7.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi7Binding
import com.asapplication.app.modules.dhi6.ui.Dhi6Activity
import com.asapplication.app.modules.dhi7.`data`.model.Dhi2RowModel
import com.asapplication.app.modules.dhi7.`data`.viewmodel.Dhi7VM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class Dhi7Activity : BaseActivity<ActivityDhi7Binding>(R.layout.activity_dhi_7) {
  private val viewModel: Dhi7VM by viewModels<Dhi7VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val adapter = Adapter(viewModel.List.value?:mutableListOf())
    binding.recycler.adapter = adapter
    adapter.setOnItemClickListener(
    object : Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Dhi2RowModel) {
        onClickRecycler(view, position, item)
      }
    }
    )
    viewModel.List.observe(this) {
      adapter.updateData(it)
    }
    binding.dhi7VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtTwentyEight.setOnClickListener {
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
    item: Dhi2RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DHI7ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Dhi7Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
