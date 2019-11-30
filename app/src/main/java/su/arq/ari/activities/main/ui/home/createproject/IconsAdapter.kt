package su.arq.ari.activities.main.ui.home.createproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R
import su.arq.ari.activities.main.ui.home.projects.ProjectIcon

class IconsAdapter(private var context: Context): RecyclerView.Adapter<IconsViewHolder>() {
    private val models: Array<IconModel> = arrayOf(
        IconModel(ProjectIcon.ROOM),
        IconModel(ProjectIcon.KITCHEN),
        IconModel(ProjectIcon.EAT_ROOM),
        IconModel(ProjectIcon.OFFICE),
        IconModel(ProjectIcon.BEDROOM),
        IconModel(ProjectIcon.BATHROOM),
        IconModel(ProjectIcon.BABYROOM),
        IconModel(ProjectIcon.HALL),
        IconModel(ProjectIcon.TOILET)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconsViewHolder {
        return IconsViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_create_project_icon,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: IconsViewHolder, position: Int) {
        models[position].let {
            holder.icon.setImageResource(it.icon.id)
            holder.checkMark.visibility = if(it.isSelected) View.VISIBLE else View.GONE
        }
    }
}