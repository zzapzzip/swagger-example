package com.zzapzzip.swagger.repository;

import com.zzapzzip.swagger.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
