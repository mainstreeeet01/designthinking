package com.asapplication.app.modules.dhi6.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi6Binding
import com.asapplication.app.modules.dhi6.`data`.model.Dhi1RowModel
import com.asapplication.app.modules.dhi6.`data`.viewmodel.Dhi6VM
import com.asapplication.app.modules.dhi7.ui.Dhi7Activity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class Dhi6Activity : BaseActivity<ActivityDhi6Binding>(R.layout.activity_dhi_6) {
  private val viewModel: Dhi6VM by viewModels<Dhi6VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val adapter = Adapter(viewModel.List.value?:mutableListOf())
    binding.recycler.adapter = adapter
    adapter.setOnItemClickListener(
    object : Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Dhi1RowModel) {
        onClickRecycler(view, position, item)
      }
    }
    )
    viewModel.List.observe(this) {
      adapter.updateData(it)
    }
    binding.dhi6VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageGrid.setOnClickListener {
      val destIntent = Dhi7Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecycler(
    view: View,
    position: Int,
    item: Dhi1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DHI6ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Dhi6Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
