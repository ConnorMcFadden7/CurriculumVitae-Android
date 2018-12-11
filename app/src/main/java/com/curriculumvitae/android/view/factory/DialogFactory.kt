package com.curriculumvitae.android.view.factory

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.support.v7.app.AlertDialog
import com.curriculumvitae.android.R

class DialogFactory {

    fun showErrorDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setPositiveButton(
            android.R.string.ok
        ) { dialogInterface, _ -> dialogInterface.dismiss() }
            .setMessage(context.resources.getString(R.string.generic_error_dialog_title))
            .show()
    }

    fun showNoInternetDialog(activity: Activity) {
        val builder = AlertDialog.Builder(activity)
        builder.setCancelable(false)
        builder.setPositiveButton(
            R.string.generic_no_internet_connection_cta
        ) { _, _ ->
            val settingsIntent = Intent(Settings.ACTION_SETTINGS)
            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(settingsIntent)
        }
        builder.setTitle(R.string.generic_no_internet_connection_title)
        builder.setMessage(R.string.generic_no_internet_connection_message)
        builder.show()
    }

}