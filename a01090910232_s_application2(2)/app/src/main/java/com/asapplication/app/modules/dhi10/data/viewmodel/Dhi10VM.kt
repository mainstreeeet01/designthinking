package com.asapplication.app.modules.dhi10.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi10.`data`.model.Dhi10Model
import org.koin.core.KoinComponent

class Dhi10VM : ViewModel(), KoinComponent {
  val dhi10Model: MutableLiveData<Dhi10Model> = MutableLiveData(Dhi10Model())

  var navArguments: Bundle? = null
}
