package com.ae.baseapplication.common.deepLink

import android.content.Intent
import androidx.fragment.app.FragmentActivity

interface DeepLinkFactory {
    fun getTextToLabel(): String
    fun createDeepLinkIntent(context: FragmentActivity): Intent
}