package com.example.countryimages.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryimages.network.CountryApi
import kotlinx.coroutines.launch

enum class FlagApiStatus { LOADING, ERROR, DONE }

class CountryViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<FlagApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<FlagApiStatus> = _status

    private val _photos = MutableLiveData<List<DataCountry>>()
    val photos: LiveData<List<DataCountry>> = _photos



    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            _status.value = FlagApiStatus.LOADING
            try {
                  _photos.value = CountryApi.retrofitService.getPhotos().data
                _status.value = FlagApiStatus.DONE
            } catch (e: Exception) {
                _status.value = FlagApiStatus.ERROR
                // to clear the RecyclerView.
                _photos.value = listOf()

            }
        }
    }
}
