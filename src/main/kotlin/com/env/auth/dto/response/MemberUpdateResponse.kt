package com.env.auth.dto.response

import com.env.auth.entity.Member
import io.swagger.v3.oas.annotations.media.Schema

data class MemberUpdateResponse(
    @Schema(description = "회원 정보 수정 성공 여부", example = "true")
    val result: Boolean,
    @Schema(description = "회원 이름", example = "콜라곰")
    val name: String?,
    @Schema(description = "회원 나이", example = "27")
    val age: Int?
) {
    companion object {
        fun of(result: Boolean, member: Member) = MemberUpdateResponse(
            result = result,
            name = member.name,
            age = member.age
        )
    }
}