package com.example.anindaemlak.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anindaemlak.R
import com.example.anindaemlak.model.Emlak
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_page.view.*

class EmlakRecyclerAdapter(private val emlakList: Emlak) :
    RecyclerView.Adapter<EmlakRecyclerAdapter.RowHolder>() {

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(emlakModel: Emlak, position: Int) {

            var town = ""
            var number_of_rooms = ""
            var price = ""

            if (emlakModel.results[position].address != null) {
                town = emlakModel.results[position].address.town ?: ""
            }

            if (emlakModel.results[position].number_of_rooms != null) {
                number_of_rooms = emlakModel.results[position].number_of_rooms ?: ""
            }

            if (emlakModel.results[position].price != null) {
                price = "${emlakModel.results[position].price}" ?: ""
            }

            itemView.location.text = town + "'de " + number_of_rooms
            itemView.pay.text = price + " ₺"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(emlakList, position)
        Picasso.get().load(emlakList.results[position].photos[0].file).into(holder.itemView.image)
    }

    override fun getItemCount(): Int = emlakList.count
}
