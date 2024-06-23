package com.env.auth.dto.response

import com.env.auth.common.type.MemberType
import com.env.auth.entity.Member
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.*

data class MemberInfoResponse(
    @Schema(description = "회원 고유키", example = "123e4567-e89b-12d3-a456-426614174000")
    val id: UUID,
    @Schema(description = "회원 아이디", example = "colabear754")
    val account: String,
    @Schema(description = "회원 이름", example = "콜라곰")
    val name: String?,
    @Schema(description = "회원 나이", example = "27")
    val age: Int?,
    @Schema(description = "회원 타입", example = "USER")
    val type: MemberType,
    @Schema(description = "회원 생성일", example = "2023-05-11T15:00:00")
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(member: Member) = MemberInfoResponse(
            id = member.id!!,
            account = member.account,
            name = member.name,
            age = member.age,
            type = member.type,
            createdAt = member.createdAt
        )
    }
}