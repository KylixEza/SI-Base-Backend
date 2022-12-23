package com.si_base.data.repository

import com.si_base.model.student.StudentAvatarBody
import com.si_base.model.student.StudentBody
import com.si_base.model.student.StudentResponse
import com.si_base.model.user.UserBody
import com.si_base.model.user.UserResponse

interface SIBaseRepository {

    suspend fun addUser(body: UserBody) //clear

    suspend fun getUser(uid: String): UserResponse

    suspend fun addStudent(body: StudentBody) //clear

    suspend fun getStudents(): List<StudentResponse> //clear

    suspend fun getStudent(studentId: String): StudentResponse //clear

    suspend fun editStudent(studentId: String, body: StudentBody) //clear

    suspend fun deleteStudent(studentId: String) //clear

    suspend fun updateStudentAvatar(studentId: String, body: StudentAvatarBody) //clear
}