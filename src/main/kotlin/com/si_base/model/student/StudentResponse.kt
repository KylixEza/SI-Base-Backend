package com.si_base.model.student

import com.google.gson.annotations.SerializedName

data class StudentResponse(
    @SerializedName("student_id")
    val studentId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin")
    val origin: String,

    @SerializedName("date_place_birth")
    val datePlaceBirth: String,

    @SerializedName("avatar")
    val avatar: String
)
