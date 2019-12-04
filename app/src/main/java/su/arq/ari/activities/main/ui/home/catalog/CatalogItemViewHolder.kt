package su.arq.ari.activities.main.ui.home.catalog

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class CatalogItemViewHolder(
    itemView: View,
    private var clickListeners: List<((v: View?, position: Int)-> Unit)>,
    private var favoriteClickListeners: List<((v: View?, position: Int)-> Unit)>
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var itemName: TextView = itemView.findViewById(R.id.catalog_item_name)
    var itemPrice: TextView = itemView.findViewById(R.id.catalog_item_price)
    var itemImage: ImageView = itemView.findViewById(R.id.card_catalog_item_image)
    var itemFavIcon: ImageView = itemView.findViewById(R.id.card_catalog_item_fav_icon)
    var cardView: CardView = itemView.findViewById(R.id.catalog_item_img_card)

    init {
        cardView.setOnClickListener(this)
        itemFavIcon.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.card_catalog_item_fav_icon){
            favoriteClickListeners.forEach{ it(v, adapterPosition) }
        }else{
            clickListeners.forEach{ it(v, adapterPosition) }
        }
    }
}

enum class FavoriteIcon(val id: Int){
    CHECKED(R.drawable.ic_favorites),
    NOT_CHECKED(R.drawable.ic_not_favorites)
}