package pku.wusj.newjunit;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;


import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;


@DisplayName("A special test case")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest
{
    static int id = 0;
    int myId;
    public AppTest(){
        myId = id++;
    }

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("all test start");
    }

    @BeforeEach
    void beforeEach()
    {
        System.out.println("a test start");
    }

    @AfterAll
    static void afterAll()
    {
        System.out.println("all test end");
    }

    @AfterEach
    void afterEach()
    {
        System.out.println("a test end");
    }

    @Test
    @DisplayName("╯°□°）╯")
    void test()
    {
        App obj = new App();
        assertEquals(1+1,obj.add(1,1));
        assertAll("heheda",
            () -> assertEquals(0+0,obj.add(0,0)),
            () -> assertEquals(-1+1,obj.add(-1,1))
            );
        System.out.println(myId);
    }

    @Test
    @DisplayName("😱")
    void test2()
    {
        App obj = new App();
        assertEquals(2+-3,obj.add(-3,2));
        System.out.println(myId);
    }

    @Test
    @Tag("taggedtest")
    void test3()
    {
        App obj = new App();
        assertEquals(-2+-9,obj.add(-2,-9));
        System.out.println(myId);
    }

    @Test
    void test4(){
        assertTimeout(ofMillis(10), () -> {
            Thread.sleep(1);
        });
    }

    @Test
    void test5()
    {
        App obj = new App();
        assumeTrue(1+1 == obj.add(1,1));
        System.out.println(myId);
    }

    @Test
    @EnabledOnOs(MAC)
    void test6()
    {
        System.out.println("a os test");
    }

    @Test
    @EnabledOnJre(JAVA_8)
    void test7()
    {
        System.out.println("a jre test");
    }


    @RepeatedTest(10)
    void test8()
    {
        System.out.println("hahaha");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "cruel", "world"})
    void test9(String para)
    {
        System.out.println(para);
    }

    @ParameterizedTest
    @CsvSource({"hello, 1", "cruel, 2", "world, 3"})
    void test10(String para,int times)
    {
        System.out.println(times);
        System.out.println(para);
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        fail("a fail test");
    }
}