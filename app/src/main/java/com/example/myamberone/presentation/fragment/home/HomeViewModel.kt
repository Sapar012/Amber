package com.example.myamberone.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myamberone.core.Error
import com.example.myamberone.core.Loading
import com.example.myamberone.core.Success
import com.example.myamberone.core.UIState
import com.example.myamberone.domain.usecase.GetJeweleryUseCase
import com.example.myamberone.presentation.model.HitUI
import com.example.myamberone.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getJeweleryUseCase: GetJeweleryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UIState<List<HitUI>?>>(UIState.Loading())
    val state = _state.asStateFlow()

    init {
        getMainJewelery()
    }

    private fun getMainJewelery() {
        viewModelScope.launch(Dispatchers.IO) {
            getJeweleryUseCase().collect() { MainResponseItem ->
                when (MainResponseItem) {
                    is Success -> {
                        _state.value = UIState.Success(MainResponseItem.data?.map { it.toUI() })
                    }

                    is Loading -> {
                        _state.value = UIState.Loading()
                    }

                    is Error -> {
                        _state.value = UIState.Error(msg = MainResponseItem.msg ?: "Error")
                    }
                }
            }
        }
    }
}