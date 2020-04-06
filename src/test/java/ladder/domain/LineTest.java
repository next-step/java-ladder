package ladder.domain;

import ladder.domain.fake.FakeLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("참여자가 1명이라면 라인을 생성할 수 없다.")
    @Test
    void createLine_OnePlayer() {
        int playerCount = 1;
        Line line = Line.of(playerCount);

        List<Boolean> actual = line.getLine();

        assertThat(actual.get(0)).isFalse();
    }

    @DisplayName("참여자 1명, 라인이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @Test
    void moveOneByZero() {
        int playerCount = 1;
        int playerStartPosition = 0;
        Line line = Line.of(playerCount);

        int moveResult = line.move(playerStartPosition);

        assertThat(moveResult).isZero();
    }

    @DisplayName("참여자 2명, 라인이 존재하지 않으면 참여자 시작위치를 그대로 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void moveTwoByZero(int playerStartPosition) {
        int playerCount = 2;
        Line line = Line.of(playerCount, new FakeLineGenerator());

        int moveResult = line.move(playerStartPosition);

        assertThat(moveResult).isEqualTo(playerStartPosition);
    }
}