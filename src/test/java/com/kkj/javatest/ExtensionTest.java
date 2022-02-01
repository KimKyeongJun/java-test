package com.kkj.javatest;

import com.kkj.javatest.member.Study;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;


// UnderScore를 공백으로 치환
@ExtendWith(FindSlowTestExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExtensionTest {

    @BeforeAll
    static void beforeAl() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    int value = 1;

    @DisplayName("스터디 만들기")
    @FastTest
    @Order(2)
    void create_new_study() {
        System.out.println(value++);
        Study actual = new Study(value);
        assertThat(actual.getLimit()).isGreaterThan(0);

    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    @Order(1)
    @SlowTest
    void create_new_study_again() throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println(this);
        System.out.println("create1 " + value++);
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