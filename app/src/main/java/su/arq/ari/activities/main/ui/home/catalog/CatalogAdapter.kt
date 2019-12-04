package su.arq.ari.activities.main.ui.home.catalog

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

//Должен принимать в конструктор 'context' как Activity, иначе размер cardView задастся по умолчанию
class CatalogAdapter(
    var context: Context,
    var models: MutableList<CatalogItemModel> = mutableListOf()
) : RecyclerView.Adapter<CatalogItemViewHolder>() {
    private val TAG = javaClass.simpleName

    private var itemClickListeners: MutableList<((v: View?, position: Int)-> Unit)> = mutableListOf()
    private var favoriteClickListeners: MutableList<((v: View?, position: Int)-> Unit)> = mutableListOf()
    private var onBindViewHolderListeners:
            MutableList<((holder: CatalogItemViewHolder, position: Int) -> Unit)> = mutableListOf()

    fun addOnBindViewHolderListener(m: (holder: CatalogItemViewHolder, position: Int) -> Unit){
        onBindViewHolderListeners.add(m)
    }
    fun addOnClickListener(m: (v: View?, position: Int)-> Unit) {
        itemClickListeners.add(m)
    }
    fun addOnFavoriteIconClickListener(m: (v: View?, position: Int)-> Unit){
        favoriteClickListeners.add(m)
    }
    fun refreshModels(models: MutableList<CatalogItemModel>){
        this.models = models
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        return CatalogItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_catalog_item,
                parent,
                false
            ),
            itemClickListeners,
            favoriteClickListeners
        )
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        models[position].let {
            holder.itemName.text = it.itemName
            holder.itemPrice.text = it.itemPrice
            if(it.isFavorite){
                holder.itemFavIcon.setImageResource(R.drawable.ic_favorites)
            }else{
                holder.itemFavIcon.setImageResource(R.drawable.ic_not_favorites)
            }
        }
        //lp.height =
        val dm = DisplayMetrics()
        if(context is Activity){
            (context as Activity).windowManager.defaultDisplay.getMetrics(dm)
            val wd = dm.widthPixels
            val height = (wd - context.resources.getDimensionPixelSize(R.dimen.catalog_item_real_margin)
                    - 2*context.resources.getDimensionPixelSize(R.dimen.catalog_item_real_dist))/3
            holder.cardView.layoutParams.height = height
            Log.d(TAG, "HEIGHT = ${holder.cardView.layoutParams.height}")
        }else{
            Log.d(TAG, "'context' is not Activity. cardView's height set by default 120dp")
        }
        onBindViewHolderListeners.forEach { it(holder, position) }
    }
}