package com.si_base.data.table

import org.jetbrains.exposed.sql.Table

object UserTable: Table() {

    override val tableName: String
        get() = "user"

    val uid = varchar("uid", 255)
    val name = varchar("name", 255)
    val email = varchar("email", 255)
    val phoneNumber = varchar("phone_number", 255)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(uid)

}