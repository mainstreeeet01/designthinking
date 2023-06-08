package com.asapplication.app.modules.two.ui

import android.content.Intent
import com.asapplication.app.R
import com.asapplication.app.appcomponents.base.BaseActivity
import com.asapplication.app.databinding.ActivityTwoBinding
import com.asapplication.app.modules.MainActivity
import com.asapplication.app.modules.dhi9.ui.Dhi9Activity

class TwoActivity : BaseActivity<ActivityTwoBinding>(R.layout.activity_two) {
    override fun onInitialized(): Unit {
        binding.linearColumnvector.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.linearColumncomputer.setOnClickListener {
            startActivity(Dhi9Activity.getIntent(this, null))
        }

    }

    override fun setUpClicks() {}
}
