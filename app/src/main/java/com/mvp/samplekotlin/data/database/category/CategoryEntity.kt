package com.mvp.samplekotlin.data.database.category

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category_table")
class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
