package com.si_base.data.table

import org.jetbrains.exposed.sql.Table

object StudentTable: Table() {

    override val tableName: String
        get() = "student"

    val studentId = varchar("student_id", 255)
    val name = varchar("name", 255)
    val origin = varchar("origin", 255)
    val datePlaceBirth = varchar("date_place_birth", 255)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(studentId)

}