package su.arq.ari.activities.main.ui.home.catalog

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class CatalogItemViewHolder(
    itemView: View,
    private var clickListener: CatalogAdapter.ItemClickListener?
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var itemName: TextView = itemView.findViewById(R.id.catalog_item_name)
    var itemPrice: TextView = itemView.findViewById(R.id.catalog_item_price)
    var itemImage: ImageView = itemView.findViewById(R.id.card_catalog_item_image)
    var itemFavIcon: ImageView = itemView.findViewById(R.id.card_catalog_item_fav_icon)
    var itemGradient: ImageView = itemView.findViewById(R.id.card_catalog_gradient)
    private var cardView: CardView = itemView.findViewById(R.id.catalog_item_img_card)

    init { cardView.setOnClickListener(this) }

    override fun onClick(v: View?) {
        if(clickListener != null){
            clickListener?.onItemClick(v, adapterPosition )
        }
    }
}