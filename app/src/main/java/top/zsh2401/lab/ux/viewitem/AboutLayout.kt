package top.zsh2401.lab.ux.viewitem

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import top.zsh2401.lab.*
import top.zsh2401.lab.ux.activities.IMainActivityApi
import top.zsh2401.lab.util.copyAlipayRedpacketCode
import top.zsh2401.lab.util.copyWechatAccount
import top.zsh2401.lab.util.gotoAlipay
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.card_about_0.view.*
import kotlinx.android.synthetic.main.card_about_1.view.*
import kotlinx.android.synthetic.main.card_about_2.view.*

/**
 * Created by zsh24 on 02/16/2018.
 */
class AboutLayout(context: Context,private val api: IMainActivityApi?=null):LinearLayout(context),View.OnClickListener {
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
            }R.id.ll_card_about_1_donate->{
                val builder=  AlertDialog.Builder(context)
                builder.setTitle(R.string.title_donate)
                builder.setMessage(R.string.msg_donate)

                builder.setNegativeButton(R.string.btn_alipay,{_,_->
                    gotoAlipay()
                })
                builder.setNeutralButton(R.string.btn_copy_alipay_redpacket_code,{_,_->
                    copyAlipayRedpacketCode()
                    Snackbar.make(this,R.string.btn_copied,Snackbar.LENGTH_SHORT)
                            .setAction("ok",null)
                            .show()
                })
                builder.setPositiveButton(R.string.btn_copy_wechat,{_,_->
                    copyWechatAccount()
                    Snackbar.make(this,R.string.btn_copied,Snackbar.LENGTH_SHORT)
                            .setAction("ok",null)
                            .show()
                })
                builder.show()
        }
            else->{
                Snackbar.make(this,"Here we go~",Snackbar.LENGTH_LONG)
                .setAction("ok",null).show()}
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_about_layout,this)
        ll_card_about_1_donate.setOnClickListener(this)
        ll_card_about_1_donate.setOnClickListener(this)
        ll_card_about_2_os.setOnClickListener(this)
        text_view_version.text = App.current.getString(R.string.about_version_name) + " " + CURRENT_VERSION_NAME
    }
}