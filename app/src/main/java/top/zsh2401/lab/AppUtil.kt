package top.zsh2401.lab

/**
 * Created by zsh24 on 02/16/2018.
 */
fun getVersionName():String{
    return try {
        val manager = App.current.packageManager
        val info = manager.getPackageInfo(App.current.packageName, 0)
        info.versionName
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}
fun getVersopmCode():Int{
    return try {
        val manager = App.current.packageManager
        val info = manager.getPackageInfo(App.current.packageName, 0)
        info.versionCode
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}