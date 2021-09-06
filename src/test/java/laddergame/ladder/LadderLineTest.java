package laddergame.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인은")
class LadderLineTest {

    private static final int USER_COUNT = 4;

    @DisplayName("연결 가능 여부가 항상 false: 연결된 곳은 0개")
    @Test
    void connectable_false() {
        assertThat(
                new LadderLine(USER_COUNT, () -> Connection.DISCONNECTED)
                        .connections().stream()
                        .filter(point -> point.equals(Connection.CONNECTED))
                        .count()
        ).isZero();
    }


    @DisplayName("연결 가능 여부가 항상 true: 연결된 곳은 1개 이상")
    @Test
    void connectable_true() {
        assertThat(
                new LadderLine(USER_COUNT, () -> Connection.CONNECTED)
                        .connections().stream()
                        .filter(point -> point.equals(Connection.CONNECTED))
                        .count()
        ).isNotZero();
    }

    @DisplayName("연결가능여부 수 : 참가자수보다 1 적다")
    @Test
    void pointsCount_equals_countOfPearson_minus_1() {
        assertThat(new LadderLine(USER_COUNT, () -> Connection.CONNECTED).connections().size())
                .isEqualTo(USER_COUNT - 1);
    }

}
