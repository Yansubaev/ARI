package su.arq.ari.activities.main.ui.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is basket Fragment"
    }
    val text: LiveData<String> = _text
}