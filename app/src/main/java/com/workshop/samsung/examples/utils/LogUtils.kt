package com.workshop.samsung.examples.utils

import android.util.Log

class LogUtils {
    companion object {
        fun showLog(message: String, tag: String = DEFAULT_LOG_TAG) {
            Log.d(tag, message)
        }

        private const val DEFAULT_LOG_TAG = "DebugLog"
    }
}
