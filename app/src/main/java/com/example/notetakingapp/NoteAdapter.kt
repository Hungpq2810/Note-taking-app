package com.example.notetakingapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.databinding.NoteItemBinding
import com.example.notetakingapp.model.Note
import java.util.Random

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(p0: Note, p1: Note): Boolean {
            return p0.id == p1.id && p0.noteTitle == p1.noteTitle && p0.noteBody == p1.noteBody
        }

        override fun areContentsTheSame(p0: Note, p1: Note): Boolean {
            return p0 == p1
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(LayoutInflater.from(p0.context),p0, false))
    }

    override fun onBindViewHolder(p0: NoteViewHolder, p1: Int) {
        val note = differ.currentList[p1]
        p0.itemBinding.tvNoteTitle.text = note.noteTitle
        p0.itemBinding.tvNoteBody.text = note.noteBody
        val random = Random()
        val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        p0.itemBinding.tvNoteTitle.setBackgroundColor(color)
        p0.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(
                note = note
            )
            it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size;
    }

    class NoteViewHolder(val itemBinding: NoteItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
}