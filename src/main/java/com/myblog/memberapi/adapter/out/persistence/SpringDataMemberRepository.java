package com.myblog.memberapi.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberRepository extends JpaRepository<MemberJpaEntity, Long> {

    boolean existsByEmail(String email);
}
