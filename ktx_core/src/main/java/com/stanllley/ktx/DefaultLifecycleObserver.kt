package com.stanllley.ktx

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent

/**
 *@Author xuyang
 *@Email xuyang@prudencemed.com
 *@Date 2019/8/20.
 *@Description
 */
abstract class DefaultLifecycleObserver : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy(owner: LifecycleOwner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    open fun onAny(owner: LifecycleOwner){

    }

}