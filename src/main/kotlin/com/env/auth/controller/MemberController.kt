package com.env.auth.controller

import com.env.auth.config.security.UserAuthorize
import com.env.auth.dto.request.MemberUpdateRequest
import com.env.auth.dto.response.ApiResponse
import com.env.auth.service.MemberService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@UserAuthorize
@RestController
@RequestMapping("/member")
class MemberController(private val memberService: MemberService) {
    @Operation(summary = "회원 정보 조회")
    @GetMapping
    fun getMemberInfo(@AuthenticationPrincipal user: User) =
        ApiResponse.success(memberService.getMemberInfo(UUID.fromString(user.username)))

    @Operation(summary = "회원 정보 수정")
    @PutMapping
    fun updateMember(@AuthenticationPrincipal user: User, @RequestBody request: MemberUpdateRequest) =
        ApiResponse.success(memberService.updateMember(UUID.fromString(user.username), request))
}