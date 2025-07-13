package study.min.aroundhub.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each\n");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each\n");
    }

    @Test
    void test1() {
        System.out.println("test1\n");
    }

    @Test
    @DisplayName("Test Case 2")
    void test2() {
        System.out.println("test2\n");
    }



    @Test
    @Disabled
    void test3() {
        System.out.println("test3\n");
    }
}
