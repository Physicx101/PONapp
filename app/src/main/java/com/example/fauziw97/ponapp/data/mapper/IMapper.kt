package com.example.fauziw97.ponapp.data.mapper

interface IMapper<From, To> {

    fun map(from: From): To
}