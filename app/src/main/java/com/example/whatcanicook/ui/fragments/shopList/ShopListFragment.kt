package com.example.whatcanicook.ui.fragments.shopList

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatcanicook.R
import com.example.whatcanicook.databinding.FragmentHomeBinding
import com.example.whatcanicook.databinding.FragmentShopListBinding


class ShopListFragment : Fragment() {

    private  var _binding: FragmentShopListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentShopListBinding.inflate(inflater,container,false)


        return binding.root
    }

}