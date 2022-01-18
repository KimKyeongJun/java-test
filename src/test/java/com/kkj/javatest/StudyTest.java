package com.kkj.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.test.web.servlet.result.JsonPathResultMatchersDsl;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;


// UnderScore를 공백으로 치환
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {


    @DisplayName("스터디 만들기")
//    @EnabledOnOs(OS.MAC)
    @FastTest
    void create_new_study() {
//        String test_env = System.getenv("TEST_ENV");
//        System.out.println(test_env);
//        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));
//
//        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
//            System.out.println("local");
//            Study actual = new Study(10);
//            assertThat(actual.getLimit()).isGreaterThan(0);
//        });ㅔ

        Study actual = new Study(10);
        System.out.println("Fast 실행");
        assertThat(actual.getLimit()).isGreaterThan(0);

//        assertTimeout(Duration.ofMillis(100),()-> {
//            new Study(10);
//            Thread.sleep(300);
//        });


//        Study study = new Study(-10);
//
//        IllegalArgumentException exception =
//                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
//        String message = exception.getMessage();
//        assertEquals("limit은 0보다 커야한다.", message);
//
//        assertAll(
//                ()->assertNotNull(study),
//                ()->assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + "상태다"),
//                ()->assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
//        );
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @Tag("slow")
    void create_new_study_again() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAl() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }
}