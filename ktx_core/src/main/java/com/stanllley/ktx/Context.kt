package com.stanllley.ktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */

inline fun <reified T : Activity> Context.startActivity(action: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    action(intent)
    startActivity(intent)
}

inline fun<reified T> Context.getSystemService() : T? = getSystemService(T::class.java)

inline fun<reified T> Context.getSystemService(serviceName : String) : T? = getSystemService(serviceName) as T

@ColorInt fun Context.getColorById(@ColorRes id: Int) : Int = ContextCompat.getColor(this,id)

fun Context.getColorStateListById(@ColorRes id: Int) : ColorStateList? = ContextCompat.getColorStateList(this,id)

fun Context.getDrawableById(@DrawableRes id : Int) : Drawable? = ContextCompat.getDrawable(this,id)