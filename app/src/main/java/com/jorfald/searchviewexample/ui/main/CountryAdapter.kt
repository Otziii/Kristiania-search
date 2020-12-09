package com.jorfald.searchviewexample.ui.main

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val context: Context,
    var countryList: List<String>
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(TextView(context))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]

        holder.textView.text = country
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}