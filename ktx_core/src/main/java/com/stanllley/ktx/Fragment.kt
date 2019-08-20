package com.stanllley.ktx

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */
inline fun <reified T : Activity> Fragment.startActivity(
    reqCode: Int = 0,
    action: Intent.() -> Unit = {}
) {
    val intent = Intent(context, T::class.java)
    action(intent)
    if (reqCode != 0) {
        startActivityForResult(intent, reqCode)
    } else {
        startActivity(intent)
    }
}