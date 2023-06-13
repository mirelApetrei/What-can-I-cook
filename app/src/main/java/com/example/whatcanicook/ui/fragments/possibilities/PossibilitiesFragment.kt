package com.example.whatcanicook.ui.fragments.possibilities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatcanicook.R
import com.example.whatcanicook.databinding.FragmentPossibilitiesBinding
import com.example.whatcanicook.databinding.FragmentShopListBinding


class PossibilitiesFragment : Fragment() {

    private var _binding: FragmentPossibilitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPossibilitiesBinding.inflate(inflater, container, false)

        return binding.root
    }

}