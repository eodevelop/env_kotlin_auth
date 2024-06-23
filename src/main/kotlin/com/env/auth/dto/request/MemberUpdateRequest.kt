package com.env.auth.dto.request

import io.swagger.v3.oas.annotations.media.Schema

data class MemberUpdateRequest(
    @Schema(description = "회원 비밀번호", example = "user")
    var password: String,
    @Schema(description = "회원 새 비밀번호", example = "user")
    var newPassword: String? = null,
    @Schema(description = "회원 이름", example = "user")
    val name: String? = null,
    @Schema(description = "회원 나이", example = "10")
    val age: Int? = null
)