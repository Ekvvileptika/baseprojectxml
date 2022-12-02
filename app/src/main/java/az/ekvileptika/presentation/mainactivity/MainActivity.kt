package az.ekvileptika.presentation.mainactivity

import android.os.Bundle
import az.ekvileptika.baseapp.R
import az.ekvileptika.baseapp.databinding.ActivityMainBinding
import az.ekvileptika.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.activity_main


}