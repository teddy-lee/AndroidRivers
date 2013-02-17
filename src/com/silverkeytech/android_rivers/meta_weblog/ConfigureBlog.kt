package com.silverkeytech.android_rivers.meta_weblog

import com.silverkeytech.android_rivers.DialogInput
import com.silverkeytech.android_rivers.Duration
import com.silverkeytech.android_rivers.createFlexibleInputDialog
import com.silverkeytech.android_rivers.isNullOrEmpty
import com.silverkeytech.android_rivers.textValidator
import com.silverkeytech.android_rivers.toastee
import org.holoeverywhere.app.Activity
import com.silverkeytech.android_rivers.MULTI_LINE_INPUT
import com.silverkeytech.android_rivers.PASSWORD_INPUT
import com.silverkeytech.android_rivers.NORMAL_INPUT

public fun showPostBlogDialog(context: Activity, onOK : (res: Array<DialogInput>) -> Unit){
    val inputs = array(DialogInput(MULTI_LINE_INPUT, "Post", "", null))

    val dlg = createFlexibleInputDialog(context, "Write", inputs) {
        d, res ->
        onOK(res)
        d?.dismiss()
    }
    dlg.show()
}

public fun showBlogConfigurationDialog(context: Activity, onOK: (res: Array<DialogInput>) -> Unit) {
    val inputs = array(DialogInput(NORMAL_INPUT, "Server", "androidrivers.wordpress.com", textValidator() {
        str ->
        if (str.isNullOrEmpty()){
            context.toastee("Server is required", Duration.LONG)
        }
    }),
            DialogInput(NORMAL_INPUT, "Username", "username", textValidator() {
                str ->
                if (str.isNullOrEmpty()){
                    context.toastee("Username is required", Duration.LONG)
                }
            }),
            DialogInput(PASSWORD_INPUT, "Password", "password", textValidator() {
                str ->
                if (str.isNullOrEmpty()){
                    context.toastee("Password is required", Duration.LONG)
                }
            })
    )

    val dlg = createFlexibleInputDialog(context, "Connect to your blog", inputs) {
        d, res ->
        onOK(res)
        d?.dismiss()
    }
    dlg.show()
}

