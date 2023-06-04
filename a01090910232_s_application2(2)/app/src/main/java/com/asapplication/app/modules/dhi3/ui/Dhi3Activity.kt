package com.asapplication.app.modules.dhi3.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi3Binding
import com.asapplication.app.modules.dhi2.ui.Dhi2Activity
import com.asapplication.app.modules.dhi3.`data`.model.Dhi0RowModel
import com.asapplication.app.modules.dhi3.`data`.viewmodel.Dhi3VM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class Dhi3Activity : BaseActivity<ActivityDhi3Binding>(R.layout.activity_dhi_3) {
  private val viewModel: Dhi3VM by viewModels<Dhi3VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val adapter = Adapter(viewModel.List.value?:mutableListOf())
    binding.recycler.adapter = adapter
    adapter.setOnItemClickListener(
    object : Adapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Dhi0RowModel) {
        onClickRecycler(view, position, item)
      }
    }
    )
    viewModel.List.observe(this) {
      adapter.updateData(it)
    }
    binding.dhi3VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtEight.setOnClickListener {
      val destIntent = Dhi2Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecycler(
    view: View,
    position: Int,
    item: Dhi0RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DHI3ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Dhi3Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
