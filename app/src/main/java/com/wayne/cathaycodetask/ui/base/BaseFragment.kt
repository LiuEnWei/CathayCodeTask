package com.wayne.cathaycodetask.ui.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.wayne.cathaycodetask.R


abstract class BaseFragment(@LayoutRes contentLayoutId: Int): Fragment(contentLayoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun showErrorMessage(message: String?, okClickListener: DialogInterface.OnClickListener? = null): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(R.string.oops)
        dialog.setMessage(message)
        dialog.setCancelable(false)
        dialog.setPositiveButton(android.R.string.ok, okClickListener?: object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.dismiss()
            }
        })
        return dialog.show()
    }
}