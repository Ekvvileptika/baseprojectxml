package az.ekvileptika.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerView<T: Any, V: ViewDataBinding>(
    @LayoutRes val layoutID: Int,
    private val bindingInterface: GenericViewHolder<T, V>
): RecyclerView.Adapter<BaseRecyclerView.ViewHolder>() {
    private var inputdataset: ArrayList<T> = arrayListOf()

    class ViewHolder(val v: ViewDataBinding): RecyclerView.ViewHolder(v.root){
        fun <T: Any, V: ViewDataBinding> bind(
            item: T,
            bindingInterface: GenericViewHolder<T, V>
        ) = bindingInterface.bind(item, view = v as V)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: V = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutID, parent,
            false
        )

        return ViewHolder(view)
    }

    fun emmitData(data: List<T>){
        val du = BaseDiffUtills(inputdataset, data)
        val df = DiffUtil.calculateDiff(du)

        inputdataset.clear()
        inputdataset.addAll(data)

        df.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = inputdataset[position]
        holder.bind(item, bindingInterface )
    }

    override fun getItemCount(): Int = inputdataset.size
}

interface GenericViewHolder<T: Any, VB: ViewDataBinding>{
    fun bind(item: T, view: VB)
}