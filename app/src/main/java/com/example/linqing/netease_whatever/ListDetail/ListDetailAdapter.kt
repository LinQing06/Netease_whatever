package com.example.linqing.netease_whatever.ListDetail

import android.content.Context
import android.content.Intent
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.linqing.netease_whatever.Music.MusicActivity
import com.example.linqing.netease_whatever.R
import kotlinx.android.synthetic.main.detail_item.view.*

class ListDetailAdapter(internal var context: Context) : RecyclerView.Adapter<ListDetailAdapter.DetailHolder>() {


    private var list: ArrayList<Playlist>?=null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListDetailAdapter.DetailHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.detail_item,p0,false)
        return DetailHolder(view)

    }

    override fun onBindViewHolder(holder: ListDetailAdapter.DetailHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent=Intent(context,MusicActivity::class.java)
            intent.putExtra("id",list!![holder.adapterPosition].id)//这里的！！emmm
            context.startActivity(intent)

        }
        //glide

        //number+music name+music author
        holder.songName.text=list!![position].name

    }


    fun getInfo(list:ArrayList<Playlist?>){
        this.list=list.toMutableList() as ArrayList<Playlist>?

    }
    override fun getItemCount(): Int {
        return list!!.size

    }

    inner class DetailHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val songName:TextView=itemView.findViewById(R.id.music_name)
        val musicNum:TextView=itemView.findViewById(R.id.list_number_pos)
        val songAuthor:TextView=itemView.findViewById(R.id.list_author)

    }


}