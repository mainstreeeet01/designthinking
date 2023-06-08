package com.asapplication.app.modules.dhi9.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi9Binding
import com.asapplication.app.modules.dhi10.ui.Dhi10Activity
import com.asapplication.app.modules.dhi11.ui.Dhi11Activity
import com.asapplication.app.modules.dhi9.data.viewmodel.Dhi9VM
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class Dhi9Activity : BaseActivity<ActivityDhi9Binding>(R.layout.activity_dhi_9) {
    private val viewModel: Dhi9VM by viewModels()

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var preLati: Double = 0.0
    private var preLong: Double = 0.0
    private var preLati1: Double = 0.0
    private var preLong1: Double = 0.0

    private var title: String? = null
    private var button: String? = null
    private var end: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        super.onCreate(savedInstanceState)
    }
    private fun reqLocationPermission() {
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.containsKey(Manifest.permission.ACCESS_FINE_LOCATION) &&
                        permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true -> {
                    reqPoint()
                }

                permissions.containsKey(Manifest.permission.ACCESS_COARSE_LOCATION) &&
                        permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true -> {
                    reqPoint()
                } else -> {}
            }
        }.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    private fun reqPoint() {
        if (ActivityCompat.checkSelfPermission(this@Dhi9Activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this@Dhi9Activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener {
//                val curPosition = MapPoint.mapPointWithGeoCoord(it.latitude, -it.longitude)
                val curPosition = MapPoint.mapPointWithGeoCoord(37.2429616, 127.0800525)
                preLati = curPosition.mapPointGeoCoord.latitude
                preLong = curPosition.mapPointGeoCoord.longitude

                binding.mapView.run {
                    setMapCenterPoint(curPosition, true)
                    setZoomLevel(3, true)
                    setMapCenterPointAndZoomLevel(curPosition, 3, true)
                    zoomIn(true)
                    zoomOut(true)

                    addPOIItem(
                        MapPOIItem().apply {
                            itemName = "출발위치"
                            tag = 0
                            mapPoint = curPosition
                            markerType = MapPOIItem.MarkerType.BluePin
//                            selectedMarkerType = MapPOIItem.MarkerType.RedPin
                            isDraggable = true
                        }
                    )

                    this.setPOIItemEventListener(object: MapView.POIItemEventListener {
                        override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {
                            Log.d("aaa", "onPOIItemSelected")
                        }

                        override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?) {
                            Log.d("aaa", "onCalloutBalloonOfPOIItemTouched")
                        }

                        override fun onCalloutBalloonOfPOIItemTouched(
                            p0: MapView?,
                            p1: MapPOIItem?,
                            p2: MapPOIItem.CalloutBalloonButtonType?
                        ) {
                            Log.d("aaa", "onCalloutBalloonOfPOIItemTouched")
                        }

                        override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {
                            Log.d("aaa", "onDraggablePOIItemMoved ${p2?.mapPointGeoCoord?.latitude} ${p2?.mapPointGeoCoord?.longitude}")
                            p2?.mapPointGeoCoord?.latitude?.let {
                                if (end) {
                                    preLati = it
                                } else {
                                    preLati1 = it
                                }
                            }

                            p2?.mapPointGeoCoord?.longitude?.let {
                                if (end) {
                                    preLong = it
                                } else {
                                    preLong1 = it
                                }
                            }
                        }
                    })
                }
            }
        } else {
            reqLocationPermission()
        }
    }

    override fun onInitialized() {
        binding.dhi9VM = viewModel
        title = intent.getStringExtra(TITLE_KEY)
        button = intent.getStringExtra(BUTTON_KEY)
        end = intent.getBooleanExtra(END_KEY, false)

        binding.txtFiftySeven.text = title
        binding.btn.text = button

        reqPoint()
    }

    override fun setUpClicks() {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
        binding.imageVector.setOnClickListener {
            finish()
        }

        binding.btn.setOnClickListener {
            Log.d("aaa", "setUpClicks: preLong $preLong preLati $preLati")
            if (end) {
                Log.d("a", "${preLati1},${preLong1}&ep=${preLati},${preLong}")
                startActivityForResult(Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://route?sp=${preLati1},${preLong1}&ep=${preLati},${preLong}&by=FOOT")), 0)
            } else {
                binding.txtFiftySeven.text = "도착위치"
                binding.btn.text = "도착 위치 지정"
                binding.mapView.run {
                    removeAllPOIItems()
                    addPOIItem(
                        MapPOIItem().apply {
                            itemName = "도착위치"
                            tag = 0
                            mapPoint = MapPoint.mapPointWithGeoCoord(37.2429616, 127.0800525)
                            markerType = MapPOIItem.MarkerType.BluePin
//                            selectedMarkerType = MapPOIItem.MarkerType.RedPin
                            isDraggable = true
                        }
                    )
                }
                end = true
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        startActivity(Intent(this, Dhi11Activity::class.java))
        finish()
    }

    companion object {

        const val TITLE_KEY = "title"
        const val BUTTON_KEY = "button"
        const val END_KEY = "end"

        fun getIntent(context: Context, title: String?, buttonTitle: String?, isEnd: Boolean): Intent {
            val destIntent = Intent(context, Dhi9Activity::class.java)
            destIntent.putExtra(TITLE_KEY, title)
            destIntent.putExtra(BUTTON_KEY, buttonTitle)
            destIntent.putExtra(END_KEY, isEnd)
            return destIntent
        }
    }
}
