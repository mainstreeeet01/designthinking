package com.asapplication.app.modules.dhi9.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi9Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtFiftySeven: String? = MyApp.getInstance().resources.getString(R.string.lbl30)

)
