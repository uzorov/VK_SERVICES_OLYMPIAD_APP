package com.example.vk_services_olympiad_app.view_model

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vk_services_olympiad_app.model.Item
import com.example.vk_services_olympiad_app.network.VkApi
import com.example.vk_services_olympiad_app.view.ServiceMenuActivity
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class ServicesViewModel : ViewModel() {

    enum class VkApiStatus { LOADING, ERROR, DONE }


    private val _status = MutableLiveData<VkApiStatus>()


    val status: LiveData<VkApiStatus> = _status




    private val _data = MutableLiveData<List<Item>>()

    val data: LiveData<List<Item>> = _data


     val _selectedItem = MutableLiveData<Item>()

    val selectedItem: LiveData<Item> = _selectedItem



    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->

        _selectedItem.value = data.value?.get(position)

        val intent = Intent(view.context, ServiceMenuActivity::class.java)
        intent.putExtra("name", data.value?.get(position)?.name)
        intent.putExtra("desc", data.value?.get(position)?.description)
        intent.putExtra("servIc", data.value?.get(position)?.iconUrl)
        intent.putExtra("servUrl", data.value?.get(position)?.serviceUrl)
        view.context.startActivity(intent)

            Log.d(
                "oneOfTheItemsMustBeSelected",
                "Was selected item: " + (data.value?.get(position))
            )
        }


    init {
        getVkData()
    }



    private fun getVkData() {
        viewModelScope.launch {
            _status.value = VkApiStatus.LOADING
            try {
                Log.d("bindingDebug", "Succes");
                _data.value = VkApi.retrofitService.getData().items
                _status.value = VkApiStatus.DONE
            } catch (e: Exception) {
                Log.d("binding", "Fail");
                _status.value = VkApiStatus.ERROR
                _data.value = listOf()
            }
        }
    }
}