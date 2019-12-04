package su.arq.ari.activities.main.ui.home.createproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IconsViewModel : ViewModel() {
    var icons: MutableLiveData<Array<IconModel>> = MutableLiveData(iconModelsSource)

    fun getIconsModels() = icons

    fun updateIconModels(icons: Array<IconModel>){
        this.icons.value = icons
    }

    fun updateIconModel(iconModel: IconModel, pos: Int){
        this.icons.value?.set(pos, iconModel)

        val im = iconModelsSource
        im[pos] = iconModel
        this.icons.value = im
    }
}