package nextstep.studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LinkedHashMapTest {

    @DisplayName("linkedHashMap 테스트")
    @Test
    void test() {
        // given
        Map<Integer, Integer> test = new LinkedHashMap<>();

        // when
        for (int i=0; i<5; i++) {
            test.put(i, i);
        }

        test.keySet().forEach(System.out::println);
        // then
        assertThat(test.keySet()).containsExactly(0,1,2,3,4);
    }

    @DisplayName("linkedHashMap 테스트")
    @Test
    void test2() {
        // given
        Map<Integer, Integer> test = new LinkedHashMap<>();

        // when
        test.put(1,1);
        test.put(3,1);
        test.put(4,1);
        test.put(2,1);

        test.keySet().forEach(System.out::println);
        // then
        assertThat(test.keySet()).containsExactly(1,3,4,2);
    }

    @DisplayName("linkedHashMap 테스트")
    @Test
    void test3() {
        // given
        Map<Integer, Integer> test = new HashMap<>();

        // when
        test.put(1,1);
        test.put(3,1);
        test.put(4,1);
        test.put(2,1);

        test.keySet().forEach(System.out::println);
        // then
        assertThat(test.keySet()).containsExactly(1,2,3,4);
    }
}
