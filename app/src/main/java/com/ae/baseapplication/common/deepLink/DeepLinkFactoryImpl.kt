package com.ae.baseapplication.common.deepLink

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity

class DeepLinkFactoryImpl(private val deepLinkUri: String,
                          private val label:String): DeepLinkFactory {

    override fun getTextToLabel(): String {
        return label
    }

    override fun createDeepLinkIntent(context: FragmentActivity): Intent {
        return Intent().apply {
            setPackage(context.packageName)
            data = getDeepLinkUri()
        }
    }

    private fun getDeepLinkUri(): Uri {
        return Uri.parse(deepLinkUri)
    }

}