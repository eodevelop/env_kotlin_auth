package com.env.auth.dto.response

import com.env.auth.entity.Member
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

data class SignUpResponse(
    @Schema(description = "회원 고유키", example = "123e4567-e89b-12d3-a456-426614174000")
    val id: UUID,
    @Schema(description = "회원 아이디", example = "colabear754")
    val account: String,
    @Schema(description = "회원 이름", example = "콜라곰")
    val name: String?,
    @Schema(description = "회원 나이", example = "27")
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