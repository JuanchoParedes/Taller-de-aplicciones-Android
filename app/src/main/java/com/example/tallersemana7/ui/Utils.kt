package com.example.tallersemana7.ui

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

fun Context.showAlertDialog(
    message: String,
    positiveButtonListener: DialogInterface.OnClickListener? = null,
) {
    val alertBuilder = AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton("OK", positiveButtonListener)
        .setCancelable(false)
    alertBuilder.create()?.show()
}