package com.yaman.myapp

import android.app.Application
import android.os.Bundle
import android.util.Log
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsLogger

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initFacebookEvents()
    }

    private fun initFacebookEvents() {
        try {
            FacebookSdk.sdkInitialize(this)
            FacebookSdk.setAutoInitEnabled(true)
            FacebookSdk.setApplicationId(getString(R.string.facebook_app_id))
            FacebookSdk.setClientToken(getString(R.string.facebook_client_token))

            FacebookSdk.setIsDebugEnabled(true)
            if (BuildConfig.DEBUG) {
                FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS)
                FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS)
                FacebookSdk.addLoggingBehavior(LoggingBehavior.DEVELOPER_ERRORS)
            }

            val logger = AppEventsLogger.newLogger(this)
            val bundle = Bundle()
            bundle.putString("App Started Event - Android", "Init Custom Facebook Events.")
            logger.logEvent(getString(R.string.app_name), bundle)
        } catch (e: Exception) {
            Log.e("Error: ", "initFacebookEvents: " + e.localizedMessage)
        }
    }


}