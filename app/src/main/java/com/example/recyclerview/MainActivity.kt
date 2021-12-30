package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Contact
import com.example.recyclerview.model.ContactsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var contacts: ArrayList<Contact>

    private lateinit var rvAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);

        contacts = Contact.createContactList(20)

        setContentView(binding.root)

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to rvLists layoutManager
        binding.rvList.layoutManager = layoutManager

        // initialize the adapter,
        // and pass the required argument
        rvAdapter = ContactsAdapter(contacts)

        // attach adapter to the recycler view
        binding.rvList.adapter = rvAdapter
    }
}