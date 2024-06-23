package com.env.auth.common.Initializer

import com.env.auth.common.type.MemberType
import com.env.auth.entity.Member
import com.env.auth.repository.MemberRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AdminInitializer(
    private val memberRepository: MemberRepository,
    private val encoder: PasswordEncoder	// 추가
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        memberRepository.save(Member("admin", encoder.encode("admin"), "관리자", type = MemberType.ADMIN))	// 수정
    }
}