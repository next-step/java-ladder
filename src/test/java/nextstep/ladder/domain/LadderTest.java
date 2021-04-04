package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @ParameterizedTest
    @DisplayName(value = "사다리 객체 생성")
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void ladderCreate(int input, int result) {
        assertThat(new Ladder(2, input)
                .size())
                .isEqualTo(result);
    }

    @Test
    @DisplayName(value = "허용 되지 않은 인자값")
    void ladderArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Ladder(2, 0);
                }).withMessageMatching("사다리의 최소 높이는 1보다 커야 합니다.");
    }
}