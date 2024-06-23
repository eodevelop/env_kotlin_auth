package com.env.auth.repository

import com.env.auth.common.type.MemberType
import com.env.auth.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, UUID> {
    fun findByAccount(account: String): Member?
    fun findAllByType(type: MemberType): List<Member>
}