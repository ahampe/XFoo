package com.example.xfooapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        val items = (0..99).map { it.toString() }
        rv.apply {
            setHasFixedSize(true)
            adapter = FooAdapter(items)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }
}

class FooAdapter(private val items: List<String>) : RecyclerView.Adapter<FooAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_foo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.itemView as? TextView)?.text = items[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

