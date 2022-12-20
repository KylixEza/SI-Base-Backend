package com.si_base.route

import com.si_base.data.repository.SIBaseRepository
import com.si_base.model.student.StudentBody
import com.si_base.model.user.UserBody
import com.si_base.route.RouteResponseHelper.buildListJSON
import com.si_base.route.RouteResponseHelper.buildSingleException
import com.si_base.route.RouteResponseHelper.buildSingleJSON
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.locations.*
import io.ktor.server.locations.post
import io.ktor.server.locations.put
import io.ktor.server.request.*

@OptIn(KtorExperimentalLocationsAPI::class)
class SIBaseRoute(
    private val repository: SIBaseRepository
) {
    private fun Route.postUser() {
        post<SIBaseRouteLocation.UserPostRoute> {
            val body = try {
                call.receive<UserBody>()
            } catch (e: Exception) {
                call buildSingleException e
                return@post
            }

            call buildSingleJSON { repository.addUser(body) }
        }
    }

    private fun Route.postStudent() {
        post<SIBaseRouteLocation.StudentPostRoute> {
            val body = try {
                call.receive<StudentBody>()
            } catch (e: Exception) {
                call buildSingleException e
                return@post
            }

            call buildSingleJSON { repository.addStudent(body) }
        }
    }

    private fun Route.getStudents() {
        get<SIBaseRouteLocation.StudentListGetRoute> {
            call buildListJSON  { repository.getStudents() }
        }
    }

    private fun Route.getStudent() {
        get<SIBaseRouteLocation.StudentGetRoute> {
            val studentId = try {
                call.parameters["studentId"]
            } catch (e: Exception) {
                call buildSingleException e
                return@get
            } ?: ""

            call buildSingleJSON { repository.getStudent(studentId) }
        }
    }

    private fun Route.putStudent() {
        put<SIBaseRouteLocation.StudentPutRoute> {
            val studentId = try {
                call.parameters["studentId"]
            } catch (e: Exception) {
                call buildSingleException e
                return@put
            } ?: ""

            val body = try {
                call.receive<StudentBody>()
            } catch (e: Exception) {
                call buildSingleException e
                return@put
            }

            call buildSingleJSON { repository.editStudent(studentId, body) }
        }
    }

    private fun Route.deleteStudent() {
        delete<SIBaseRouteLocation.StudentDeleteRoute> {
            val studentId = try {
                call.parameters["studentId"]
            } catch (e: Exception) {
                call buildSingleException e
                return@delete
            } ?: ""

            call buildSingleJSON { repository.deleteStudent(studentId) }
        }
    }

    fun Route.initRoutes() {
        postUser()
        postStudent()
        getStudents()
        getStudent()
        putStudent()
        deleteStudent()
    }

}