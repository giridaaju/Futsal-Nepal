package com.example.futsalnepalapp.files.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.util.Futsal
import kotlinx.android.synthetic.main.item_futsal_info.view.*

class FutsalAdapter(var futsals: List<Futsal>, itemClickListener: FutsalInfoItemClickListener) : RecyclerView.Adapter<FutsalAdapter.FutsalViewHolder>(){

    private val clickListener = itemClickListener

    inner class FutsalViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutsalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_futsal_info,
            parent,
            false
        )
        return FutsalViewHolder(view)
    }

    override fun onBindViewHolder(holder: FutsalViewHolder, position: Int) {
        holder.itemView.apply {
            tvFutsalName.text = futsals[position].name
            tvAddress.text = constructAddress(futsals[position].address, futsals[position].tole, futsals[position].city)
            tvPhoneNumber.text = futsals[position].phoneNumber
            tvHoursOpen.text = futsals[position].hoursOpen
        }

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(futsals[position])
        }
    }

    override fun getItemCount(): Int {
        val size = futsals.size
        Log.d("DATA_LIST" , "the list size is: $futsals")
        Log.d("LIST_SIZE" , "the list size is: $size")
        return size
    }

    private fun constructAddress(address : String, tole: String, city: String) : String {
        var fullAddress = ""
        if (address == " ") {
            fullAddress = "$tole, $city"
        }
        else {
            fullAddress = "$address, $tole, $city"
        }
        return fullAddress
    }


}