package com.si_base.data.table

import org.jetbrains.exposed.sql.SqlExpressionBuilder.isNotNull
import org.jetbrains.exposed.sql.Table

object StudentTable: Table() {

    override val tableName: String
        get() = "student"

    val studentId = varchar("student_id", 255)
    val name = varchar("name", 255).default("")
    val origin = varchar("origin", 255).default("")
    val datePlaceBirth = varchar("date_place_birth", 255).default("")
    val avatar = varchar("avatar", 512).default("")

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(studentId)

}