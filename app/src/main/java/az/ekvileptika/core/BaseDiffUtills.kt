package az.ekvileptika.core

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtills<T: Any, Z: Any>(
    val oldList: List<T>,
    val newlist: List<Z>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newlist.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList == newlist
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  oldList.equals(newlist)
    }
}