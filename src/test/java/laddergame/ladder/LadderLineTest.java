package laddergame.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인은")
class LadderLineTest {

    private static final int USER_COUNT = 4;

    @DisplayName("사람 수가 생성자의 매개변수다")
    @Test
    void create() {
        assertThat(new LadderLine(USER_COUNT)).isEqualTo(new LadderLine(USER_COUNT));
    }

    @DisplayName("연결가능여부가 항상 false일 경우, 라인수는 0개")
    @Test
    void connection_false() {
        assertThat(
                new LadderLine(USER_COUNT, () -> false)
                        .points().stream()
                        .filter(point -> point.equals(true))
                        .count()
        ).isZero();
    }


    @DisplayName("연결 가능 여부가 항상 true일 경우 라인수는 1개 이상")
    @Test
    void connection_true() {
        assertThat(
                new LadderLine(USER_COUNT, () -> true)
                        .points().stream()
                        .filter(point -> point.equals(true))
                        .count()
        ).isNotZero();
    }

    @DisplayName("사람수-1 = 포인트 수") // TODO : 포인트 수 리네임
    @Test
    void pointsCount_equals_countOfPearson_minus_1() {
        assertThat(new LadderLine(USER_COUNT, () -> true).points().size()).isEqualTo(USER_COUNT - 1);
    }

}
