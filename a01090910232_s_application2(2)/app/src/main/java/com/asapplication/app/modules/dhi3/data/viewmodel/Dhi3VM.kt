package com.asapplication.app.modules.dhi3.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi3.`data`.model.Dhi0RowModel
import com.asapplication.app.modules.dhi3.`data`.model.Dhi3Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class Dhi3VM : ViewModel(), KoinComponent {
  val dhi3Model: MutableLiveData<Dhi3Model> = MutableLiveData(Dhi3Model())

  var navArguments: Bundle? = null

  val List: MutableLiveData<MutableList<Dhi0RowModel>> = MutableLiveData(mutableListOf())
}
