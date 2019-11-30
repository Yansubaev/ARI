package su.arq.ari.activities.main.ui.home.createproject

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class IconsItemDecoration(
    context: Context
) : RecyclerView.ItemDecoration(){
    private val padding: Int = context.resources.getDimensionPixelSize(R.dimen.fragment_create_project_icons_margin)
    private val dist: Int = context.resources.getDimensionPixelSize(R.dimen.fragment_create_project_icons_dist)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if(itemPosition == RecyclerView.NO_POSITION){
            return
        }
        if(itemPosition == 0){
            outRect.left = padding
        }else{
            outRect.left = dist
        }
        val adapter = parent.adapter
        if((adapter!=null) && (itemPosition == adapter.itemCount - 1)){
            outRect.right = padding
        }
        //outRect.top = padding
        //outRect.bottom = padding
    }


}