package su.arq.ari.activities.main.ui.home.catalog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class CatalogAdapter(
    var context: Context,
    var models: MutableList<CatalogItemModel> = mutableListOf()
) : RecyclerView.Adapter<CatalogItemViewHolder>() {
    private var itemClickListener: ItemClickListener? = null
    private var onBindViewHolder:
            MutableList<((holder: CatalogItemViewHolder, position: Int) -> Unit)> = mutableListOf()


    fun addOnBindViewHolderListener(m: (holder: CatalogItemViewHolder, position: Int) -> Unit){
        onBindViewHolder.add(m)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        return CatalogItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_catalog_item,
                parent,
                false
            ),
            itemClickListener
        )
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        models[position].let {
            holder.itemName.text = it.itemName
            holder.itemPrice.text = it.itemPrice

        }
        onBindViewHolder.forEach { it(holder, position) }
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}