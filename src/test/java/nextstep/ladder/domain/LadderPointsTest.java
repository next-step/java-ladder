package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPointsTest {

    private LadderPoints ladderPoints;

    @BeforeEach
    void init() {
        ladderPoints = LadderPoints.of(2, 2, new RandomLadderBarStatusDecider());
    }

    @DisplayName("next() : 다음 LadderPoint를 반환한다")
    @Test
    void next() {
        LadderPoint ladderPoint = ladderPoints.next(ladderPoints.head());

        assertThat(ladderPoint.getRow()).isEqualTo(0);
        assertThat(ladderPoint.getColumn()).isEqualTo(1);
    }

    @DisplayName("next() : 다음 column이 playerCount과 같으면 다음 row의 첫번째 LadderPoint를 반환한다")
    @Test
    void next_columnSameWithPlayerCount() {
        LadderPoint ladderPoint = ladderPoints.next(ladderPoints.get(0, 1));

        assertThat(ladderPoint.getRow()).isEqualTo(1);
        assertThat(ladderPoint.getColumn()).isEqualTo(0);
    }

    @DisplayName("next() : 마지막 칸이면 예외를 반환한다")
    @Test
    void next_fail_ifLastPoint() {
        LadderPoint ladderPoint = ladderPoints.get(2, 1);

        Assertions.assertThatThrownBy(() -> ladderPoints.next(ladderPoint))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("다음 값이 사다리 범위내에 존재하지 않습니다.");
    }

    @DisplayName("head() : 첫번째 LadderPoint를 반환한다")
    @Test
    void head() {
        LadderPoint head = ladderPoints.head();

        assertThat(head.getRow()).isEqualTo(0);
        assertThat(head.getColumn()).isEqualTo(0);
    }

    @DisplayName("get() : row와 column을 받아 LadderPoint를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void get(int row) {
        LadderPoint ladderPoint = ladderPoints.get(row, 1);

        assertThat(ladderPoint.getRow()).isEqualTo(row);
        assertThat(ladderPoint.getColumn()).isEqualTo(1);
    }
}