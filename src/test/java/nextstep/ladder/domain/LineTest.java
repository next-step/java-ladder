package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @ParameterizedTest
    @CsvSource(value = {"2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    void 라인길이(int input, int result) {
        assertThat(new Line(input)
                .size())
                .isEqualTo(result);
    }

    @Test
    void 최소_참여_인원_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Line(1);
                });
    }
}