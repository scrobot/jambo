package com.jambo.messanger.users.view.models

import com.jambo.messanger.users.data.models.UserStatus

data class UserView(
    val id: String,
    val username: String,
    val email: String?,
    val phone: String?,
    val status: UserStatus
)