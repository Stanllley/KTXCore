@file:Suppress("NOTHING_TO_INLINE")

package com.stanllley.ktx

import android.view.View
import android.view.ViewGroup

/**
 *@Author xuyang
 *@Email youtouchyang@sina.com
 *@Date 2019/8/14.
 *@Description
 */

inline fun ViewGroup.isEmpty() = childCount == 0

inline fun ViewGroup.isNotEmpty() = !isEmpty()

inline fun ViewGroup.forEach(action: (v: View) -> Unit) {
    for (index in 0 until childCount) {
        action(getChildAt(index))
    }
}

inline fun ViewGroup.forEachIndexed(action: (index : Int,v: View) -> Unit) {
    for (index in 0 until childCount) {
        action(index,getChildAt(index))
    }
}