package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDtoPointTest {

    @DisplayName("첫번째 점 테스트")
    @RepeatedTest(10)
    void firstLadderPointTest() {
        LadderPoint ladderPoint = new LadderPoint();
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 점 테스트 - left")
    @RepeatedTest(10)
    void lastLadderPointLeftTest() {
        LadderPoint before = new LadderPoint(true, false);
        LadderPoint ladderPoint = new LadderPoint(before, 2, 2);
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 점 테스트 - right")
    @RepeatedTest(10)
    void lastLadderPointRightTest() {
        LadderPoint before = new LadderPoint(false, true);
        LadderPoint ladderPoint = new LadderPoint(before, 2, 2);
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.RIGHT);
    }

    @DisplayName("다음 점 테스트 - left")
    @RepeatedTest(10)
    void nextLadderPointLeftTest() {
        LadderPoint before = new LadderPoint(true, false);
        LadderPoint ladderPoint = new LadderPoint(before, 1, 2);
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("다음 점 테스트 - right")
    @RepeatedTest(10)
    void nextLadderPointRightTest() {
        LadderPoint before = new LadderPoint(false, true);
        LadderPoint ladderPoint = new LadderPoint(before, 1, 2);
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.RIGHT);
    }

}
