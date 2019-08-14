package com.stanllley.ktx

import android.app.Activity
import android.content.Intent
import android.view.View

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */
inline fun <reified T : Activity> View.startActivity(action: Intent.() -> Unit = {}) {
    this.context.startActivity<T>(action)
}

inline fun View.addOnAttachStateChangeListener(
    crossinline onViewDetachedFromWindow: (v: View?) -> Unit = {},
    crossinline onViewAttachedToWindow: (v: View?) -> Unit = {}
): View.OnAttachStateChangeListener {
    val listener = object : View.OnAttachStateChangeListener {
        override fun onViewDetachedFromWindow(v: View?) = onViewDetachedFromWindow(v)
        override fun onViewAttachedToWindow(v: View?) = onViewAttachedToWindow(v)
    }
    addOnAttachStateChangeListener(listener)
    return listener
}