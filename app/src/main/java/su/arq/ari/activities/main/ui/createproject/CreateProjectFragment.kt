package su.arq.ari.activities.main.ui.createproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import su.arq.ari.R
import su.arq.ari.activities.main.ui.search.SearchViewModel

class CreateProjectFragment : Fragment() {
    private lateinit var createProjectViewModel: CreateProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createProjectViewModel =
            ViewModelProviders.of(this).get(CreateProjectViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_create_project, container, false)
        val textView: TextView = root.findViewById(R.id.text_create_project)
        createProjectViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}