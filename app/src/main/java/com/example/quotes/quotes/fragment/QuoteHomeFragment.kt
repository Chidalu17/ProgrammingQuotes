package com.example.quotes.quotes.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotes.R
import com.example.quotes.quotes.QuotesAdapter
import com.example.quotes.quotes.dto.Quotes
import com.example.quotes.quotes.viewmodel.QuotesViewModel
import com.example.quotes.util.nd.BaseInteractionListener
import com.example.quotes.util.nd.showToast
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_home.*


class QuoteHomeFragment : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var viewModel: QuotesViewModel
    private var listOfQuotes = ArrayList<Quotes>()
    private lateinit var quotesAdapter: QuotesAdapter
    private lateinit var layManager: LinearLayoutManager


    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getAllQuotes()
    }

    private fun initViews() {
        quotesAdapter = QuotesAdapter(listOfQuotes)
        layManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = quotesAdapter
        recyclerView.layoutManager = layManager
    }




    private fun getAllQuotes() {
        viewModel.getQuotes().observe(this, Observer {
            Log.e("QuotesHomeFragment", it.list.toString())
            if (it.isLoading)
                listener?.onShowProgress()
            else
                listener?.onHideProgress()

            if (!it.list.isNullOrEmpty()) {
                listOfQuotes.addAll(it.list as ArrayList<Quotes>)
                quotesAdapter.notifyDataSetChanged()
            }
            if (!it.error.isNullOrEmpty())
                showToast(context!!, it.error!!)
        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener : BaseInteractionListener {

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            QuoteHomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}