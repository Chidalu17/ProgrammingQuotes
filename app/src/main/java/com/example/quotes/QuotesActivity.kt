package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quotes.quotes.fragment.QuoteHomeFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class QuotesActivity : DaggerAppCompatActivity(),
    QuoteHomeFragment.OnFragmentInteractionListener{

    private var quotesFragment: QuoteHomeFragment? = null
    override fun onShowProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onBackPressed() {
        if(quotesFragment != null && quotesFragment!!.isAdded)
            super.onBackPressed()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        val fragment = QuoteHomeFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_quote,fragment)
            .commit()
    }
}
