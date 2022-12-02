package az.ekvileptika.utils

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelProviderFactory<T: ViewModel>(
    private val viewmodelClass: Class<T>,
    private val viewmodelSupplier: Supplier<T>
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(viewmodelClass)){
            viewmodelSupplier.get() as T
        } else {
            throw IllegalArgumentException(viewmodelClass.name)
        }
    }
}