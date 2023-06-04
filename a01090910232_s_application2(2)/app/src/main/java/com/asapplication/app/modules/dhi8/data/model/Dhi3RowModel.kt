package com.asapplication.app.modules.dhi8.`data`.model

import com.asapplication.app.R
import com.asapplication.app.appcomponents.di.MyApp
import kotlin.String

data class Dhi3RowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtZero: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZeroOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZeroTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_22)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZeroThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_32)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZeroFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_42)

)
