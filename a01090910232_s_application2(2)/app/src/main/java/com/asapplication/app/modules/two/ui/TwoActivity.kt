package com.asapplication.app.modules.two.ui

import android.content.Intent
import androidx.activity.viewModels
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityTwoBinding
import com.asapplication.app.modules.MainActivity
import com.asapplication.app.modules.two.data.viewmodel.TwoVM

class TwoActivity : BaseActivity<ActivityTwoBinding>(R.layout.activity_two) {
    private val viewModel: TwoVM by viewModels<TwoVM>()

    override fun onInitialized(): Unit {
        binding.linearColumnvector.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun setUpClicks(): Unit {
    }
}
