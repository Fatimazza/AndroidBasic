package io.github.fatimazza.androidbasic.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.fragment.LastFragment.Companion.message
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

                val bundle = Bundle()
                bundle.putString(LastFragment.EXTRA_NAME_FRAGMENT, "Hi, Izza")
                val hiddenMessage = "Your Message: Hi, Za, pakabar nich?"

                lastFragment.apply {
                    arguments = bundle
                    message = hiddenMessage
                }

                fragmentTransaction?.let {
                    it.replace(R.id.frame_container, lastFragment)
                    it.addToBackStack(null)
                    it.commit()
                }
            }
        }
    }
}
