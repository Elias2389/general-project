package com.ae.baseapplication.common.deepLink

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DeepLinkFactoryImplTest {

    private lateinit var deepLinkFactory: DeepLinkFactory

    @Before
    fun setup() {
        deepLinkFactory = DeepLinkFactoryImpl("library://my_deep_link", "My libreria")
    }

    @Test
    fun getTextToLabel() {
        val label: String = deepLinkFactory.getTextToLabel()
        val labelExpected = "My libreria"
        assertEquals(labelExpected, label)
    }

}