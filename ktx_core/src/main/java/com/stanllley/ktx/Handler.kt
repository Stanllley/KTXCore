package com.stanllley.ktx

import android.os.Handler
import android.os.Message
import android.support.annotation.RequiresApi

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/19.
 *@Description
 */

inline fun Handler.postAtTime(
    uptimeMillis: Long, token: Any? = null,
    crossinline action: () -> Unit
): Boolean {
    val runnable = Runnable { action() }
    return if (token == null) {
        postAtTime(runnable, uptimeMillis)
    } else {
        postAtTime(runnable, token, uptimeMillis)
    }
}

@RequiresApi(28)
inline fun Handler.postDelayed(
    delayMillis: Long, token: Any? = null,
    crossinline action: () -> Unit
): Boolean {
    val runnable = Runnable { action() }
    return if (token == null) {
        postDelayed(runnable, delayMillis)
    } else {
        postDelayed(runnable, token, delayMillis)
    }
}

inline fun Handler.sendMessageAtTime(
    uptimeMillis: Long,
    crossinline action: Message.() -> Unit
): Boolean {
    val message = Message()
    action(message)
    return sendMessageAtTime(message, uptimeMillis)
}

inline fun Handler.sendMessageDelayed(
    delayMillis: Long,
    crossinline action: Message.() -> Unit
): Boolean {
    val message = Message()
    action(message)
    return sendMessageDelayed(message, delayMillis)
}
