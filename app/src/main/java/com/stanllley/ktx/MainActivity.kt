package com.stanllley.ktx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(16)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_view.doOnPreDraw { Log.i("test","doOnPreDraw") }
        test_view.doOnDraw { Log.i("test","doOnDraw") }
        test_view.doOnGlobalLayout { Log.i("test","doOnGlobalLayout") }
        test_view.doOnGlobalFocusChange { _, _ -> Log.i("test","doOnGlobalFocusChange") }
        test_view.doOnScrollChanged { Log.i("test","doOnScrollChanged") }
        test_view.doOnViewAttachedToWindow { Log.i("test","doOnViewAttachedToWindow") }
        test_view.doOnViewDetachedFromWindow { Log.i("test","doOnViewDetachedFromWindow") }
        val observer = lifecycle.addObserver (
            onCreate = {_,_->
                Log.i("test","onCreate")
            } ,
            onStart = {_,_->
                Log.i("test","onStart")
            },
            onResume = {_,_->
                Log.i("test","onResume")
            },
            onPause = {_,_->
                Log.i("test","onPause")
            },
            onStop = {_,_->
                Log.i("test","onStop")
            },
            onDestroy = {it,observer->
                Log.i("test","onDestroy")
                it.lifecycle.removeObserver(observer)
            } ,
            onAny = {_,_->
                Log.i("test","onAny")
            }
        )
    }

}
