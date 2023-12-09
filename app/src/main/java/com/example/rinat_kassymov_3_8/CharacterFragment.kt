package com.example.rinat_kassymov_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.rinat_kassymov_3_8.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val characterList = arrayListOf(
        Character(R.drawable.character1, "Christopher Moltisanti"),
        Character(R.drawable.character2, "Tony Blundetto,"),
        Character(R.drawable.character3, "Tony Soprano,"),
        Character(R.drawable.charcter4, "Silvio Dante,"),
    )
    private val adapter = CharacterAdapter(characterList, this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter
        Toast.makeText(requireContext(), "Charchter fragment", Toast.LENGTH_SHORT).show()
    }

    private fun onClick(character: Character) {
        findNavController().navigate(R.id.detailFragment, bundleOf("key" to character))
    }
}
