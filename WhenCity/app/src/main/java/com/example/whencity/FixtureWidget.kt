package com.example.whencity

import android.app.AlertDialog
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast

/**
 * Implementation of App Widget functionality.
 */
class FixtureWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    // 위젯 크기 변경시 호출
    override fun onAppWidgetOptionsChanged(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetId: Int, newOptions: Bundle?) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)

        Log.d("WhenCity", "onAppWidgetOptionsChanged() Called")

        var minWidth = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)
        var maxWidth = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH)

        var minHeight = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
        var maxHeight = newOptions!!.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT)

        Log.d("WhenCity", "min: ${minWidth}x${minHeight}, max: ${maxWidth}x${maxHeight}")

        // 4x1 크기로 변경될 시
        if (minWidth.equals(471) and minHeight.equals(141)) {
            Log.d("WhenCity", "위젯이 4x1 크기로 변경됨")

            appWidgetManager!!.updateAppWidget(appWidgetId, RemoteViews(context!!.packageName, R.layout.fixture_widget_1x4))
        }
        // 3x1 크기로 변경될 시
        else if (minWidth.equals(373) and minHeight.equals(141)) {
            Log.d("WhenCity", "위젯이 3x1 크기로 변경됨")

            appWidgetManager!!.updateAppWidget(appWidgetId, RemoteViews(context!!.packageName, R.layout.fixture_widget_1x3))
        }
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    
}