package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.implement.wrapper.OddNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class OddNumberTest {

    @DisplayName("홀수가 아닌 수는 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2})
    void throw_exception_when_given_number_is_negative_or_zero_or_edd(int given) {
        assertThatThrownBy(() -> new OddNumber(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 OddNumber 객체와 주어진 값은 같다.")
    @Test
    void given_odd_integer_is_same_as_odd_value() {
        int givenNumber = 1;
        int expected = givenNumber;

        OddNumber oddNumber = new OddNumber(givenNumber);
        int actual = oddNumber.getOdd();

        assertThat(actual).isEqualTo(expected);
    }
}