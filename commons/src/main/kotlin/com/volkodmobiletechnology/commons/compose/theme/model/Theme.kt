package com.volkodmobiletechnology.commons.compose.theme.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.volkodmobiletechnology.commons.R
import com.volkodmobiletechnology.commons.compose.extensions.config
import com.volkodmobiletechnology.commons.compose.theme.isInDarkThemeAndSurfaceIsNotLitWell
import com.volkodmobiletechnology.commons.helpers.isSPlus

@Stable
sealed class Theme : CommonTheme {

    @Stable
    data class SystemDefaultMaterialYou(
        override val primaryColorInt: Int,
        override val backgroundColorInt: Int,
        override val appIconColorInt: Int,
        override val textColorInt: Int
    ) : Theme()

    @Stable
    data class White(
        val accentColor: Int,
        override val primaryColorInt: Int,
        override val backgroundColorInt: Int,
        override val appIconColorInt: Int,
        override val textColorInt: Int
    ) : Theme()

    @Stable
    data class Dark(
        override val primaryColorInt: Int,
        override val backgroundColorInt: Int,
        override val appIconColorInt: Int,
        override val textColorInt: Int
    ) : Theme()

    @Stable
    data class BlackAndWhite(
        val accentColor: Int,
        override val primaryColorInt: Int,
        override val backgroundColorInt: Int,
        override val appIconColorInt: Int,
        override val textColorInt: Int
    ) : Theme()

    @Stable
    data class Custom(
        override val primaryColorInt: Int,
        override val backgroundColorInt: Int,
        override val appIconColorInt: Int,
        override val textColorInt: Int
    ) : Theme()
    
    companion object {
        @Composable
        fun systemDefaultMaterialYou(): SystemDefaultMaterialYou {
            val context = LocalContext.current
            val config = remember { context.config }
            return SystemDefaultMaterialYou(
                appIconColorInt = config.appIconColor,
                primaryColorInt = config.primaryColor,
                backgroundColorInt = config.backgroundColor,
                textColorInt = if (isSPlus()) colorResource(R.color.you_neutral_text_color).toArgb() else (if (isInDarkThemeAndSurfaceIsNotLitWell()) Color.White else Color.Black).toArgb()
            )
        }
    }
}
