package top.zsh2401.lab

import android.net.Uri
import top.zsh2401.lab.util.getVersionCode
import top.zsh2401.lab.util.getVersionName

/**
 * Created by zsh24 on 02/16/2018.
 */
val DEVELOPER_MAIL = "zsh2401@163.com"
val OPENSOURCE_URL = "http://github.com/zsh2401/2401slab"
val CURRENT_VERSION_NAME:String
    get() = getVersionName()
val CURRENT_VERSION_CODE:Int
    get() = getVersionCode()
val BLOG_URL = "http://zsh2401.top"
val BLOG_URI = Uri.parse(BLOG_URL)