package com.kkj.javatest.study;

import com.kkj.javatest.domain.Study;
import com.kkj.javatest.domain.StudyStatus;
import com.kkj.javatest.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
@DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
public class StudyServiceQuiz2Test {

    @Test
    void openStudy(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        //Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");
        assertNull(study.getOpenedDateTime());
        given(studyRepository.save(study)).willReturn(study);


        //when
        studyService.openStudy(study);

        //Then
        assertEquals(StudyStatus.OPENED, study.getStatus());
        assertNotNull(study.getOpenedDateTime());
        then(memberService).should().notify(study);
    }

}
