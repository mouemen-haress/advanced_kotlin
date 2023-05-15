package com.example.twowaydemo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.twowaydemo1.databinding.FragmentHomeBinding
import com.example.twowaydemo1.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var mBinding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        var input = requireArguments().getString("user_input")
        mBinding.myText.text = input
        return mBinding.root
    }
}