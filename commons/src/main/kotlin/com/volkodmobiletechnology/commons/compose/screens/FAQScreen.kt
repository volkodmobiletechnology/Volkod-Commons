package com.volkodmobiletechnology.commons.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volkodmobiletechnology.commons.R
import com.volkodmobiletechnology.commons.compose.components.LinkifyTextComponent
import com.volkodmobiletechnology.commons.compose.extensions.MyDevices
import com.volkodmobiletechnology.commons.compose.lists.SimpleLazyListScaffold
import com.volkodmobiletechnology.commons.compose.settings.SettingsHorizontalDivider
import com.volkodmobiletechnology.commons.compose.theme.AppThemeSurface
import com.volkodmobiletechnology.commons.compose.theme.SimpleTheme
import com.volkodmobiletechnology.commons.extensions.fromHtml
import com.volkodmobiletechnology.commons.models.FAQItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun FAQScreen(
    goBack: () -> Unit,
    faqItems: ImmutableList<FAQItem>,
) {
    SimpleLazyListScaffold(
        title = stringResource(id = R.string.frequently_asked_questions),
        goBack = goBack,
        contentPadding = PaddingValues(bottom = SimpleTheme.dimens.padding.medium)
    ) {
        itemsIndexed(faqItems) { index, faqItem ->
            Column(modifier = Modifier.fillMaxWidth()) {
                ListItem(
                    headlineContent = {
                        val text = if (faqItem.title is Int) stringResource(faqItem.title) else faqItem.title as String
                        Text(
                            text = text,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 6.dp),
                            color = SimpleTheme.colorScheme.primary,
                            lineHeight = 16.sp,
                        )
                    },
                    supportingContent = {
                        if (faqItem.text is Int) {
                            val text = stringResource(id = faqItem.text).fromHtml()
                            LinkifyTextComponent(
                                text = { text },
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 14.sp
                            )
                        } else {
                            Text(
                                text = faqItem.text as String,
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 14.sp
                            )
                        }
                    },
                )
                Spacer(modifier = Modifier.padding(bottom = SimpleTheme.dimens.padding.medium))
                if (index != faqItems.lastIndex) {
                    SettingsHorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = SimpleTheme.dimens.padding.small)
                    )
                }
            }
        }
    }
}

@MyDevices
@Composable
private fun FAQScreenPreview() {
    AppThemeSurface {
        FAQScreen(
            goBack = {},
            faqItems = listOf(
                FAQItem(R.string.faq_1_title_commons, R.string.faq_1_text_commons),
                FAQItem(R.string.faq_1_title_commons, R.string.faq_1_text_commons),
                FAQItem(R.string.faq_4_title_commons, R.string.faq_4_text_commons),
                FAQItem(R.string.faq_2_title_commons, R.string.faq_2_text_commons),
                FAQItem(R.string.faq_6_title_commons, R.string.faq_6_text_commons)
            ).toImmutableList()
        )
    }
}
