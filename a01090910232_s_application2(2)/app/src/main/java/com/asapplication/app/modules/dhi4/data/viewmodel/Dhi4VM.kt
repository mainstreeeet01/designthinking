package com.asapplication.app.modules.dhi4.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi4.`data`.model.Dhi4Model
import org.koin.core.KoinComponent

class Dhi4VM : ViewModel(), KoinComponent {
  val dhi4Model: MutableLiveData<Dhi4Model> = MutableLiveData(Dhi4Model())

  var navArguments: Bundle? = null
}
