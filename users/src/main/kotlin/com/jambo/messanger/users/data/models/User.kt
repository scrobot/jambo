package com.jambo.messanger.users.data.models

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import java.io.Serializable
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.Email


data class User(
    @PrimaryKey
    val id: UUID,
    val nickname: String,
    val password: String,
    @Email
    val email: String?,
    val phone: String?,
    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime = OffsetDateTime.now(),
    val deletedAt: OffsetDateTime? = null,
    val status: UserStatus = UserStatus.NEW
): Serializable

enum class UserStatus {
    UNKNOWN, NEW, BLOCKED, NOT_VERIFIED, VERIFIED
}