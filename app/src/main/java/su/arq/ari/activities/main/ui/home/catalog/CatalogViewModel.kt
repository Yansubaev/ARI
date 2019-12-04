package su.arq.ari.activities.main.ui.home.catalog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogViewModel : ViewModel() {
    var catalogItems: MutableLiveData<MutableList<CatalogItemModel>> = MutableLiveData()
    init {
        catalogItems.value = CatalogItemsProviderTemp.getCatalogItems().toMutableList()
    }

    fun getCatalogItemsModels() = catalogItems

    fun updateModels(models: MutableList<CatalogItemModel>){
        this.catalogItems.value = models
    }
}