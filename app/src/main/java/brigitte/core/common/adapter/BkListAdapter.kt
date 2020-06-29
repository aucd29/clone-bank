package brigitte.core.common.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_bank.BR

interface BkDataType<DIFF> {
    val viewType: Int
    fun diff(): DIFF
}

class BkDiffer<DT: BkDataType<*>> : DiffUtil.ItemCallback<DT>() {
    override fun areItemsTheSame(oldItem: DT, newItem: DT): Boolean =
        oldItem.diff() == newItem.diff()
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DT, newItem: DT): Boolean =
        oldItem == newItem
}

open class BkListAdapter<T: BkDataType<*>, VM: ViewModel>(
    val residMap: Map<Int, Int>,
    private val viewModel: ViewModel? = null
): ListAdapter<T, BkViewHolder<T>>(BkDiffer<T>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BkViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = residMap[viewType]?.let { resid ->
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, resid, parent, false)
        } ?: error("resid == null")

        return BkViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = currentList[position]
        return if (item is BkDataType<*>) {
            item.viewType
        } else {
            super.getItemViewType(position)
        }
    }

    override fun onBindViewHolder(holder: BkViewHolder<T>, position: Int) {
        holder.bind(getItem(position), viewModel)
    }
}

class BkViewHolder<T>(
    private val binding: ViewDataBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T, viewmodel: ViewModel?) {
        binding.setVariable(BR.item, item)
        viewmodel?.let {
            binding.setVariable(BR.vm, it)
        }
        binding.executePendingBindings()
    }
}

class BkViewModel : ViewModel()

data class BkData(val id: Long)