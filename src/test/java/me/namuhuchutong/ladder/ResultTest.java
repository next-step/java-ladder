package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.implement.wrapper.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("동일한 값을 가지고 있다면 동일한 객체이다.")
    @Test
    void if_values_are_same_then_they_are_same_objects() {
        String given = "hello";
        Result result1 = new Result(given);
        Result result2 = new Result(given);

        boolean actual = result1.equals(result2);

        assertThat(actual).isTrue();
    }

    @DisplayName("값이 다르다면 다른 객체이다.")
    @Test
    void if_values_are_not_same_then_they_are_same_not_objects() {
        String given1=  "hello";
        String given2 = "world";
        Result result1 = new Result(given1);
        Result result2 = new Result(given2);

        boolean actual = result1.equals(result2);

        assertThat(actual).isFalse();
    }

}