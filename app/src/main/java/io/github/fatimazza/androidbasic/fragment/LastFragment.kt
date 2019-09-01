package io.github.fatimazza.androidbasic.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import io.github.fatimazza.androidbasic.R
import kotlinx.android.synthetic.main.fragment_last.*


class LastFragment : Fragment(), View.OnClickListener {

    private val tvName: TextView
        get() = tv_last_name

    private val tvMessage: TextView
        get() = tv_last_message

    private val btnOtherActivity: Button
        get() = btn_other_activity

    private val btnDialog: Button
        get() = btn_show_dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnOtherActivity.setOnClickListener(this)
        btnDialog.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_other_activity -> {
            }
            R.id.btn_show_dialog -> {
            }
        }
    }

}
