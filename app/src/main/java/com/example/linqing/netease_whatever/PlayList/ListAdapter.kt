package com.example.linqing.netease_whatever.PlayList

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.linqing.netease_whatever.ListDetail.PlaylistDetailActivity
import com.example.linqing.netease_whatever.R


class ListAdapter(internal var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //data
    private var list: ArrayList<Playlist?> = ArrayList()
    private var listCount = 0
    private var TITLE = 0
    private var nickname = ""
    private var ALBUM_TYPE = 1
    private var itembean: Playlist? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ALBUM_TYPE) {
            val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

            return MyViewHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.ablum_title, parent, false)


            return TitleHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleHolder) {
            if (position < listCount) {
                holder.titleTextView.text = "创建的歌单"


            } else if (position == listCount + 1) {
                holder.titleTextView.text = "收藏的歌单"

            }

        } else if (holder is MyViewHolder) {

            holder.textView.text = list[position]?.name

            Glide.with(context)
                    .load(list[position]?.coverImgUrl)//load(url)
                    .into(holder.imageView)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, PlaylistDetailActivity::class.java)
                intent.putExtra("id", list[holder.adapterPosition]?.id)

                context.startActivity(intent)

            }
            //歌单条目不一样时othertext的小小区别

            var otherText = "${list[position]?.trackCount}首"
            if (list[position]?.creator?.nickname != nickname) {
                otherText = "${list[position]?.trackCount}首 by ${list[position]?.creator?.nickname}"
            }
            holder.otherText.text = otherText
            holder.id = list[position]?.id.toString()


        }


    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == listCount + 1)
            return TITLE
        else
            return ALBUM_TYPE
    }

    fun getData(list: ArrayList<Playlist?>, nickname: String) {
        this.list = list.toMutableList() as ArrayList<Playlist?>
        this.nickname=nickname
        this.itembean=itembean
        list.forEach {
            if (it != null) {
                if (it.creator.nickname == nickname) {
                    listCount++
                }
            }
        }

        this.list.add(0,null)


        notifyDataSetChanged()

    }



    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val textView: TextView = itemview.findViewById(R.id.simple_name_Tv)
        val imageView: ImageView = itemview.findViewById(R.id.simple_cover_Iv)
        val otherText: TextView = itemview.findViewById(R.id.simple_edit_Tv)
        var id: String? = null
    }

    inner class TitleHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val titleTextView: TextView = itemview.findViewById(R.id.title_list_id)
    }


}
