package com.volkodmobiletechnology.commons.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.volkodmobiletechnology.commons.compose.extensions.enableEdgeToEdgeSimple
import com.volkodmobiletechnology.commons.compose.screens.FAQScreen
import com.volkodmobiletechnology.commons.compose.theme.AppThemeSurface
import com.volkodmobiletechnology.commons.helpers.APP_FAQ
import com.volkodmobiletechnology.commons.models.FAQItem
import kotlinx.collections.immutable.toImmutableList

class FAQActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdgeSimple()
        setContent {
            AppThemeSurface {
                val faqItems = remember { intent.getSerializableExtra(APP_FAQ) as ArrayList<FAQItem> }
                FAQScreen(
                    goBack = ::finish,
                    faqItems = faqItems.toImmutableList()
                )
            }
        }
    }
}
