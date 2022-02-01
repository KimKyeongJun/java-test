package com.kkj.javatest.study;

import com.kkj.javatest.domain.Member;
import com.kkj.javatest.domain.Study;
import com.kkj.javatest.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@Testcontainers
@Slf4j
@ContextConfiguration(initializers = StudyServiceDockerComposeTest.ContainerPropertyInitializer.class)
class StudyServiceDockerComposeTest {

    @Mock
    MemberService memberService;

    @Autowired
    private StudyRepository studyRepository;

    @Value("${container.port}")
    int port;

    @Container
    static DockerComposeContainer composeContainer =
            new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"))
                    .withExposedService("study-db", 5432);


    @Test
    void createNewStudy() {
        System.out.println("============");
        System.out.println(port);
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("v49011591@gmail.com");

        Study study = new Study(10, "테스트");


//        given(memberService.findById(1L)).willReturn(Optional.of(member));
////        given(studyRepository.save(study)).willReturn(study);
//
//        studyService.createNewStudy(1L, study);
//        assertEquals(member, study.getOwner());
//
//        then(memberService).should(times(1)).notify(member);
//        then(memberService).shouldHaveNoMoreInteractions();

    }

    // Compose Service 정보 참조
    static class ContainerPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of("container.port=" + composeContainer.getServicePort("study-db",5432))
                    .applyTo(context.getEnvironment());
        }
    }

}