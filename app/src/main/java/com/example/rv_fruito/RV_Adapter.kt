package com.example.rv_fruito

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_rv.view.*

class RV_Adapter(var fruit: List<FruitData>)
    : RecyclerView.Adapter<RV_Adapter.RV_viewholder>(){

    class RV_viewholder(view: View) : RecyclerView.ViewHolder(view){
        var title = view.idtitle
        var fruitimg = view.fruits_img
        var quality = view.idQuality
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RV_viewholder {
        var itemview = LayoutInflater.from(parent.context)
                   .inflate(R.layout.view_rv
                       ,parent,
                       false)
        return RV_viewholder(itemview)
    }

    override fun onBindViewHolder(holder: RV_viewholder, position: Int) {
        var dummy_img:Int? = null
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,Fruit_detail::class.java)
            intent.putExtra("fruit",fruit[position])
            intent.putExtra("fruitImage",dummy_img)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text=fruit[position].title
        holder.quality.text = fruit[position].quality

        when(fruit[position].title!!.toLowerCase()){
            "banana"->{
                dummy_img = R.drawable.ic_banana
            }
            "red apples"->{
                dummy_img = R.drawable.ic_red_apples
            }
            "mango"->{
                dummy_img = R.drawable.ic_mango
            }
            "green apples"->{
                dummy_img = R.drawable.ic_green_apples
            }
            "orange"->{
                dummy_img = R.drawable.ic_orange
            }
            "papaya"->{
                dummy_img = R.drawable.ic_papaya
            }
            "strawberry"->{
                dummy_img = R.drawable.ic_strawberry
            }
            "red grapes"->{
                dummy_img = R.drawable.ic_red_grapes
            }
            "black grapes"->{
                dummy_img = R.drawable.ic_black_grapes
            }
            "blackberry"->{
                dummy_img = R.drawable.ic_blackberry
            }
            "cherry"->{
                dummy_img = R.drawable.ic_cherry
            }
            "green grapes"->{
                dummy_img = R.drawable.ic_green_grapes
            }
            "guava"->{
                dummy_img = R.drawable.ic_guava
            }

        }
        if (dummy_img != null) {
            holder.fruitimg.setImageResource(dummy_img)
        }
    }

    override fun getItemCount(): Int {
        return fruit.size
    }

}

