package com.si_base.data.repository

import com.si_base.model.student.StudentBody
import com.si_base.model.student.StudentResponse
import com.si_base.model.user.UserBody

interface SIBaseRepository {

    suspend fun addUser(body: UserBody) //clear

    suspend fun addStudent(body: StudentBody) //clear

    suspend fun getStudents(): List<StudentResponse> //clear

    suspend fun getStudent(studentId: String): StudentResponse //clear

    suspend fun editStudent(studentId: String, body: StudentBody) //clear

    suspend fun deleteStudent(studentId: String) //clear
}