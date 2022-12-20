package com.si_base.data

import com.si_base.data.table.StudentTable
import com.si_base.data.table.UserTable
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseFactory(
    private val dataSource: HikariDataSource
) {

    init {
        Database.connect(dataSource)
        transaction {
            val tables = listOf(UserTable, StudentTable)
            tables.forEach { table ->
                SchemaUtils.create(table)
                SchemaUtils.createMissingTablesAndColumns(table)
            }
        }
    }

    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(Dispatchers.IO) {
            transaction { block() }
        }

}