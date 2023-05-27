package com.example.twowaydemo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.twowaydemo1.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        mBinding.btn.setOnClickListener(View.OnClickListener {
            var bundle: Bundle = bundleOf("user_input" to mBinding.edit.text.toString())
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment22, bundle)
        })
        return mBinding.root
    }

}