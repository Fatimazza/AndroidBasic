package io.github.fatimazza.androidbasic.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import io.github.fatimazza.androidbasic.IntentMoveActivity
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

    companion object {
        const val EXTRA_NAME_FRAGMENT = "extra_name_fragment"

        var message: String = ""
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name = arguments?.getString(EXTRA_NAME_FRAGMENT)
        tvName.text = name
        tvMessage.text = message
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_other_activity -> {
                val moveIntent = Intent(activity, IntentMoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_show_dialog -> {
                val fragmentManager = childFragmentManager
                val optionDialogFragment = OptionDialogFragment()

                optionDialogFragment.show(
                    fragmentManager,
                    OptionDialogFragment::class.java.simpleName
                )
            }
        }
    }

    var optionDialogListener: OptionDialogFragment.OnOptionDialogListener =
        object : OptionDialogFragment.OnOptionDialogListener {
            override fun onOptionChosen(text: String) {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
            }
        }

}
