package com.example.recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemContactBinding

class ContactsAdapter(private val mContacts : List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root){

    }
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {

        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        with(holder){
            with(mContacts[position]){
                binding.contactName.text = this.name
                binding.messageButton.text = if (this.isOnline) "Message" else "Offline"
                binding.messageButton.isEnabled = this.isOnline
            }
        }
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
}