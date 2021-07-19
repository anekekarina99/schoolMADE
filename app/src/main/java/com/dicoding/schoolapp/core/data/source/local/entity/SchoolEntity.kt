package com.dicoding.schoolapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "sekolah")
data class SchoolEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "schoolId")
    var schoolId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "regional")
    var regional: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false



) : Parcelable
