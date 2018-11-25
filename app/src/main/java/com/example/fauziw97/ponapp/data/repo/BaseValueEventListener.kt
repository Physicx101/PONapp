package com.example.fauziw97.ponapp.data.repo

import com.example.fauziw97.ponapp.data.mapper.FirebaseMapper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class BaseValueEventListener<Model, Entity>(
    private val mapper: FirebaseMapper<Entity, Model>,
    private val callback: FirebaseDatabaseRepo.FirebaseDatabaseRepositoryCallback<Model>
) : ValueEventListener {

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        val data = mapper.mapList(dataSnapshot)
        callback.onSuccess(data)
    }

    override fun onCancelled(databaseError: DatabaseError) {
        callback.onError(databaseError.toException())
    }
}
