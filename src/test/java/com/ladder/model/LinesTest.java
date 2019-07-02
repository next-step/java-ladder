package com.ladder.model;

import com.ladder.exception.LadderColumnsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static com.ladder.model.Direction.*;
import static com.ladder.model.LineTest.ofLine;
import static com.ladder.model.Lines.MIN_NUMBER_OF_COLUMNS;
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

    @DisplayName("사다리 높이 또는 플레이어의 수가 " + MIN_NUMBER_OF_COLUMNS + "보다 작을 시 생성에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {MIN_NUMBER_OF_COLUMNS - 1, MIN_NUMBER_OF_COLUMNS - 2})
    void createLines_noPositive_exception(int numberOfColumns) {
        assertThatExceptionOfType(LadderColumnsException.class)
                .isThrownBy(() -> Lines.of(numberOfColumns, 1));
    }

    @DisplayName("시작 위치 입력 시 사다리 탄 결과 위치를 반환하는데 성공한다")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "3,3"})
    void playByPosition_inputPlayerPosition_success(int start, int end) {
        // given
        Position startPosition = Position.of(start);
        Position expectedPosition = Position.of(end);

        // when
        List<Line> linesList = new ArrayList<>();
        linesList.add(ofLine(RIGHT, LEFT, RIGHT, LEFT));
        linesList.add(ofLine(RIGHT, LEFT, DOWN, DOWN));
        linesList.add(ofLine(DOWN, DOWN, RIGHT, LEFT));
        Lines lines = Lines.of(linesList);
        Position result = lines.playByOnePosition(startPosition);

        // then
        assertThat(result).isEqualTo(expectedPosition);
    }
}