package com.example.zamona.myAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zamona.Data
import com.example.zamona.databinding.ItemViewBinding

class MyAdapter(private var list: ArrayList<Data>):RecyclerView.Adapter<MyAdapter.Vh>(){
    inner class Vh(private var itemViewBinding: ItemViewBinding):RecyclerView.ViewHolder(itemViewBinding.root)
    {
     fun bind(data: Data)
     {
        itemViewBinding.rasm.setImageResource(data.rasm)
        itemViewBinding.tv.text=data.text
         

     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
       return Vh(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int){
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
      return list.size
    }
}