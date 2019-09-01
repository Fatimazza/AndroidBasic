package io.github.fatimazza.androidbasic.fragment


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

import io.github.fatimazza.androidbasic.R
import kotlinx.android.synthetic.main.fragment_option_dialog.*


class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    private val rgOptions: RadioGroup
        get() = rg_options

    private val rbBlue: RadioButton
        get() = rb_blue

    private val rbRed: RadioButton
        get() = rb_red

    private val rbPurple: RadioButton
        get() = rb_purple

    private val rbGreen: RadioButton
        get() = rb_green

    private val btnChoose: Button
        get() = btn_dialog_choose

    private val btnClose: Button
        get() = btn_dialog_close

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose.setOnClickListener(this)
        btnClose.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_dialog_choose -> {
                val checkedRadioButtonId = rgOptions.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var favColor = ""
                    when (checkedRadioButtonId) {
                        R.id.rb_blue -> {
                            favColor = rbBlue.text.toString().trim()
                        }
                        R.id.rb_red -> {
                            favColor = rbRed.text.toString().trim()
                        }
                        R.id.rb_purple -> {
                            favColor = rbPurple.text.toString().trim()
                        }
                        R.id.rb_green -> {
                            favColor = rbGreen.text.toString().trim()
                        }
                    }
                }
            }
            R.id.btn_dialog_close -> {
                dialog.cancel()
            }
        }
    }

}
