package com.example.lab1

import android.util.Log

class stopUpdate (private val name:String){

    private val repository = Repository

    public fun update(format: String, status: String) {
        repository.methodList.insert(
            0,
            String.format(
                format,
                name
            )
        )
        repository.status[name] = status
        Log.e("observe","Mytest:"+ name + status)
    }
}