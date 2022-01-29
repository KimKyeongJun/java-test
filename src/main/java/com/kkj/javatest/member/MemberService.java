package com.kkj.javatest.member;

import com.kkj.javatest.domain.Member;
import com.kkj.javatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);

    void notify(Member member);
}
