package az.ekvileptika.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment<VB: ViewDataBinding>: Fragment(){
    @LayoutRes
    abstract fun getLayoutRes(): Int


    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    private fun initializeController(inflater: LayoutInflater, container: ViewGroup) {
        _binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeController(inflater, container!!)
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}