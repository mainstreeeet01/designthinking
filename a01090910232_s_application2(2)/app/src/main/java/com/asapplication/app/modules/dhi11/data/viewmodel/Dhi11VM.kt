package com.asapplication.app.modules.dhi11.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi11.`data`.model.Dhi11Model
import org.koin.core.KoinComponent

class Dhi11VM : ViewModel(), KoinComponent {
  val dhi11Model: MutableLiveData<Dhi11Model> = MutableLiveData(Dhi11Model())

  var navArguments: Bundle? = null
}
