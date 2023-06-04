package com.asapplication.app.modules.dhi10.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi10Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtFiftyNine: String? = MyApp.getInstance().resources.getString(R.string.lbl31)

)
