package su.arq.ari.activities.main

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import su.arq.ari.R
import su.arq.ari.activities.main.ui.home.catalog.CatalogAdapter
import su.arq.ari.activities.main.ui.home.catalog.CatalogItemItemDecoration
import su.arq.ari.activities.main.ui.home.catalog.CatalogItemModel
import su.arq.ari.activities.main.ui.home.createproject.CreateProjectFragment
import su.arq.ari.activities.main.ui.home.projects.ProjectsItemDecoration
import su.arq.ari.activities.main.ui.home.projects.ProjectIcon
import su.arq.ari.activities.main.ui.home.projects.ProjectModel
import su.arq.ari.activities.main.ui.home.projects.ProjectsAdapter
import kotlin.math.abs

class MainActivity :
    AppCompatActivity()
{
    private var TAG: String = javaClass.simpleName
    private lateinit var projectsRecycler: RecyclerView

    private lateinit var pa: ProjectsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setProjectsRecycler()
        //region Catalog recycler
        val catalogRecycler = findViewById<RecyclerView>(R.id.recycler_catalog)
        setCatalogRecycler(catalogRecycler)
        //endregion

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsed_toolbar_layout)
        val appBar = findViewById<AppBarLayout>(R.id.app_bar)
        setTypefaceToToolbar(collapsingToolbar)

        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, p1 ->
            appBarOffsetChangedHandler(appBar, p1)
        })
    }
    private fun setTypefaceToToolbar(c: CollapsingToolbarLayout){
        c.apply {
            val tf = Typeface.createFromAsset(applicationContext.assets, "fonts/ttnorms_bold.ttf")
            setCollapsedTitleTypeface(tf)
            setExpandedTitleTypeface(tf)
        }
    }
    private fun appBarOffsetChangedHandler(appBar: AppBarLayout, position: Int){
        Log.d(TAG, "OnOffsetChangedListener: position=$position")
        if (abs(position) - appBar.totalScrollRange == 0) {
            projectsRecycler.visibility = View.INVISIBLE
        } else {
            projectsRecycler.visibility = View.VISIBLE
        }
    }
    private fun setProjectsRecycler(){
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
        projectsRecycler.adapter = pa.apply { addOnClickListener { v, position ->
            onProjectItemClick(v, position)
        } }
    }
    private fun setCatalogRecycler(catalogRecycler: RecyclerView){
        catalogRecycler.layoutManager = GridLayoutManager(this, 2)
        val catModels = ArrayList<CatalogItemModel>()
        catModels.add(CatalogItemModel("First", "Price"))
        catModels.add(CatalogItemModel("Second", "Price"))
        catModels.add(CatalogItemModel("Third", "Price"))
        catModels.add(CatalogItemModel("Fourth", "Price"))
        catModels.add(CatalogItemModel("Fifth", "Price"))
        catModels.add(CatalogItemModel("Sixth", "Price"))
        catModels.add(CatalogItemModel("Seventh", "Price"))
        catModels.add(CatalogItemModel("Eighth", "Price"))
        catModels.add(CatalogItemModel("Ninth", "Price"))
        catModels.add(CatalogItemModel("Tenth", "Price"))
        catalogRecycler.adapter = CatalogAdapter(this, catModels).apply {
            addOnFavoriteIconClickListener { v, position ->  onFavoriteIconClick(v, position) }
        }
        catalogRecycler.addItemDecoration(CatalogItemItemDecoration(2, applicationContext))
    }

    private fun onProjectItemClick(view: View?, position: Int) {
        if(pa.models[position].isCreatingModel){
            val cpf = CreateProjectFragment()
            cpf.show(supportFragmentManager, null)
        }
    }
    private fun onFavoriteIconClick(view: View?, position: Int){
    }

}
