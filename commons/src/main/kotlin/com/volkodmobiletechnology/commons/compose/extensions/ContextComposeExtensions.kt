package com.volkodmobiletechnology.commons.compose.extensions

import android.app.Activity
import android.content.Context
import com.volkodmobiletechnology.commons.R
import com.volkodmobiletechnology.commons.extensions.baseConfig
import com.volkodmobiletechnology.commons.extensions.redirectToRateUs
import com.volkodmobiletechnology.commons.extensions.toast
import com.volkodmobiletechnology.commons.helpers.BaseConfig

val Context.config: BaseConfig get() = BaseConfig.newInstance(applicationContext)

fun Activity.rateStarsRedirectAndThankYou(stars: Int) {
    if (stars == 5) {
        redirectToRateUs()
    }
    toast(R.string.thank_you)
    baseConfig.wasAppRated = true
}
