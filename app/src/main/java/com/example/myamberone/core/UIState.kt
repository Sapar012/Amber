package com.example.myamberone.core

sealed class UIState<T>() {
    class Success<T>(val data: T) : UIState<T>()
    class Loading<T>() : UIState<T>()
    class Error<T>(val msg: String) : UIState<T>()
}
