package su.arq.ari.activities.main.ui.home.projects

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R

class ProjectsAdapter(
    var models: List<ProjectModel>,
    private var context: Context
) : RecyclerView.Adapter<ProjectsViewHolder>(){
    private var itemClickListener: ItemClickListener? = null
    private var onBindViewHolder:
            MutableList<((holder: ProjectsViewHolder, position: Int) -> Unit)> = mutableListOf()
    private var creatingModel = CreatingProjectModel()

    init {
        val tmpModels: MutableList<ProjectModel> = models.toMutableList()
        tmpModels.add(creatingModel)
        models = mutableListOf<ProjectModel>().apply {
            models.forEach{ this.add(it) }
            add(creatingModel)
        }
    }

    fun setOnClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun addOnBindViewHolderListener(m: (holder: ProjectsViewHolder, position: Int) -> Unit){
        onBindViewHolder.add(m)
    }

    fun addElement(model: ProjectModel){
        models = mutableListOf<ProjectModel>().apply {
            models.forEach { if(!it.isCreatingModel) this.add(it) }
            this.add(model)
            this.add(creatingModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        return ProjectsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_project,
                parent,
                false
            ),
            itemClickListener
        )
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        models[position].let {
            holder.projectTitle.text = it.title
            holder.icon.setImageResource(it.icon.id)
        }
        onBindViewHolder.forEach { it(holder, position) }
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

}