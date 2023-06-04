package com.asapplication.app.modules.dhi4.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi4Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtTwentyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl17)

)
