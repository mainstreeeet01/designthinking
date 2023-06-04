package com.asapplication.app.modules.dhi6.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi6Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtTwentySix: String? = MyApp.getInstance().resources.getString(R.string.lbl22)

)
