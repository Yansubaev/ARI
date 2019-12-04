package su.arq.ari.activities.main.ui.home.createproject

import su.arq.ari.activities.main.ui.home.projects.ProjectIcon

data class IconModel(val icon: ProjectIcon) {
    var isSelected: Boolean = false
}

val iconModelsSource: Array<IconModel>
    get() = arrayOf(
        IconModel(ProjectIcon.ROOM),
        IconModel(ProjectIcon.KITCHEN),
        IconModel(ProjectIcon.EAT_ROOM),
        IconModel(ProjectIcon.OFFICE),
        IconModel(ProjectIcon.BEDROOM),
        IconModel(ProjectIcon.BATHROOM),
        IconModel(ProjectIcon.BABYROOM),
        IconModel(ProjectIcon.HALL),
        IconModel(ProjectIcon.TOILET)
    )