package su.arq.ari.activities.main.ui.home.catalog

class CatalogItemModel(
    var itemName: String,
    var itemPrice: String
) {
    var isFavorite: Boolean = false
    var itemImage: Any = Any()
}