package io.github.fatimazza.androidbasic.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import io.github.fatimazza.androidbasic.R
import kotlinx.android.synthetic.main.fragment_other.*

class OtherFragment : Fragment(), View.OnClickListener {

    private val btnLast: Button
        get() = btn_last_fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLast.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_last_fragment -> {
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager?.beginTransaction()
                val lastFragment = LastFragment()

                fragmentTransaction?.let {
                    it.replace(R.id.frame_container, lastFragment)
                    it.addToBackStack(null)
                    it.commit()
                }
            }
        }
    }
}
