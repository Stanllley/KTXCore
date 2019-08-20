package com.stanllley.ktx

import android.app.Activity
import android.content.Intent

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */
inline fun <reified T : Activity> Activity.startActivity(
    reqCode: Int = 0,
    action: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    action(intent)
    if (reqCode != 0) {
        startActivityForResult(intent, reqCode)
        return
    }
    startActivity(intent)
}

inline fun Activity.setResult(
    resultCode : Int = Activity.RESULT_OK,
    action: Intent.() -> Unit = {}
){
    val intent = Intent()
    action(intent)
    setResult(resultCode,intent)
}
