package com.asapplication.app.modules.dhi2.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asapplication.app.modules.dhi2.`data`.model.Dhi2Model
import org.koin.core.KoinComponent

class Dhi2VM : ViewModel(), KoinComponent {
  val dhi2Model: MutableLiveData<Dhi2Model> = MutableLiveData(Dhi2Model())

  var navArguments: Bundle? = null
}
