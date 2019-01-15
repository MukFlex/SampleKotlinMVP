package com.mvp.samplekotlin.data.database.product

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "product_table")
class ProductEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
