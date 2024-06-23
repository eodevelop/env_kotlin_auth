package com.env.auth.dto.request

import io.swagger.v3.oas.annotations.media.Schema

data class SignInRequest(
    @Schema(description = "회원 아이디", example = "colabear754")
    val account: String,
    @Schema(description = "회원 비밀번호", example = "1234")
    val password: String
)
