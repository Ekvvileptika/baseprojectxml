package az.ekvileptika.presentation.mainactivity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import az.ekvileptika.baseapp.R
import az.ekvileptika.baseapp.databinding.ActivityMainBinding
import az.ekvileptika.core.BaseActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun getLayoutRes(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val layout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar_layout)
        val drawier = findViewById<DrawerLayout>(R.id.drawer_layout)

        //val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            navController.graph,
            drawier as DrawerLayout
        )
        //layout.setupWithNavController(toolbar, navController, appBarConfiguration)

        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}