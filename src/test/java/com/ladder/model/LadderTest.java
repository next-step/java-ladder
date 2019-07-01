package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ladder.model.Point.POINT_DOWN;
import static com.ladder.model.Point.POINT_LEFT;
import static com.ladder.model.Point.POINT_RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이(행)과 사람 수(열)을 기준으로 사다리를 생성한다")
    @Test
    void createLadder_success() {
        // given
        int numberOfPlayers = 4;
        int numberOfColumns = 6;

        // when
        Ladder ladder = Ladder.generate(numberOfColumns, numberOfPlayers);

        // then
        assertThat(ladder).isNotNull();
        assertThat(ladder.getLadder()).hasSize(numberOfColumns);
        assertThat(ladder.getLadder().get(0).getPoints()).hasSize(numberOfPlayers);
    }

    @DisplayName("시작 위치 입력 시 사다리 탄 결과 위치를 반환하는데 성공한다")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "3,3"})
    void playByPosition_inputPlayerPosition_success(int start, int end) {
        Position startPosition = Position.of(start);
        Position expectedPosition = Position.of(end);

        List lines = new ArrayList();
        lines.add(Line.of(Arrays.asList(POINT_RIGHT, POINT_LEFT, POINT_RIGHT, POINT_LEFT)));
        lines.add(Line.of(Arrays.asList(POINT_RIGHT, POINT_LEFT, POINT_DOWN, POINT_DOWN)));
        lines.add(Line.of(Arrays.asList(POINT_DOWN, POINT_DOWN, POINT_RIGHT, POINT_LEFT)));
        Ladder ladder = Ladder.of(Lines.of(lines));
        Position result = ladder.playByOnePosition(startPosition);

        assertThat(result).isEqualTo(expectedPosition);
    }
}
