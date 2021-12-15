package br.com.vinnom.viperexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.vinnom.viperexample.databinding.FragmentGetRandomReferenceViewBinding
import br.com.vinnom.viperexample.presenter.GetRandomReferencePresenter

class GetRandomReferenceFragmentView : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGetRandomReferenceViewBinding.inflate(inflater, container, false)
        val view = binding.root

        val getRandomReferenceButton = binding.getRandomReferenceButton
        getRandomReferenceButton.setOnClickListener {
            GetRandomReferencePresenter().getRandomReferenceButtonClicked()
        }

        return view
    }

}