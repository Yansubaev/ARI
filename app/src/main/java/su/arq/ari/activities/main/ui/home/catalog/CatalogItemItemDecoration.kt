package su.arq.ari.activities.main.ui.home.catalog

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class CatalogItemItemDecoration(
    var spanCount: Int,
    context: Context
) : RecyclerView.ItemDecoration() {

    private val margin: Int = context.resources.getDimensionPixelSize(R.dimen.catalog_item_margin_left)
    private val dist: Int = context.resources.getDimensionPixelSize(R.dimen.catalog_item_dist)
    private val marginTop: Int = context.resources.getDimensionPixelSize(R.dimen.catalog_item_margin_bottom)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view) // item position
        val column = itemPosition % spanCount // item column

        if(itemPosition == RecyclerView.NO_POSITION){
            return
        }
        if(column == 0){
            outRect.left = margin
            outRect.right = dist/2
        }else{
            outRect.left = dist/2
            outRect.right = margin
        }
        outRect.top = marginTop/2
        outRect.bottom = marginTop/2
    }
}
