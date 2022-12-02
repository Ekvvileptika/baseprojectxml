package az.ekvileptika.presentation.pagefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import az.ekvileptika.baseapp.R
import az.ekvileptika.baseapp.databinding.FragmentPage1Binding
import az.ekvileptika.baseapp.databinding.RclElementBinding
import az.ekvileptika.core.BaseFragment
import az.ekvileptika.core.BaseRecyclerView
import az.ekvileptika.core.GenericViewHolder
import az.ekvileptika.data.characters.CharactersModel
import az.ekvileptika.utils.collectLatestLifecycleFlow
import az.ekvileptika.utils.load
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Page1Fragment: BaseFragment<FragmentPage1Binding>() {
    private val viewModel: Page1ViewModel by viewModels()
    override fun getLayoutRes(): Int = R.layout.fragment_page1
    //list
    private val bInterface = object: GenericViewHolder<CharactersModel, RclElementBinding>{
        override fun bind(item: CharactersModel, view: RclElementBinding) {
            view.element1.text = item.name
            view.characterimage.load(item.image)
        }
    }
    private var adapter: BaseRecyclerView<CharactersModel, RclElementBinding> = BaseRecyclerView(
        R.layout.rcl_element, bInterface
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.adapterCharacters.adapter = adapter
        viewModel.getDataInfo()
        collectLatestLifecycleFlow(viewModel.characters){ charactersList ->
            adapter.emmitData(charactersList!!)


        }
    }


}