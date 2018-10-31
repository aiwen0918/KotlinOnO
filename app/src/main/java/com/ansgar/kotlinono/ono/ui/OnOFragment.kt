package com.ansgar.kotlinono.ono.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinono.R

class OnOFragment : Fragment() {

    companion object {
        fun newInstance() = OnOFragment()
    }

    private lateinit var viewModel: OnOViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ono_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OnOViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
