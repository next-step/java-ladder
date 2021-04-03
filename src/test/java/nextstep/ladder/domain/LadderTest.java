package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void 사다리_생성(int input, int result) {
        assertThat(new Ladder(2, input)
                .size())
                .isEqualTo(result);
    }

    @Test
    void 사다리_높이() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Ladder(2, 0);
                });
    }
}