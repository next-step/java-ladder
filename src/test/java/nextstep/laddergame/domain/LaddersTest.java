package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LaddersTest {
    @DisplayName("현재 위치의 사다리 혹은 왼쪽 사다리에 라인이 있으면 이동할 수 있다.")
    @CsvSource(value = {"false,false", "true,true"})
    @ParameterizedTest(name = "사다리세팅 여부: {0}, 이동가능 여부: {1}")
    void isMovableLadder(boolean lineSettingYN, boolean expected) {
        List<Boolean> lines = List.of(false, lineSettingYN);
        Ladders given = new Ladders(List.of(
                new Ladder(0, new Lines(lines)),
                new Ladder(1, new Lines(List.of(false, false)))));

        boolean actual = given.isMovableLadder(new Position(1), 4);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("현재 위치에서 이동 가능한 방향을 알려준다.")
    @Test
    void resolveMovableDirection() {
        Ladders given = new Ladders(List.of(
                new Ladder(0, new Lines(List.of(false, false))),
                new Ladder(1, new Lines(List.of(false, true))),
                new Ladder(2, new Lines(List.of(false, false)))));

        PositionDirection actual = given.resolveMoveDirection(new Position(1), 1);

        assertThat(actual).isEqualTo(PositionDirection.RIGHT);
    }
}
