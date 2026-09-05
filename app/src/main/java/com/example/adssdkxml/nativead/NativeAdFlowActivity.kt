package com.example.adssdkxml.nativead

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ads.util.AdsLogger
import com.example.adssdkxml.MainActivity
import com.example.adssdkxml.databinding.ActivityNativeFlowBinding

/**
 * 3-Level navigation flow demonstrating Small, Medium, and Dual Native Ads across consecutive screens
 * using View Binding.
 */
class NativeAdFlowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LEVEL = "extra_level"
    }

    private lateinit var binding: ActivityNativeFlowBinding
    private var currentLevel = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNativeFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentLevel = intent.getIntExtra(EXTRA_LEVEL, 1)
        AdsLogger.i(AdsLogger.TAG_NATIVE, "NativeAdFlowActivity: Opened Screen Level $currentLevel of 3")

        when (currentLevel) {
            1 -> {
                binding.tvNativeFlowTitle.text = "Native Ad (Small Template) - Level 1 of 3"
                binding.tvNativeFlowDesc.text = "Level 1 displays a compact Small Native Ad template."
                binding.nativeAdFlowSmall.visibility = View.VISIBLE
                binding.nativeAdFlowMedium.visibility = View.GONE
            }
            2 -> {
                binding.tvNativeFlowTitle.text = "Native Ad (Medium Template) - Level 2 of 3"
                binding.tvNativeFlowDesc.text = "Level 2 displays a rich Medium Native Ad with media view and call-to-action."
                binding.nativeAdFlowSmall.visibility = View.GONE
                binding.nativeAdFlowMedium.visibility = View.VISIBLE
            }
            3 -> {
                binding.tvNativeFlowTitle.text = "Native Ads (Dual Showcase) - Level 3 of 3"
                binding.tvNativeFlowDesc.text = "Level 3 displays both Small and Medium native ads."
                binding.nativeAdFlowSmall.visibility = View.VISIBLE
                binding.nativeAdFlowMedium.visibility = View.VISIBLE
            }
        }

        binding.nativeAdFlowSmall.onAdLoadedListener = {
            AdsLogger.i(AdsLogger.TAG_NATIVE, "NativeAdFlowActivity (Level $currentLevel): Small Native Ad loaded callback.")
            binding.tvNativeFlowStatus.text = "Native Ad Status: Loaded successfully!"
        }

        binding.nativeAdFlowMedium.onAdLoadedListener = {
            AdsLogger.i(AdsLogger.TAG_NATIVE, "NativeAdFlowActivity (Level $currentLevel): Medium Native Ad loaded callback.")
            binding.tvNativeFlowStatus.text = "Native Ad Status: Loaded successfully!"
        }

        if (currentLevel < 3) {
            binding.btnNextNativeLevel.text = "Proceed to Level ${currentLevel + 1} ➔"
            binding.btnNextNativeLevel.setOnClickListener {
                AdsLogger.i(AdsLogger.TAG_NATIVE, "NativeAdFlowActivity (Level $currentLevel): User clicked 'Proceed to Level ${currentLevel + 1}'")
                val intent = Intent(this, NativeAdFlowActivity::class.java).apply {
                    putExtra(EXTRA_LEVEL, currentLevel + 1)
                }
                startActivity(intent)
            }
        } else {
            binding.btnNextNativeLevel.text = "✓ 3-Level Flow Complete (Restart Level 1)"
            binding.btnNextNativeLevel.setOnClickListener {
                AdsLogger.i(AdsLogger.TAG_NATIVE, "NativeAdFlowActivity (Level 3): User clicked 'Restart Level 1'")
                val intent = Intent(this, NativeAdFlowActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    putExtra(EXTRA_LEVEL, 1)
                }
                startActivity(intent)
                finish()
            }
        }

        binding.btnNativeBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
            finish()
        }
    }
}
