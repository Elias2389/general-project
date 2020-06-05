package com.ae.baseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.ae.baseapplication.common.deepLink.DeepLinkFactory
import com.ae.baseapplication.common.deepLink.DeepLinkFactoryImpl

class MainActivity : AppCompatActivity() {

    lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container)
        setModules()
    }

    private fun setModules() {
        addDeepLinkButton(DeepLinkFactoryImpl("mercadopago://send_money", "envio de dinero"))
    }

    private fun addDeepLinkButton(deepLinkFactory: DeepLinkFactory) {
        val button = Button(this).apply {
            text = deepLinkFactory.getTextToLabel()
            buttonListener(this, deepLinkFactory)
        }
        container.addView(button)

    }

    private fun buttonListener(button: Button, deepLinkFactory: DeepLinkFactory) {
        button.setOnClickListener {
            startActivity(deepLinkFactory.createDeepLinkIntent(this))
        }
    }
}
