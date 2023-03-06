package com.example.tallersemana7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tallersemana7.domain.model.Manager

@Entity(tableName = "MANAGER")
class ManagerEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "USERNAME")
    var userName: String? = null

    @ColumnInfo(name = "PASSWORD")
    var password: String? = null
}

fun Manager.mapToLocalEntity() = ManagerEntity().also {
    it.userName = this.username
    it.password = this.password
}

