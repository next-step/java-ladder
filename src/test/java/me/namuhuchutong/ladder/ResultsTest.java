package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.implement.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("주어진 인덱스가 범위를 벗어날 경우 예외가 발생한다")
    @Test
    void throw_exception_when_index_is_exceed() {
        String given = "1,2,3";
        Results createdResults = Results.from(given);
        int givenIndex = 10;

        assertThatThrownBy(() -> createdResults.getNthResult(givenIndex))
                .isInstanceOf(IllegalArgumentException.class);
    }

}