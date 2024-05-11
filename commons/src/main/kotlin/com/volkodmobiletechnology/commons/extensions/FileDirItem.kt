package com.volkodmobiletechnology.commons.extensions

import android.content.Context
import com.volkodmobiletechnology.commons.models.FileDirItem

fun FileDirItem.isRecycleBinPath(context: Context): Boolean {
    return path.startsWith(context.recycleBinPath)
}
