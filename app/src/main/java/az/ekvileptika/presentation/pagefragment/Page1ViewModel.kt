package az.ekvileptika.presentation.pagefragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.ekvileptika.MainApplication
import az.ekvileptika.data.characters.CharactersModel
import az.ekvileptika.domain.CharactersRepository
import az.ekvileptika.utils.ResponseResources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class Page1ViewModel @Inject constructor(
    val repo: CharactersRepository
): ViewModel() {
    private val _characters: MutableStateFlow<List<CharactersModel>?> = MutableStateFlow(listOf())
    val characters = _characters.asStateFlow()

    fun getDataInfo() = viewModelScope.launch{
        val data = repo.getAllCharacters()

        when(data){
            is ResponseResources.Success -> {
                val responseResult = data.data?.results
                _characters.value = responseResult
            }

            is ResponseResources.Failure -> {

            }

            is ResponseResources.Loading -> {

            }
        }
    }
}