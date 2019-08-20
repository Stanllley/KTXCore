package com.stanllley.ktx

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner


/**
 *@Author xuyang
 *@Email xuyang@prudencemed.com
 *@Date 2019/8/20.
 *@Description
 */

inline fun Lifecycle.doOnCreate(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onCreate = action)

inline fun Lifecycle.doOnStart(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onStart = action)

inline fun Lifecycle.doOnResume(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onResume = action)

inline fun Lifecycle.doOnPause(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onPause = action)

inline fun Lifecycle.doOnStop(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onStop = action)

inline fun Lifecycle.doOnDestroy(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onDestroy = action)

inline fun Lifecycle.doOnAny(crossinline action: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit) =
    addObserver(onAny = action)

inline fun Lifecycle.addObserver(
    crossinline onCreate: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onStart: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onResume: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onPause: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onStop: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onDestroy: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> },
    crossinline onAny: (owner: LifecycleOwner, observer: LifecycleObserver) -> Unit = { _, _ -> }
): LifecycleObserver {
    val observer = object : DefaultLifecycleObserver() {
        override fun onCreate(owner: LifecycleOwner) = onCreate(owner, this)
        override fun onStart(owner: LifecycleOwner) = onStart(owner, this)
        override fun onResume(owner: LifecycleOwner) = onResume(owner, this)
        override fun onPause(owner: LifecycleOwner) = onPause(owner, this)
        override fun onStop(owner: LifecycleOwner) = onStop(owner, this)
        override fun onDestroy(owner: LifecycleOwner) = onDestroy(owner, this)
        override fun onAny(owner: LifecycleOwner) = onAny(owner, this)
    }
    addObserver(observer)
    return observer
}

