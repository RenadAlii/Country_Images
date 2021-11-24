package com.example.countryimages.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryimages.network.CountryApi
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<List<DataCountry>>()
    val photos: LiveData<List<DataCountry>> = _photos



    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            try {
                  _photos.value = CountryApi.retrofitService.getPhotos().data
                _status.value ="success"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}
