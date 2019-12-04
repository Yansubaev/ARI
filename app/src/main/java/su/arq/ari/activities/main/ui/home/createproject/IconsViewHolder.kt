package su.arq.ari.activities.main.ui.home.createproject

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class IconsViewHolder(
    itemView: View,
    private val onClickListener: ((view: View, viewHolder: RecyclerView.ViewHolder, position: Int)->Unit)?
) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    var icon: ImageView = itemView.findViewById(R.id.creating_project_icon)
    var checkMark: ImageView = itemView.findViewById(R.id.chosen_icon_check_mark)

    init { icon.setOnClickListener(this) }
    
    override fun onClick(v: View?) {
        if(v != null) onClickListener?.invoke(v, this, adapterPosition)
    }


}