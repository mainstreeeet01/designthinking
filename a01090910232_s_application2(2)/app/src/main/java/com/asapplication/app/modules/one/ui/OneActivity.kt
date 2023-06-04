package com.asapplication.app.modules.one.ui

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityOneBinding
import com.asapplication.app.modules.two.ui.TwoActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OneActivity : BaseActivity<ActivityOneBinding>(R.layout.activity_one) {
    override fun onInitialized() {
        lifecycleScope.launch {
            delay(2500)
            startActivity(Intent(this@OneActivity, TwoActivity::class.java))
        }
    }

    override fun setUpClicks() {}
}
