package com.env.user.dto.request

import io.swagger.v3.oas.annotations.media.Schema

data class MemberUpdateRequest(
    @Schema(description = "회원 비밀번호", example = "1234")
    var password: String,
    @Schema(description = "회원 새 비밀번호", example = "1234")
    var newPassword: String? = null,
    @Schema(description = "회원 이름", example = "콜라곰")
    val name: String? = null,
    @Schema(description = "회원 나이", example = "27")
    val age: Int? = null
)