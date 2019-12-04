package su.arq.ari.activities.main.ui.home.catalog

object CatalogItemsProviderTemp {
    fun getCatalogItems(): List<CatalogItemModel>{
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
        return catModels
    }
}