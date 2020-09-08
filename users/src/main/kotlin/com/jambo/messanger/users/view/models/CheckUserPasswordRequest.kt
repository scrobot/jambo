package com.jambo.messanger.users.view.models

data class CheckUserPasswordRequest(
    val nickname: String,
    val password: String
)