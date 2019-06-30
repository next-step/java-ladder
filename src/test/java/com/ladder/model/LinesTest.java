package com.ladder.model;

import com.ladder.exception.LadderColumnsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LinesTest {

    @DisplayName("사다리 높이 개수만큼 라인을 생성한다")
    @Test
    void createLines_success() {
        // given
        int numberOfPlayers = 4;
        int numberOfColumns = 6;

        // when
        Lines lines = Lines.of(numberOfColumns, numberOfPlayers);

        // then
        assertThat(lines).isNotNull();
        assertThat(lines.getLines()).hasSize(6);
    }

    @DisplayName("사다리 높이 또는 플레이어의 수가 0보다 작을 시 exception")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createLines_noPositive_exception(int numberOfColumns) {
        assertThatExceptionOfType(LadderColumnsException.class)
                .isThrownBy(() -> Lines.of(numberOfColumns, 1));
    }
}