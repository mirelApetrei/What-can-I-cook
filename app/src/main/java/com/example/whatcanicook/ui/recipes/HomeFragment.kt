package com.example.whatcanicook.ui.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.whatcanicook.R
import com.example.whatcanicook.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomNavigation: MeowBottomNavigation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.menu_book))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.favorites_icon))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.shopping_list))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.shop_flder))

//        bottomNavigation.show(1, true)
    }


}