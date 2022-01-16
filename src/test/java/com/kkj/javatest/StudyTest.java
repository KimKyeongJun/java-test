package com.kkj.javatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {


    @Test
    void create() {
        System.out.println("create");
    }

    @Test
    void create1() {
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