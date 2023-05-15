package com.example.myamberone.data.maper

interface DataMaper<T> {
    fun toDomain():T
}