package com.asapplication.app.modules.dhi10.ui

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi10Binding
import com.asapplication.app.modules.dhi10.`data`.viewmodel.Dhi10VM
import com.asapplication.app.modules.dhi11.ui.Dhi11Activity
import com.asapplication.app.modules.dhi9.ui.Dhi9Activity
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import kotlin.String
import kotlin.Unit

class Dhi10Activity : BaseActivity<ActivityDhi10Binding>(R.layout.activity_dhi_10) {
    private val viewModel: Dhi10VM by viewModels()

    override fun onInitialized() {
        val curPosition = MapPoint.mapPointWithGeoCoord(37.2429616, 127.0800525)
    }

    override fun setUpClicks() {
        binding.btn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://route?sp=37.537229,127.005515&ep=37.4979502,127.0276368&by=FOOT")))
//            startActivity(Intent(this, Dhi11Activity::class.java))
        }

        binding.imageArrowleft.setOnClickListener {
            finish()
        }
    }
}
