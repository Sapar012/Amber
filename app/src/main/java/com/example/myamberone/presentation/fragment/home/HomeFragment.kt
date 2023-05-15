package com.example.myamberone.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myamberone.core.UIState
import com.example.myamberone.databinding.FragmentHomeBinding
import com.example.myamberone.presentation.model.HitUI
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterRv: HomeAdapterRv
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRequest()
    }

    private fun setupRequest() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("ololo", "setupRequest:{${it.msg}}")
                    }

                    is UIState.Loading -> {}

                    is UIState.Success -> {
                        setList(it.data!!)
                    }
                }
            }
        }
    }

    private fun setList(data: List<HitUI>) {
        adapterRv.setList(data)
        adapterRv = HomeAdapterRv()
        binding.rvHome2.adapter = adapterRv
    }
}