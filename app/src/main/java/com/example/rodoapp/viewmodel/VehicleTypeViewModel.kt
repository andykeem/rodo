package com.example.rodoapp.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rodoapp.model.VehicleType
import com.example.rodoapp.util.DataUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "VehicleTypeViewModel"
class VehicleTypeViewModel : ViewModel() {

    val vehicleTypeList = MutableLiveData<List<VehicleType>>()
    val showProgressBar = ObservableField<Boolean>()

    fun fetchVehicleTypeList() {
        showProgressBar.set(true)
        CoroutineScope(IO).launch {
            val list = retrieveVehicleTypeList()
            withContext(Main) {
                vehicleTypeList.value = list
                showProgressBar.set(false)
            }
        }
    }

    suspend fun retrieveVehicleTypeList(): List<VehicleType> {
        val fakeWebDelay = (1000..2000).shuffled().last().toLong()
        Log.d(TAG, "web delay took: ${fakeWebDelay / 1000.toDouble()} sec.")
        delay(fakeWebDelay)

        return DataUtil.vehicleTypeList
    }
}