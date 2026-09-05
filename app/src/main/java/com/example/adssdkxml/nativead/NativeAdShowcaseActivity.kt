package com.example.adssdkxml.nativead

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adssdkxml.databinding.ActivityNativeShowcaseBinding

/**
 * Screen demonstrating Small and Medium Native Ad XML layouts in action using View Binding.
 */
class NativeAdShowcaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNativeShowcaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeShowcaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nativeAdMedium.onAdLoadedListener = {
            Toast.makeText(this, "Medium Native Ad loaded", Toast.LENGTH_SHORT).show()
        }

        binding.nativeAdSmall.onAdLoadedListener = {
            Toast.makeText(this, "Small Native Ad loaded", Toast.LENGTH_SHORT).show()
        }

        binding.btnReloadNative.setOnClickListener {
            binding.nativeAdMedium.loadAd()
            binding.nativeAdSmall.loadAd()
        }
    }
}
