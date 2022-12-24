package com.si_base.data.repository

import com.si_base.data.DatabaseFactory
import com.si_base.data.table.StudentTable
import com.si_base.data.table.UserTable
import com.si_base.model.student.StudentAvatarBody
import com.si_base.model.student.StudentBody
import com.si_base.model.student.StudentResponse
import com.si_base.model.user.UserBody
import com.si_base.model.user.UserResponse
import com.si_base.util.toStudentResponse
import com.si_base.util.toUserResponse
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class SIBaseRepositoryImpl(
    private val dbFactory: DatabaseFactory
): SIBaseRepository {

    override suspend fun addUser(body: UserBody): Unit = dbFactory.dbQuery {
        val user = UserTable.select { UserTable.uid eq body.uid }.firstOrNull()
        if (user == null) {
            UserTable.insert {
                it[uid] = body.uid
                it[email] = body.email
                it[name] = body.name
                it[phoneNumber] = body.phoneNumber
            }
        }
    }

    override suspend fun getUser(uid: String): UserResponse = dbFactory.dbQuery {
        UserTable.select { UserTable.uid eq uid }.mapNotNull { it.toUserResponse() }.single()
    }

    override suspend fun addStudent(body: StudentBody): Unit = dbFactory.dbQuery {
        StudentTable.insert {
            it[studentId] = body.studentId
            it[name] = body.name
            it[origin] = body.origin
            it[datePlaceBirth] = body.datePlaceBirth
        }
    }

    override suspend fun getStudents(): List<StudentResponse> = dbFactory.dbQuery {
        StudentTable.selectAll().map { it.toStudentResponse() }
    }

    override suspend fun getStudent(studentId: String): StudentResponse = dbFactory.dbQuery {
        StudentTable.select { StudentTable.studentId eq studentId }.map { it.toStudentResponse() }.single()
    }

    override suspend fun editStudent(studentId: String, body: StudentBody): Unit = dbFactory.dbQuery {
        StudentTable.update({ StudentTable.studentId eq studentId }) {
            it[this.studentId] = body.studentId
            it[name] = body.name
            it[origin] = body.origin
            it[datePlaceBirth] = body.datePlaceBirth
        }
    }

    override suspend fun deleteStudent(studentId: String): Unit = dbFactory.dbQuery {
        StudentTable.deleteWhere { StudentTable.studentId eq studentId }
    }

    override suspend fun updateStudentAvatar(studentId: String, body: StudentAvatarBody): Unit = dbFactory.dbQuery {
        StudentTable.update({ StudentTable.studentId eq studentId }) {
            it[avatar] = body.avatar
        }
    }
}