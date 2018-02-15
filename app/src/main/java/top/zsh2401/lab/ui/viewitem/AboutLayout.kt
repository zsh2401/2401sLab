package top.zsh2401.lab.ui.viewitem

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import top.zsh2401.lab.*

/**
 * Created by zsh24 on 02/16/2018.
 */
class AboutLayout(context: Context):LinearLayout(context),View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.ll_card_about_1_feedback->{
                val intent = Intent()
                intent.action = Intent.ACTION_SENDTO
                intent.data = (Uri.parse("mailto:$DEVELOPER_MAIL"))
                intent.putExtra(Intent.EXTRA_SUBJECT,App.current.resources.getString(R.string.feedback_title))
                try{
                    App.current.startActivity(intent)
                }catch (ex:Exception){
                    Snackbar.make(this,R.string.msg_mail_not_found,Snackbar.LENGTH_LONG)
                            .setAction("ok",null).show()
                }
            }
            R.id.ll_card_about_2_os->{
                val intent = Intent()
                intent.data = Uri.parse(OPENSOURCE_URL)
                intent.action = Intent.ACTION_VIEW
                App.current.startActivity(intent)
            }
            else->{
                Snackbar.make(this,"Here we go~",Snackbar.LENGTH_LONG)
                .setAction("ok",null).show()}
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_about_layout,this)
        findViewById<LinearLayout>(R.id.ll_card_about_1_donate).setOnClickListener(this)
        findViewById<LinearLayout>(R.id.ll_card_about_1_feedback).setOnClickListener(this)
        findViewById<LinearLayout>(R.id.ll_card_about_2_os).setOnClickListener(this)
        findViewById<TextView>(R.id.text_view_version).text =
                App.current.getString(R.string.about_version_name) + " " + getVersionName()
    }
}