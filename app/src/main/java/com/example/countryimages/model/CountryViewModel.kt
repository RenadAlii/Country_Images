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

    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getPhotos()
                _status.value = "Success: ${listResult.size} flag photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}
