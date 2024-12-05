package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 Ladder 객체를 생성한다.")
    @Test
    void create() {
        int position = 2;
        Lines lines = new Lines(List.of(TRUE, FALSE, TRUE));

        Ladder actual = new Ladder(position, lines);

        assertThat(actual).isEqualTo(new Ladder(new Position(position), new Lines(TRUE, FALSE, TRUE)));
    }

    @DisplayName("특정 높이의 사다리에서 움직일 수 있는 방향을 반환한다.")
    @Test
    void resolveMoveDirection() {
        Ladder leftLadder = new Ladder(0, new Lines(List.of(false, true)));
        Ladder given = new Ladder(1, new Lines(List.of(false, false)));

        PositionDirection actual = given.resolveMoveDirection(Optional.of(leftLadder), 1);

        assertThat(actual).isEqualTo(PositionDirection.LEFT);
    }

    @DisplayName("현재 위치의 사다리 혹은 왼쪽 사다리에 라인이 있으면 이동할 수 있다.")
    @CsvSource(value = {"false,false", "true,true"})
    @ParameterizedTest(name = "사다리세팅 여부: {0}, 이동가능 여부: {1}")
    void isMovable(boolean lineSettingYN, boolean expected) {
        Ladder leftLadder = new Ladder(0, new Lines(List.of(false, lineSettingYN)));
        Ladder ladder = new Ladder(1, new Lines(List.of(false, false)));

        boolean actual = ladder.isMovable(Optional.of(leftLadder), 1);

        assertThat(actual).isEqualTo(expected);
    }
}
