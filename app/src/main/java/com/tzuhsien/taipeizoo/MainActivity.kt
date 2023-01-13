package com.tzuhsien.taipeizoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.BuildConfig
import com.tzuhsien.taipeizoo.databinding.ActivityMainBinding
import timber.log.Timber

private const val ICON_ALPHA = 130

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        navController = findNavController(R.id.nav_host_fragment_activity_main)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        navController.addOnDestinationChangedListener { controller, destination, _ ->

            when (destination.id) {
                R.id.homeFragment -> {
                    toolbar.setNavigationIcon(R.drawable.ic_menu)
                    binding.toolbarText.text = getString(R.string.taipei_zoo)
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