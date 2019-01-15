package com.mvp.samplekotlin.data.database

interface DataSource<T> {
    //    https://developer.android.com/training/data-storage/room/defining-data
    //    https://android.jlelse.eu/repository-layer-using-room-and-dagger-2-android-12d311830fd9

    fun addItem(item: T)

    fun addItems(items: List<T>)

    fun updateItem(item: T)

    fun updateItems(item: List<T>)

    fun removeData(item: T)

    fun hasData(): Boolean
}