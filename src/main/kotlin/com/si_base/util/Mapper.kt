package com.si_base.util

import com.si_base.data.table.StudentTable
import com.si_base.model.student.StudentResponse
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toStudentResponse() = StudentResponse(
    studentId = this[StudentTable.studentId],
    name = this[StudentTable.name],
    origin = this[StudentTable.origin],
    datePlaceBirth = this[StudentTable.datePlaceBirth],
    avatar = this[StudentTable.avatar]
)