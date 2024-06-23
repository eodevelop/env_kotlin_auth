package com.env.auth.dto.request

import io.swagger.v3.oas.annotations.media.Schema

data class SignInRequest(
    @Schema(description = "회원 아이디", example = "user")
    val account: String,
    @Schema(description = "회원 비밀번호", example = "user")
    val password: String
)
