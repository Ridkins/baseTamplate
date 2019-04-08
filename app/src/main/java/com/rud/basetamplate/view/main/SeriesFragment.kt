package com.rud.basetamplate.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rud.basetamplate.R
import com.rud.basetamplate.misc.ext.gone
import org.koin.android.architecture.ext.viewModel

import com.rud.basetamplate.misc.ext.observe
import com.rud.basetamplate.misc.ext.visible
import com.rud.basetamplate.view.BaseFragment
import com.rud.basetamplate.view.main.MainViewModel
import com.rud.basetamplate.view.main.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.yesButton
import org.koin.android.architecture.ext.viewModel

class SeriesFragment : BaseFragment() {

    val viewModel: MainViewModel by viewModel()

    private var adapter: MovieAdapter = MovieAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        //Current currency
        observe(viewModel.series, {
            it?.let {
                adapter.dataList = it
            }
            showNoDataFound(adapter.dataList.isEmpty())
        })

        //ProgressBar
        observe(viewModel.isDataLoading, {
            if (it == true) {
                viewProgressBar.visible()
            } else {
                viewProgressBar.gone()
            }
        })

        observe(viewModel.exception, {
            showErrorMessage(it?.message)
        })
    }

    private fun showErrorMessage(message: String?) {
        message?.let {
            alert(message, getString(R.string.error)) {
                yesButton { }
            }.show()
            viewModel.exception.value = null
        }
    }

    private fun showNoDataFound(show: Boolean) {
        if (show) {
            viewError.visible()
            textViewError.text = getString(R.string.no_series_found)
        } else {
            viewError.gone()
        }
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
    }
}