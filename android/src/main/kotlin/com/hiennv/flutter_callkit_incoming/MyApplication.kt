package com.hiennv.flutter_callkit_incoming

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MyApplication : Application() {
    private var flutterEngine: FlutterEngine? = null

    override fun onCreate() {
        super.onCreate()
        initFlutterEngine()
    }

    private fun initFlutterEngine() {
        flutterEngine = FlutterEngine(this).apply {
            dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
        }
        FlutterEngineCache.getInstance().put("my_engine_id", flutterEngine!!)
    }

    fun destroyFlutterEngine() {
        flutterEngine?.destroy()
        flutterEngine = null
    }
} 