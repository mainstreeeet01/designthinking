package com.asapplication.app.modules.dhi8.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi8.`data`.model.Dhi3RowModel
import com.asapplication.app.modules.dhi8.`data`.model.Dhi8Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class Dhi8VM : ViewModel(), KoinComponent {
  val dhi8Model: MutableLiveData<Dhi8Model> = MutableLiveData(Dhi8Model())

  var navArguments: Bundle? = null

  val List: MutableLiveData<MutableList<Dhi3RowModel>> = MutableLiveData(mutableListOf())
}
