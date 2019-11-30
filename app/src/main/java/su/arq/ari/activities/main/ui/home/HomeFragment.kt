package su.arq.ari.activities.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import su.arq.ari.R
import su.arq.ari.activities.main.ui.home.projects.ProjectsItemDecoration
import su.arq.ari.activities.main.ui.home.projects.ProjectIcon
import su.arq.ari.activities.main.ui.home.projects.ProjectModel
import su.arq.ari.activities.main.ui.home.projects.ProjectsAdapter


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var projectsRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_projects, container, false)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        projectsRecycler = root.findViewById(R.id.recycler_projects)
        projectsRecycler.addItemDecoration(ProjectsItemDecoration(context!!))
        projectsRecycler.layoutManager = layoutManager
        val project = ArrayList<ProjectModel>()
        project.add(ProjectModel("First", ProjectIcon.BABYROOM))
        project.add(ProjectModel("Second", ProjectIcon.BEDROOM))
        project.add(ProjectModel("Third", ProjectIcon.HALL))
        val pa = ProjectsAdapter(project, context!!)
        pa.addElement(ProjectModel("Forth", ProjectIcon.TOILET))


        projectsRecycler.adapter = pa

/*        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        return root
    }
}