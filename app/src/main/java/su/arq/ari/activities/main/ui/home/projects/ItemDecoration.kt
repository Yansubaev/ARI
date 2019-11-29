package su.arq.ari.activities.main.ui.home.projects

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt


class ItemDecoration(
    private var context: Context,
    private var paddingInDp: Float
) : RecyclerView.ItemDecoration() {
    private val padding: Int
    private val dist: Int

    init {
        var metrics = context.resources.displayMetrics
        padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, paddingInDp, metrics).roundToInt()
        dist = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 22f, metrics).roundToInt()
    }

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
        outRect.top = padding
        outRect.bottom = padding
    }
}