package az.ekvileptika.presentation.anotherpage

import az.ekvileptika.baseapp.R
import az.ekvileptika.baseapp.databinding.FragmentPage1Binding
import az.ekvileptika.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnotherPageFragment: BaseFragment<FragmentPage1Binding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_page1
}