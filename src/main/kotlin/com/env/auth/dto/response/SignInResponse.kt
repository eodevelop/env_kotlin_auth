package com.env.auth.dto.response

import com.env.auth.common.type.MemberType
import io.swagger.v3.oas.annotations.media.Schema

data class SignInResponse(
    @Schema(description = "회원 이름", example = "콜라곰")
    val name: String?,
    @Schema(description = "회원 유형", example = "USER")
    val type: MemberType,
    val token: String
)