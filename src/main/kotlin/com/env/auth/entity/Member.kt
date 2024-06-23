package com.env.auth.entity

import com.env.auth.common.type.MemberType
import com.env.auth.dto.request.MemberUpdateRequest
import com.env.auth.dto.request.SignUpRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import java.util.*

@Entity
class Member(
    @Column(nullable = false, scale = 20, unique = true)
    val account: String,
    @Column(nullable = false)
    var password: String,
    var name: String? = null,
    var age: Int? = null,
    @Enumerated(EnumType.STRING)
    val type: MemberType = MemberType.USER
) {
    val createdAt: LocalDateTime = LocalDateTime.now()
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null
    companion object {
        fun from(request: SignUpRequest, encoder: PasswordEncoder) = Member(
            account = request.account,
            password = encoder.encode(request.password),
            name = request.name,
            age = request.age
        )
    }

    fun update(newMember: MemberUpdateRequest, encoder: PasswordEncoder) {
        this.password = newMember.newPassword
            ?.takeIf { it.isNotBlank() }
            ?.let { encoder.encode(it) }
            ?: this.password
        this.name = newMember.name
        this.age = newMember.age
    }
}