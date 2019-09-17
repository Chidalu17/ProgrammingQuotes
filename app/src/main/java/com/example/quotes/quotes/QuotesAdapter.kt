package com.example.quotes.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotes.R
import com.example.quotes.quotes.dto.Quotes
import com.example.quotes.quotes.fragment.QuoteHomeFragment

class QuotesAdapter(private val list: List<Quotes>)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quotes: Quotes = list[position]
        holder.bind(quotes)
    }

    override fun getItemCount(): Int = list.size

}

class ViewHolder(inflater: LayoutInflater?, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater?.inflate(R.layout.item, parent, false)!!) {
        private var mQuotesView: TextView? = null
        private var mAuthorView: TextView? = null




        init {
            mQuotesView = itemView.findViewById(R.id.quotes)
            mAuthorView = itemView.findViewById(R.id.author)

        }

        fun bind(quotes: Quotes) {
            mQuotesView?.text = quotes.en
            mAuthorView?.text= quotes.author
        }

}
