package com.si_base.model.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("uid")
    val uid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phoneNumber: String
)
