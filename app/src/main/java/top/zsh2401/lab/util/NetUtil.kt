package top.zsh2401.lab.util

import android.net.Uri
import top.zsh2401.lab.BLOG_URI

/**
 * Created by zsh24 on 02/16/2018.
 */
val BLOG_HOST = BLOG_URI.host
fun String.hostIs(host:String):Boolean{
    return try{
        Uri.parse(this).host == host
    }catch (ex:Exception){
        ex.printStackTrace()
        false
    }
}