package com.example.ads

import com.example.ads.util.AdMobTestIds

/**
 * Central configuration data class for the Google AdMob Ads SDK.
 *
 * Designed to be reusable across multiple Android applications without hardcoding App IDs
 * or production Ad Unit IDs into the library codebase.
 */
data class AdsConfig(
    val bannerAdUnitId: String = "",
    val interstitialAdUnitId: String = "",
    val rewardedAdUnitId: String = "",
    val rewardedInterstitialAdUnitId: String = "",
    val nativeAdUnitId: String = "",
    val appOpenAdUnitId: String = "",

    val enableBanner: Boolean = true,
    val enableInterstitial: Boolean = true,
    val enableRewarded: Boolean = true,
    val enableRewardedInterstitial: Boolean = true,
    val enableNative: Boolean = true,
    val enableAppOpen: Boolean = true,

    val preloadInterstitial: Boolean = false,
    val preloadRewarded: Boolean = false,
    val preloadRewardedInterstitial: Boolean = false,

    val useTestAds: Boolean = false,
    val enableLogging: Boolean = false,

    val interstitialFrequency: Int = 3,
    val interstitialIntervalMillis: Long = 0L,
    val appOpenAdCooldownMillis: Long = 4 * 60 * 60 * 1000L, // 4 hours standard AdMob cache limit

    val testDeviceHashedIds: List<String> = emptyList(),
    val childDirectedTreatment: Int? = null,
    val underAgeOfConsent: Int? = null,
    val maxAdContentRating: String? = null,
    val allowRewardedForPremium: Boolean = true
) {

    /**
     * Resolves the effective Banner Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveBannerId(): String {
        return if (useTestAds || bannerAdUnitId.isBlank()) {
            AdMobTestIds.ADAPTIVE_BANNER_AD_UNIT_ID
        } else {
            bannerAdUnitId
        }
    }

    /**
     * Resolves the effective Interstitial Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveInterstitialId(): String {
        return if (useTestAds || interstitialAdUnitId.isBlank()) {
            AdMobTestIds.INTERSTITIAL_AD_UNIT_ID
        } else {
            interstitialAdUnitId
        }
    }

    /**
     * Resolves the effective Rewarded Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveRewardedId(): String {
        return if (useTestAds || rewardedAdUnitId.isBlank()) {
            AdMobTestIds.REWARDED_AD_UNIT_ID
        } else {
            rewardedAdUnitId
        }
    }

    /**
     * Resolves the effective Rewarded Interstitial Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveRewardedInterstitialId(): String {
        return if (useTestAds || rewardedInterstitialAdUnitId.isBlank()) {
            AdMobTestIds.REWARDED_INTERSTITIAL_AD_UNIT_ID
        } else {
            rewardedInterstitialAdUnitId
        }
    }

    /**
     * Resolves the effective Native Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveNativeId(): String {
        return if (useTestAds || nativeAdUnitId.isBlank()) {
            AdMobTestIds.NATIVE_AD_UNIT_ID
        } else {
            nativeAdUnitId
        }
    }

    /**
     * Resolves the effective App Open Ad Unit ID based on the test-ads configuration.
     */
    fun getEffectiveAppOpenId(): String {
        return if (useTestAds || appOpenAdUnitId.isBlank()) {
            AdMobTestIds.APP_OPEN_AD_UNIT_ID
        } else {
            appOpenAdUnitId
        }
    }

    class Builder {
        private var bannerAdUnitId: String = ""
        private var interstitialAdUnitId: String = ""
        private var rewardedAdUnitId: String = ""
        private var rewardedInterstitialAdUnitId: String = ""
        private var nativeAdUnitId: String = ""
        private var appOpenAdUnitId: String = ""

        private var enableBanner: Boolean = true
        private var enableInterstitial: Boolean = true
        private var enableRewarded: Boolean = true
        private var enableRewardedInterstitial: Boolean = true
        private var enableNative: Boolean = true
        private var enableAppOpen: Boolean = true

        private var preloadInterstitial: Boolean = false
        private var preloadRewarded: Boolean = false
        private var preloadRewardedInterstitial: Boolean = false

        private var useTestAds: Boolean = false
        private var enableLogging: Boolean = false

        private var interstitialFrequency: Int = 3
        private var interstitialIntervalMillis: Long = 0L
        private var appOpenAdCooldownMillis: Long = 4 * 60 * 60 * 1000L

        private var testDeviceHashedIds: List<String> = emptyList()
        private var childDirectedTreatment: Int? = null
        private var underAgeOfConsent: Int? = null
        private var maxAdContentRating: String? = null
        private var allowRewardedForPremium: Boolean = true

        fun setBannerAdUnitId(id: String) = apply { this.bannerAdUnitId = id }
        fun setInterstitialAdUnitId(id: String) = apply { this.interstitialAdUnitId = id }
        fun setRewardedAdUnitId(id: String) = apply { this.rewardedAdUnitId = id }
        fun setRewardedInterstitialAdUnitId(id: String) = apply { this.rewardedInterstitialAdUnitId = id }
        fun setNativeAdUnitId(id: String) = apply { this.nativeAdUnitId = id }
        fun setAppOpenAdUnitId(id: String) = apply { this.appOpenAdUnitId = id }

        fun setEnableBanner(enable: Boolean) = apply { this.enableBanner = enable }
        fun setEnableInterstitial(enable: Boolean) = apply { this.enableInterstitial = enable }
        fun setEnableRewarded(enable: Boolean) = apply { this.enableRewarded = enable }
        fun setEnableRewardedInterstitial(enable: Boolean) = apply { this.enableRewardedInterstitial = enable }
        fun setEnableNative(enable: Boolean) = apply { this.enableNative = enable }
        fun setEnableAppOpen(enable: Boolean) = apply { this.enableAppOpen = enable }

        fun setPreloadInterstitial(preload: Boolean) = apply { this.preloadInterstitial = preload }
        fun setPreloadRewarded(preload: Boolean) = apply { this.preloadRewarded = preload }
        fun setPreloadRewardedInterstitial(preload: Boolean) = apply { this.preloadRewardedInterstitial = preload }

        fun setUseTestAds(useTest: Boolean) = apply { this.useTestAds = useTest }
        fun setEnableLogging(enable: Boolean) = apply { this.enableLogging = enable }

        fun setInterstitialFrequency(frequency: Int) = apply { this.interstitialFrequency = frequency }
        fun setInterstitialIntervalMillis(millis: Long) = apply { this.interstitialIntervalMillis = millis }
        fun setAppOpenAdCooldownMillis(millis: Long) = apply { this.appOpenAdCooldownMillis = millis }

        fun setTestDeviceHashedIds(ids: List<String>) = apply { this.testDeviceHashedIds = ids }
        fun setChildDirectedTreatment(treatment: Int?) = apply { this.childDirectedTreatment = treatment }
        fun setUnderAgeOfConsent(underAge: Int?) = apply { this.underAgeOfConsent = underAge }
        fun setMaxAdContentRating(rating: String?) = apply { this.maxAdContentRating = rating }
        fun setAllowRewardedForPremium(allow: Boolean) = apply { this.allowRewardedForPremium = allow }

        fun build() = AdsConfig(
            bannerAdUnitId = bannerAdUnitId,
            interstitialAdUnitId = interstitialAdUnitId,
            rewardedAdUnitId = rewardedAdUnitId,
            rewardedInterstitialAdUnitId = rewardedInterstitialAdUnitId,
            nativeAdUnitId = nativeAdUnitId,
            appOpenAdUnitId = appOpenAdUnitId,
            enableBanner = enableBanner,
            enableInterstitial = enableInterstitial,
            enableRewarded = enableRewarded,
            enableRewardedInterstitial = enableRewardedInterstitial,
            enableNative = enableNative,
            enableAppOpen = enableAppOpen,
            preloadInterstitial = preloadInterstitial,
            preloadRewarded = preloadRewarded,
            preloadRewardedInterstitial = preloadRewardedInterstitial,
            useTestAds = useTestAds,
            enableLogging = enableLogging,
            interstitialFrequency = interstitialFrequency,
            interstitialIntervalMillis = interstitialIntervalMillis,
            appOpenAdCooldownMillis = appOpenAdCooldownMillis,
            testDeviceHashedIds = testDeviceHashedIds,
            childDirectedTreatment = childDirectedTreatment,
            underAgeOfConsent = underAgeOfConsent,
            maxAdContentRating = maxAdContentRating,
            allowRewardedForPremium = allowRewardedForPremium
        )
    }
}
