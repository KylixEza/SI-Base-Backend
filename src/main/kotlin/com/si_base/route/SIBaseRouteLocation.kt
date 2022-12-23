package com.si_base.route

import io.ktor.server.locations.*

@OptIn(KtorExperimentalLocationsAPI::class)
sealed class SIBaseRouteLocation {

    companion object {
        const val POST_USER = "/user"
        const val GET_USER = "/user/{uid}"
        const val POST_STUDENT = "/student"
        const val GET_STUDENTS = "/student"
        const val GET_STUDENT = "/student/{studentId}"
        const val PUT_STUDENT = "/student/{studentId}"
        const val DELETE_STUDENT = "/student/{studentId}"
        const val PUT_STUDENT_AVATAR = "/student/{studentId}/avatar"
    }

    @Location(POST_USER)
    class UserPostRoute

    @Location(GET_USER)
    data class UserGetRoute(val uid: String)

    @Location(POST_STUDENT)
    class StudentPostRoute

    @Location(GET_STUDENTS)
    class StudentListGetRoute

    @Location(GET_STUDENT)
    data class StudentGetRoute(val studentId: String)

    @Location(PUT_STUDENT)
    data class StudentPutRoute(val studentId: String)

    @Location(DELETE_STUDENT)
    data class StudentDeleteRoute(val studentId: String)

    @Location(PUT_STUDENT_AVATAR)
    data class StudentAvatarPutRoute(val studentId: String)
}