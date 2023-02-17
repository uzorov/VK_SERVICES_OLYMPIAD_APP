package com.example.vk_services_olympiad_app.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.vk_services_olympiad_app.ServicesCardsAdapter
import com.example.vk_services_olympiad_app.databinding.FragmentServicesBinding
import com.example.vk_services_olympiad_app.view_model.ServicesViewModel


/**
 * This fragment shows the the status of the Mars photos web services transaction.
 */
class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentServicesBinding.inflate(inflater)


        binding.lifecycleOwner = this
        binding.viewModel = viewModel



        Log.d("bindingDebug", "servicesFragment");
        binding.servicesList.adapter = ServicesCardsAdapter(viewModel.itemOnClick)

        return binding.root
    }
}