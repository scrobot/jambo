package com.jambo.messanger.users.view.models

data class CreateUserRequest(
    val nickname: String,
    val phone: String?,
    val email: String?,
    val password: String?
)