package br.com.vinnom.viperexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.viperexample.databinding.FragmentDisplayRandomReferenceViewBinding

class DisplayRandomReferenceFragmentView(private val animeReferenceEntity: AnimeReferenceEntity) :
    Fragment() {

    private var _binding: FragmentDisplayRandomReferenceViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDisplayRandomReferenceViewBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.displayRandomReferenceAnimeName.text = animeReferenceEntity.animeName
        binding.displayRandomReferenceCharacterName.text = animeReferenceEntity.characterName
        binding.displayRandomReferenceQuote.text = animeReferenceEntity.quote
    }
}