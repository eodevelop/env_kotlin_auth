package com.env.auth.controller

import com.env.auth.dto.request.SignInRequest
import com.env.auth.dto.request.SignUpRequest
import com.env.auth.dto.response.ApiResponse
import com.env.auth.service.SignService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class SignController(private val signService: SignService) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest) = ApiResponse.success(signService.registMember(request))

    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest) = ApiResponse.success(signService.signIn(request))
}