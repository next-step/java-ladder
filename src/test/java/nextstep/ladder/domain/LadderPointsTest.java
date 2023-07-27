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
        ladderPoints = LadderPoints.of(3, 3, new RandomLadderBarStatusDecider());
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