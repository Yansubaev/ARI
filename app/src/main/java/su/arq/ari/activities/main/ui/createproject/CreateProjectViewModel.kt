package su.arq.ari.activities.main.ui.createproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateProjectViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is create project Fragment"
    }
    val text: LiveData<String> = _text

}