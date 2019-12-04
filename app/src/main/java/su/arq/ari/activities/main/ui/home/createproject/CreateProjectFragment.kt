package su.arq.ari.activities.main.ui.home.createproject

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import su.arq.ari.R

class CreateProjectFragment: BottomSheetDialogFragment() {
    private val TAG = javaClass.simpleName

    private lateinit var iconsRecycler: RecyclerView
    private val iconsViewModel by lazy { ViewModelProviders.of(this).get(IconsViewModel::class.java) }

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
        val ia = IconsAdapter(context!!)
        ia.setOnItemClickListener { v, vh, p -> onIconSelected(v, vh, p) }
        iconsRecycler.adapter = ia

        iconsViewModel.getIconsModels().observe(this, Observer {
            it.let {
                ia.refreshIcons(it)
            }
        })

        return rootView
    }

    private fun onIconSelected(v: View, vh: RecyclerView.ViewHolder, p: Int){
        Log.d(TAG, "METHOD onIconSelected, position=$p")

        val im = iconModelsSource[p]
        im.isSelected = true
        iconsViewModel.updateIconModel(im, p)
    }
}