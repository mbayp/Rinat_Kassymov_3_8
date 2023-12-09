package com.example.rinat_kassymov_3_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rinat_kassymov_3_8.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val characterList: ArrayList<Character>,
    val onClick: (character: Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    inner class CharacterHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            val character = characterList[adapterPosition]
            binding.im.setImageResource(character.imageId)
            binding.tvTitle.text = character.title

            itemView.setOnClickListener { onClick.invoke(character) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        return CharacterHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind()
    }

    fun addCharacter(character: Character) {
        characterList.add(character)
        notifyDataSetChanged()
    }//вот тут этот метод нужен длоя того чтобы по очереди по 1 элементу добавлять в ресайлк вью понял
// ,но он щас нам не нужен так как мы сразу ему готовый лист из данных даем

}