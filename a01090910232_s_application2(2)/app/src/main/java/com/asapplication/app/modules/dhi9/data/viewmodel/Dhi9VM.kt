package com.asapplication.app.modules.dhi9.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi9.`data`.model.Dhi9Model
import org.koin.core.KoinComponent

class Dhi9VM : ViewModel(), KoinComponent {
  val dhi9Model: MutableLiveData<Dhi9Model> = MutableLiveData(Dhi9Model())

  var navArguments: Bundle? = null
}
