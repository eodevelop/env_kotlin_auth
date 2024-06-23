package com.env.auth.dto.response

import com.env.auth.entity.Member
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

data class SignUpResponse(
    @Schema(description = "회원 고유키", example = "1111231-e89b-1234-a456-1122314123123")
    val id: UUID,
    @Schema(description = "회원 아이디", example = "user")
    val account: String,
    @Schema(description = "회원 이름", example = "user")
    val name: String?,
    @Schema(description = "회원 나이", example = "11")
    val age: Int?
) {
    companion object {
        fun from(member: Member) = SignUpResponse(
            id = member.id!!,
            account = member.account,
            name = member.name,
            age = member.age
        )
    }
}