package com.stanllley.ktx

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 *@Author xuyang
 *@Email xuyang@prudencemed.com
 *@Date 2019/8/16.
 *@Description
 */
class KTTestApplication : Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}