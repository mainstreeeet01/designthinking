package com.asapplication.app.modules.dhi7.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi7.`data`.model.Dhi2RowModel
import com.asapplication.app.modules.dhi7.`data`.model.Dhi7Model
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class Dhi7VM : ViewModel(), KoinComponent {
  val dhi7Model: MutableLiveData<Dhi7Model> = MutableLiveData(Dhi7Model())

  var navArguments: Bundle? = null

  val List: MutableLiveData<MutableList<Dhi2RowModel>> = MutableLiveData(mutableListOf())
}
