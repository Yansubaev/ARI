package su.arq.ari.activities.main.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import su.arq.ari.R

class BasketFragment : Fragment(){
    private lateinit var basketViewModel: BasketViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        basketViewModel =
            ViewModelProviders.of(this).get(BasketViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_basket, container, false)
        val textView: TextView = root.findViewById(R.id.text_basket)
        basketViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}