package su.arq.ari.activities.main.ui.home.createproject

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import su.arq.ari.R

class CreateProjectFragment: BottomSheetDialogFragment() {
    private lateinit var iconsRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.bsheet_fragment_create_project, container, false)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        iconsRecycler = rootView.findViewById(R.id.create_project_icons_recycler)
        iconsRecycler.layoutManager = layoutManager
        iconsRecycler.addItemDecoration(IconsItemDecoration(context!!))
        iconsRecycler.adapter = IconsAdapter(context!!)

        return rootView
    }
}