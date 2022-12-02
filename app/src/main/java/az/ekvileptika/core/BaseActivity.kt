package az.ekvileptika.core

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM: ViewModel, VB: ViewDataBinding>(iviewModel: Class<VM>): AppCompatActivity() {
    //layout builder
    @LayoutRes
    abstract fun getLayoutRes(): Int

    val viewBinding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as VB
    }

    val viewModel: VM by lazy {
        ViewModelProvider(this)[iviewModel]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutRes())
    }
}