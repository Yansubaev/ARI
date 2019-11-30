package su.arq.ari.activities.main.ui.home.createproject

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class IconsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var icon: ImageView = itemView.findViewById(R.id.creating_project_icon)
    var checkMark: ImageView = itemView.findViewById(R.id.chosen_icon_check_mark)
}