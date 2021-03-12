package com.rodrigojbarrera.ipicto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rodrigojbarrera.ipicto.databinding.FragmentMainPictoBinding


class MainPictoFragment : Fragment(R.layout.fragment_main_picto), PictoAdapter.OnPictoClick {

    private lateinit var binding: FragmentMainPictoBinding

    private lateinit var adapter: PictoAdapter


    private val viewModel by viewModels<PictoViewModel> {
        PictoViewModelFactory(PictoRepositoryImpl(PictoDataSource(RetroFitClient.webService)))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainPictoBinding.bind(view)


        viewModel.fetchPictoToys().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("Picto", "Loading...")
                }
                is Resource.Succes -> {



                    adapter = PictoAdapter(result.data, this)

                    binding.rvPicto.adapter = adapter

                    Log.d("Picto", "Succes ${result.data.size.toString()}")

                }
                is Resource.Failure -> {
                    Log.d("PictoError", "${result.exception}")
                }
            }
        })
    }

    override fun onPictoClick(pictograms: Pictograms) {
        Log.d("Picto", pictograms._id.toString())
        Log.d("Picto", pictograms.categories.toString())
    }


}