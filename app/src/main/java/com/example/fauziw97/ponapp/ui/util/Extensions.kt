package com.example.fauziw97.ponapp.ui.util

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.pm.ActivityInfo
import android.support.annotation.IdRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fauziw97.ponapp.R


/**
 * Created by Burhanuddin on 2/21/2018.
 */

fun View.hide() {
    visibility = View.GONE
}

fun View.gone() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}

fun Fragment.addFragment(fragment: Fragment, frameId: Int) {
    fragmentManager!!.inTransaction { add(frameId, fragment) }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int) {
    fragmentManager!!.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun Activity.isPortrait() = requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

fun Activity.getDeviceWidth() = with(this) {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    displayMetrics.widthPixels
}

fun Activity.getDeviceHeight() = with(this) {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    displayMetrics.heightPixels
}

fun Fragment.toast(message: String, isLong: Boolean = false) {
    Toast.makeText(this.activity, message, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.removeFragmentByTag(tag: String): Boolean {
    return removeFragment(supportFragmentManager.findFragmentByTag(tag))
}

fun AppCompatActivity.removeFragmentByID(@IdRes containerID: Int): Boolean {
    return removeFragment(supportFragmentManager.findFragmentById(containerID))
}

fun AppCompatActivity.removeFragment(fragment: Fragment?): Boolean {
    fragment?.let {
        val commit = supportFragmentManager.beginTransaction().remove(fragment).commit()
        return true
    } ?: return false
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun Context.toast(message: String, isLong: Boolean = false) {
    Toast.makeText(this, message, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun ImageView.loadFromUrl(imageUrl: String, placeHolder: Int = R.drawable.img_placeholder) {

    val requestOptions = RequestOptions()
    requestOptions.placeholder(R.drawable.img_placeholder)

    Glide.with(this.context)
        .load(imageUrl)
        .apply(requestOptions)
        .into(this)
}

inline fun ConstraintLayout.updateParams(
    constraintSet: ConstraintSet = ConstraintSet(),
    updates: ConstraintSet.() -> Unit
) {
    constraintSet.clone(this)
    constraintSet.updates()
    constraintSet.applyTo(this)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel() = ViewModelProviders.of(this).get(T::class.java)

inline fun <reified T : ViewModel> Fragment.getViewModel() = ViewModelProviders.of(this).get(T::class.java)

inline fun <reified T : ViewModel> Fragment.getActivityViewModel() =
    ViewModelProviders.of(activity!!).get(T::class.java)

inline fun <reified T : ViewGroup.LayoutParams> View.getParams() = this.layoutParams as T

