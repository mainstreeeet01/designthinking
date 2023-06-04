package com.asapplication.app.modules.dhi11.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi11Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtSixtyOne: String? = MyApp.getInstance().resources.getString(R.string.lbl32)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSixtyTwo: String? = MyApp.getInstance().resources.getString(R.string.msg)

)
