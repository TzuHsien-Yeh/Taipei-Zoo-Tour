package com.tzuhsien.taipeizoo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.tzuhsien.taipeizoo.databinding.ActivityMainBinding

private const val ICON_ALPHA = 130

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment_activity_main)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        navController.addOnDestinationChangedListener { controller, destination, _ ->

            when (destination.id) {
                R.id.homeFragment -> {
                    toolbar.setNavigationIcon(R.drawable.ic_menu)
                    toolbar.title = getString(R.string.taipei_zoo)
                }

                R.id.areaFragment -> {
                    toolbar.setNavigationIcon(R.drawable.ic_back)
                    toolbar.navigationIcon?.alpha = ICON_ALPHA
                    toolbar.setNavigationOnClickListener { onBackPressed() }
                }

                R.id.animalFragment -> {
                    toolbar.setNavigationIcon(R.drawable.ic_back)
                    toolbar.navigationIcon?.alpha = ICON_ALPHA
                    toolbar.setNavigationOnClickListener { onBackPressed() }
                }
            }

        }

    }

    override fun onBackPressed() {
        navController.navigateUp()
    }
}