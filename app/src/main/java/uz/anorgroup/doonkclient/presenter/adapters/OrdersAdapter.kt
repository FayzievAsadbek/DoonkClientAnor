package uz.anorgroup.doonkclient.presenter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.anorgroup.doonkclient.R
import uz.anorgroup.doonkclient.data.OrdersInfo
import uz.anorgroup.doonkclient.databinding.SearchPageItemBinding

class OrdersAdapter : ListAdapter<OrdersInfo, OrdersAdapter.HistoryVH>(MyDifUtils) {
    private var itemListener: ((OrdersInfo) -> Unit)? = null

    object MyDifUtils : DiffUtil.ItemCallback<OrdersInfo>() {
        override fun areItemsTheSame(oldItem: OrdersInfo, newItem: OrdersInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: OrdersInfo, newItem: OrdersInfo): Boolean {
            return oldItem == newItem
        }
    }

    inner class HistoryVH(view: View) : RecyclerView.ViewHolder(view) {
        private val bind by viewBinding(SearchPageItemBinding::bind)

        init {
            bind.orderCost.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { it1 -> itemListener?.invoke(it1) }
            }
        }

        fun load() {
            val value = getItem(absoluteAdapterPosition)
            value?.let {
                bind.company.text = it.companyName
                bind.timeOut.text = it.timeOut
                bind.timeCome.text = it.timeCome
                bind.timeTrip.text = it.timeTrip
                bind.description.text = it.desciption
                bind.costText.text = it.cost
            }
        }
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        holder.load()
    }

    fun setListener(f: (OrdersInfo) -> Unit) {
        itemListener = f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH =
        HistoryVH(LayoutInflater.from(parent.context).inflate(R.layout.search_page_item, parent, false))
}