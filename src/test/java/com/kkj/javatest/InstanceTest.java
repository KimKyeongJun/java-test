package com.kkj.javatest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


// UnderScore를 공백으로 치환
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS)
class InstanceTest {

    @BeforeAll
    void beforeAl() {
        System.out.println("before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("after all");
    }

    int value = 1;

    @DisplayName("스터디 만들기")
    @FastTest
    void create_new_study() {
        System.out.println(value++);
        Study actual = new Study(value);
        assertThat(actual.getLimit()).isGreaterThan(0);

    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_new_study_again() {
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