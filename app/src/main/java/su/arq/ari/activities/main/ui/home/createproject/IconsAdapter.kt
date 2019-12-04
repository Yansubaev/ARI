package su.arq.ari.activities.main.ui.home.createproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class IconsAdapter(private var context: Context): RecyclerView.Adapter<IconsViewHolder>() {
    private val TAG = javaClass.simpleName
    private var models: Array<IconModel> = /*iconModelsSource*/ arrayOf()
    private var onItemClick: ((view: View, viewHolder: RecyclerView.ViewHolder, position: Int)->Unit)? = null

    fun setOnItemClickListener(l: ((view: View, viewHolder: RecyclerView.ViewHolder, position: Int)->Unit)){
        onItemClick = l
    }

    fun refreshIcons(icons: Array<IconModel>){
        models = icons
        notifyDataSetChanged()

        Log.d(TAG, "METHOD refreshIcons")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconsViewHolder {
        Log.d(TAG, "METHOD onCreateViewHolder")

        return IconsViewHolder(LayoutInflater.from(context).inflate(
            R.layout.item_create_project_icon,
            parent,
            false
        ), onItemClick)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: IconsViewHolder, position: Int) {
        Log.d(TAG, "METHOD onBindViewHolder")

        models[position].let {
            holder.icon.setImageResource(it.icon.id)
            holder.checkMark.visibility = if(it.isSelected) View.VISIBLE else View.GONE
        }
    }
}