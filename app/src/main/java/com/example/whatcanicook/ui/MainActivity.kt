package com.example.whatcanicook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.whatcanicook.R
import com.example.whatcanicook.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.favoriteRecipesFragment,
                R.id.shopListFragment,
                R.id.possibilitiesFragment
            )
        )

        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}




/*in the onCreate()
*
}*/

/*the MEOW BottomNavBar
*
        bottomNavigation = binding.bottomNavigationView
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_heart_favorites))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.add_shopping_cart))

        //set default
        bottomNavigation.show(1, true)

        //set click listener
        bottomNavigation.setOnClickMenuListener {
            when (it.id) {
                1 -> loadFragment(HomeFragment())
                2 -> loadFragment(FavoritesRecipesFragment())
                3 -> loadFragment(ShopListFragment())
            }
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        val fragment = HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.navHostFragment, fragment)
                .commit()

        val bundle  = fragment.arguments
        val key = bundle?.getString("key")
        }*/