package com.si_base.model.student

import com.google.gson.annotations.SerializedName

data class StudentAvatarBody(
    @SerializedName("avatar")
    val avatar: String
)
