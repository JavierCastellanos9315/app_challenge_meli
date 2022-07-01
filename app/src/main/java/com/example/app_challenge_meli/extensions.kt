package com.example.app_challenge_meli

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.text.NumberFormat
import java.util.*
val PARAMETRO_ID : String = "ID"
val BASE_URL : String = "https://api.mercadolibre.com"
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

/**
 * Carga imagen de una url
 * @param url
 **/
fun ImageView.loadUrl(url: String) {
    try {
        Glide.with(this).load(url).into(this)
    }catch (e : Exception){
        sendError(e,"loadUrl", url)
    }

}
/**
 * Convierte valor double en moneda Colombiana
 * @param price
 * @return String
 **/
fun convertPrice (price : Double) : String{
    val locale = Locale("es", "CO")
    val numberFormat = NumberFormat.getNumberInstance(locale)
    return "$ "+ numberFormat.format(price)
}

/**
 * valida si hay o no una conexion a internet
 * @param context
 * @return Boolean
**/
fun isNetworkAvailable(context: Context?): Boolean {
    if (context == null) return false
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}
/**
 * Envia un error a crashlytics y al log
 * @param e Excepcion
 * @param where nombre del metodo donde ocurrio el error
 * @param parameter parametro que entraba a la funcion
 **/
fun sendError(e:Exception , where : String, parameter : String){
    Log.e("Error", "$where ($parameter) ")
    FirebaseCrashlytics.getInstance().recordException(e)
    FirebaseCrashlytics.getInstance().log(e.message.toString())
}