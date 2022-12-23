package com.si_base.util

import com.si_base.data.table.StudentTable
import com.si_base.data.table.UserTable
import com.si_base.model.student.StudentResponse
import com.si_base.model.user.UserResponse
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toUserResponse() = UserResponse(
    uid = this[UserTable.uid],
    name = this[UserTable.name],
    email = this[UserTable.email],
    phoneNumber = this[UserTable.phoneNumber]
)
fun ResultRow.toStudentResponse() = StudentResponse(
    studentId = this[StudentTable.studentId],
    name = this[StudentTable.name],
    origin = this[StudentTable.origin],
    datePlaceBirth = this[StudentTable.datePlaceBirth],
    avatar = this[StudentTable.avatar]
)