package com.example.practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var nameList: java.util.ArrayList<ModelList?>?) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var listCharacters=ArrayList<String>()
    private lateinit var context: Context

    fun setData(userName: ArrayList<ModelList>) {
        this.listCharacters = userName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listCharacters[position])
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvName: TextView? = null

        init {
            tvName = itemView.findViewById(R.id.tv_name)
        }

        fun onBind(character: String) {
            tvName?.text = character
        }
    }
}
