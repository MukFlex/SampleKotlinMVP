package com.mvp.samplekotlin.data.database.basket

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "basket_table")
 class BasketEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
