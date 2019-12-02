package su.arq.ari.activities.main.ui.home.projects

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class ProjectsViewHolder(
    itemView: View,
    private var clickListeners: List<((v: View?, position: Int)-> Unit)>
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var projectTitle: TextView = itemView.findViewById(R.id.title_project)
    var icon: ImageView = itemView.findViewById(R.id.card_project_icon)

    init { itemView.setOnClickListener(this) }

    override fun onClick(v: View?) {
        clickListeners.forEach{ it(v, adapterPosition ) }
    }
}