package com.env.auth.service

import com.env.auth.dto.request.MemberUpdateRequest
import com.env.auth.dto.response.MemberInfoResponse
import com.env.auth.dto.response.MemberUpdateResponse
import com.env.auth.repository.MemberRepository
import com.env.auth.util.findByIdOrThrow
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val encoder: PasswordEncoder
) {
    @Transactional(readOnly = true)
    fun getMemberInfo(id: UUID) = MemberInfoResponse.from(memberRepository.findByIdOrThrow(id, "존재하지 않는 회원입니다."))

    @Transactional
    fun updateMember(id: UUID, request: MemberUpdateRequest): MemberUpdateResponse {
        val member = memberRepository.findByIdOrNull(id)?.takeIf { encoder.matches(request.password, it.password) }
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        member.update(request, encoder)
        return MemberUpdateResponse.of(true, member)
    }
}