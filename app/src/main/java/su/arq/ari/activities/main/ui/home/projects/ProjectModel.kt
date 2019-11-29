package su.arq.ari.activities.main.ui.home.projects

open class ProjectModel(var title: String, var icon: ProjectIcon){
    open val isCreatingModel: Boolean = false
}

class CreatingProjectModel : ProjectModel("Создать новый", ProjectIcon._PLUS){
    override val isCreatingModel: Boolean = true
}