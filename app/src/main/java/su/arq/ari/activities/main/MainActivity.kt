package su.arq.ari.activities.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R
import su.arq.ari.activities.main.ui.home.createproject.CreateProjectFragment
import su.arq.ari.activities.main.ui.home.projects.ProjectsItemDecoration
import su.arq.ari.activities.main.ui.home.projects.ProjectIcon
import su.arq.ari.activities.main.ui.home.projects.ProjectModel
import su.arq.ari.activities.main.ui.home.projects.ProjectsAdapter

class MainActivity : AppCompatActivity(), ProjectsAdapter.ItemClickListener{
    private var TAG: String = javaClass.simpleName
    private lateinit var navController: NavController
    private lateinit var projectsRecycler: RecyclerView

    private lateinit var pa: ProjectsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        projectsRecycler = findViewById(R.id.recycler_projects)
        projectsRecycler.addItemDecoration(ProjectsItemDecoration(applicationContext))
        projectsRecycler.layoutManager = layoutManager
        val project = ArrayList<ProjectModel>()
        project.add(ProjectModel("First", ProjectIcon.BABYROOM))
        project.add(ProjectModel("Second", ProjectIcon.BEDROOM))
        project.add(ProjectModel("Third", ProjectIcon.HALL))
        pa = ProjectsAdapter(project, applicationContext)
        pa.addElement(ProjectModel("Forth", ProjectIcon.TOILET))

        projectsRecycler.adapter = pa.apply {
            setOnClickListener(this@MainActivity)
        }

    }

    override fun onItemClick(view: View?, position: Int) {
        if(pa.models[position].isCreatingModel){
            val cpf = CreateProjectFragment()
            cpf.show(supportFragmentManager, null)
        }
    }

}
