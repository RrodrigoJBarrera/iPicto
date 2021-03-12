package com.rodrigojbarrera.ipicto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class PictoViewModel(private val repo: PictoRepository) : ViewModel() {

    fun fetchPictoToys() = liveData(Dispatchers.IO) {

        emit(Resource.Loading())
        try {
            emit(Resource.Succes(repo.getPictoToys()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }

    }
}

class  PictoViewModelFactory(private  val repo : PictoRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PictoRepository::class.java).newInstance(repo)
    }
}