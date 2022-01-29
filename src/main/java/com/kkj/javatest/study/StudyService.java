package com.kkj.javatest.study;

import com.kkj.javatest.domain.Member;
import com.kkj.javatest.domain.Study;
import com.kkj.javatest.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);

        study.setOwner(member.orElseThrow(() ->  new IllegalArgumentException("Member doesn't exise for id: " + memberId)));
        return studyRepository.save(study);
    }
}
