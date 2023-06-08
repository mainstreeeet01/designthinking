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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityDhi9Binding
import com.asapplication.app.modules.dhi9.data.viewmodel.Dhi9VM
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class Dhi9Activity : BaseActivity<ActivityDhi9Binding>(R.layout.activity_dhi_9) {
    private val viewModel: Dhi9VM by viewModels()

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var preLati = 0L
    private var preLong = 0L

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
                preLati = curPosition.mapPointGeoCoord.latitude.toLong()
                preLong = curPosition.mapPointGeoCoord.longitude.toLong()

                binding.mapView.apply {
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
                                preLati = it.toLong()
                            }

                            p2?.mapPointGeoCoord?.longitude?.let {
                                preLong = it.toLong()
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
        reqPoint()
    }

    override fun setUpClicks() {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }

        binding.btn.setOnClickListener {
            Log.d("aaa", "setUpClicks: preLong $preLong preLati $preLati")
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=net.daum.android.map")))
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("kakaomap://route?sp=37.537229,127.005515&ep=37.4979502,127.0276368&by=FOOT")))
        }
    }

    companion object {
        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, Dhi9Activity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
