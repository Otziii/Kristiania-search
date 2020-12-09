package com.jorfald.searchviewexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorfald.searchviewexample.R

class MainFragment : Fragment() {

    private lateinit var countrySearchView: SearchView
    private lateinit var searchEditText: EditText
    private lateinit var countryRecyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter
    private val fullCountryList = listOf(
        "Norge",
        "Sverige",
        "Danmark",
        "England",
        "Zimbabwe",
        "India",
        "Kina",
        "USA",
        "Norfolkøya"
    )

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        countrySearchView = view.findViewById(R.id.country_search_view)
        searchEditText = view.findViewById(R.id.search_edit_text)
        countryRecyclerView = view.findViewById(R.id.country_recycler_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryAdapter = CountryAdapter(
            requireContext(),
            fullCountryList
        )

        countryRecyclerView.layoutManager = LinearLayoutManager(context)
        countryRecyclerView.adapter = countryAdapter

        countrySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String): Boolean {
                filterList(text)

                return false
            }

            override fun onQueryTextChange(text: String): Boolean {
                filterList(text)

                return false
            }
        })

        searchEditText.addTextChangedListener { text ->
            filterList(text.toString())
        }
    }

    fun filterList(queryText: String) {
        val filteredList = mutableListOf<String>()

        for (country in fullCountryList) {
            if (country.contains(queryText, true)) {
                filteredList.add(country)
            }
        }

        countryAdapter.countryList = filteredList
        countryAdapter.notifyDataSetChanged()
    }
}