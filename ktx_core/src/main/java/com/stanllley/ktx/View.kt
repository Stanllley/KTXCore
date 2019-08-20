package com.stanllley.ktx

import android.app.Activity
import android.content.Intent
import android.support.annotation.RequiresApi
import android.support.v4.view.MarginLayoutParamsCompat
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.ViewTreeObserver

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */

inline var View.isGone: Boolean
    get() = visibility == GONE
    set(value) {
        visibility = if (value) GONE else VISIBLE
    }

inline var View.isVisible: Boolean
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else GONE
    }

inline var View.isInVisible: Boolean
    get() = visibility == INVISIBLE
    set(value) {
        visibility = if (value) INVISIBLE else VISIBLE
    }

inline val View.marginLeft: Int
    get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin ?: 0

inline val View.marginTop: Int
    get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin ?: 0

inline val View.marginRight: Int
    get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin ?: 0

inline val View.marginBottom: Int
    get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin ?: 0

inline val View.marginStart: Int
    get() {
        val lp = layoutParams
        return if (lp is ViewGroup.MarginLayoutParams) MarginLayoutParamsCompat.getMarginStart(lp) else 0
    }

inline val View.marginEnd: Int
    get() {
        val lp = layoutParams
        return if (lp is ViewGroup.MarginLayoutParams) MarginLayoutParamsCompat.getMarginEnd(lp) else 0
    }

inline fun <reified T : Activity> View.startActivity(action: Intent.() -> Unit = {}) =
    context.startActivity<T>(action)

inline fun View.postDelayed(
    delayMillis: Long,
    crossinline action: () -> Unit
): Runnable {
    val runnable = Runnable { action() }
    postDelayed(runnable, delayMillis)
    return runnable
}

@RequiresApi(16)
inline fun View.postOnAnimationDelayed(
    delayMillis: Long,
    crossinline action: () -> Unit
): Runnable {
    val runnable = Runnable { action() }
    postOnAnimationDelayed(runnable, delayMillis)
    return runnable
}

inline fun View.doOnPreDraw(crossinline action: (v: View?) -> Unit) {
    val vto = viewTreeObserver
    vto.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            action(this@doOnPreDraw)
            when {
                vto.isAlive -> vto.removeOnPreDrawListener(this)
                else -> viewTreeObserver.removeOnPreDrawListener(this)
            }
            return true
        }
    })
}

@RequiresApi(16)
inline fun View.doOnDraw(crossinline action: (v: View?) -> Unit) {
    val vto = viewTreeObserver
    vto.addOnDrawListener(object : ViewTreeObserver.OnDrawListener {
        override fun onDraw() {
            action(this@doOnDraw)
            when {
                vto.isAlive -> vto.removeOnDrawListener(this)
                else -> viewTreeObserver.removeOnDrawListener(this)
            }
        }
    })
}

@RequiresApi(16)
inline fun View.doOnGlobalLayout(crossinline action: (v: View?) -> Unit) {
    val vto = viewTreeObserver
    vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            action(this@doOnGlobalLayout)
            when {
                vto.isAlive -> vto.removeOnGlobalLayoutListener(this)
                else -> viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        }
    })
}

inline fun View.doOnGlobalFocusChange(crossinline action: (oldFocus: View?, newFocus: View?) -> Unit) {
    val vto = viewTreeObserver
    vto.addOnGlobalFocusChangeListener(object : ViewTreeObserver.OnGlobalFocusChangeListener {
        override fun onGlobalFocusChanged(oldFocus: View?, newFocus: View?) {
            action(oldFocus, newFocus)
            when {
                vto.isAlive -> vto.removeOnGlobalFocusChangeListener(this)
                else -> viewTreeObserver.removeOnGlobalFocusChangeListener(this)
            }
        }
    })
}

inline fun View.doOnScrollChanged(crossinline action: (v: View?) -> Unit) {
    val vto = viewTreeObserver
    vto.addOnScrollChangedListener(object : ViewTreeObserver.OnScrollChangedListener {
        override fun onScrollChanged() {
            action(this@doOnScrollChanged)
            when {
                vto.isAlive -> vto.removeOnScrollChangedListener(this)
                else -> viewTreeObserver.removeOnScrollChangedListener(this)
            }
        }
    })
}

inline fun View.doOnViewDetachedFromWindow(crossinline action: (v: View?) -> Unit) =
    addOnAttachStateChangeListener(onViewDetachedFromWindow = action)

inline fun View.doOnViewAttachedToWindow(crossinline action: (v: View?) -> Unit) =
    addOnAttachStateChangeListener(onViewAttachedToWindow = action)

inline fun View.addOnAttachStateChangeListener(
    crossinline onViewDetachedFromWindow: (v: View?) -> Unit = {},
    crossinline onViewAttachedToWindow: (v: View?) -> Unit = {}
): OnAttachStateChangeListener {
    val listener = object : OnAttachStateChangeListener {
        override fun onViewDetachedFromWindow(v: View?) = onViewDetachedFromWindow(v)
        override fun onViewAttachedToWindow(v: View?) = onViewAttachedToWindow(v)
    }
    addOnAttachStateChangeListener(listener)
    return listener
}